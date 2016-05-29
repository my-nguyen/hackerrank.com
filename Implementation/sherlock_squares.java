import java.util.*;

class sherlock_squares {
   public static void main(String[] args) {
      process(read());
   }

   private static List<Case> read() {
      List<Case> cases = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      int caseCount = scanner.nextInt();
      for (int i = 0; i < caseCount; i++)
         cases.add(new Case(scanner));
      scanner.close();
      return cases;
   }

   private static void process(List<Case> cases) {
      for (Case cas : cases) {
         System.out.println(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      private static final int SQUARE_MAX = 100000;
      private static long[] squares;
      private long lower, upper;

      static {
         squares = new long[SQUARE_MAX];
         for (int i = 0; i < SQUARE_MAX; i++)
            squares[i] = (i+1) * (i+1);
      }

      public Case(Scanner scanner) {
         lower = scanner.nextLong();
         upper = scanner.nextLong();
      }

      // find the smallest square that is greater than or equal the number
      private long equal(long number)
      {
         for (int i = 0; i < SQUARE_MAX; i++)
            // with the list array containing square numbers that are so large, it is
            // guaranteed that a square will eventually be greater than given number
            if (squares[i] >= number)
               return i;

         // this point is never reached; but the method has to return something,
         // since the Java compiler requires a return statement
         return 0;
      }

      // find the smallest square that is greater than the number
      private long greater(long number)
      {
         for (int i = 0; i < SQUARE_MAX; i++)
            if (squares[i] > number)
               return i;
         return 0;
      }

      // return the number of squares between lower bound and upper bound, inclusive
      private long process()
      {
         return greater(upper) - equal(lower);
      }
   }
}
