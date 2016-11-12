import java.util.*;

class maximizing_xor {
   public static void main(String[] args) {
      process(read());
   }

   private static List<Case> read() {
      List<Case> cases = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      int caseCount = 1;
      for (int i = 0; i < caseCount; i++)
         cases.add(new Case(scanner));
      scanner.close();
      return cases;
   }

   private static void process(List<Case> cases) {
      for (Case cas : cases) {
         // System.out.println(cas);
         System.out.println(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      int lowerBound, upperBound;

      public Case(Scanner scanner) {
         lowerBound = scanner.nextInt();
         upperBound = scanner.nextInt();
      }

      public int process()
      {
         int max = 0;
         // look for the biggest xor of any two numbers between lower and upper
         // bounds, inclusive
         for (int left = lowerBound; left < upperBound; left++)
            for (int right = left+1; right <= upperBound; right++)
               // max = Math.max(max, (left^right));
               if (max < (left^right))
                  max = left^right;
         return max;
      }

      @Override
      public String toString() {
         return lowerBound + " " + upperBound;
      }
   }
}
