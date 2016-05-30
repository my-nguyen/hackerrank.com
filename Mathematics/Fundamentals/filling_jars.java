import java.util.*;

class filling_jars {
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
         System.out.println(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      // must use Long instead of Integer to represent the numbers, since the
      // operations, including the range (index_b - index_a), the number of
      // candies, and the multiplication all could push the result over the
      // limits of an integer
      int jarCount;
      long[] lowerBounds, upperBounds, candyCounts;

      public Case(Scanner scanner) {
         jarCount = scanner.nextInt();
         int operationCount = scanner.nextInt();
         lowerBounds = new long[operationCount];
         upperBounds = new long[operationCount];
         candyCounts = new long[operationCount];
         for (int i = 0; i < operationCount; i++) {
            lowerBounds[i] = scanner.nextLong();
            upperBounds[i] = scanner.nextLong();
            candyCounts[i] = scanner.nextLong();
         }
      }

      public long process()
      {
         long sum = 0;
         for (int i = 0; i < lowerBounds.length; i++)
            // upperBounds[i]-lowerBounds[i]+1 refers to all array elements from
            // lower bound to upper bound, inclusive. at each iteration, the
            // number of candies filled in all array elements from lower bound
            // to upper bound inclusive is added to the total. and at the end of
            // the loop, the sum will be all candies filled in all ranges
            // (lower-upper) of all operations
            sum += (upperBounds[i]-lowerBounds[i]+1) * candyCounts[i];

         // return the average candies per jar
         return sum / jarCount;
      }
   }
}
