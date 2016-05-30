import java.util.*;

class sherlock_and_array {
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
      List<Integer> numbers = new ArrayList<>();

      public Case(Scanner scanner) {
         int count = scanner.nextInt();
         for (int i = 0; i < count; i++)
            numbers.add(scanner.nextInt());
      }

      private long sum(List<Integer> list, int low, int high)
      {
         long sum = 0;
         for (int i = low; i <= high; i++)
            sum += list.get(i);
         return sum;
      }

      private String process()
      {
         if (numbers.size() == 1)
            return "YES";
         else if (numbers.size() == 2)
            return "NO";
         else {
            // (1) have a pivot that moves from 1 to next to last element of array
            // (2) pre-calculate 2 sums: one to the left and one to the right of pivot
            long sumLeft = numbers.get(0);
            long sumRight = sum(numbers, 2, numbers.size()-1);
            for (int pivot = 1; pivot < numbers.size()-1; pivot++) {
               if (sumLeft == sumRight)
                  return "YES";
               else {
                  // if the sums on the 2 sides of the pivot don't equate, then move
                  // the pivot to the right, and adjust the 2 sums accordingly.
                  sumLeft += numbers.get(pivot);
                  sumRight -= numbers.get(pivot+1);
               }
            }
            return "NO";
         }
      }
   }
}
