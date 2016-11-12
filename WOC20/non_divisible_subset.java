import java.util.*;

class non_divisible_subset {
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
      int target;
      List<Integer> numbers = new ArrayList<>();

      public Case(Scanner scanner) {
         int size = scanner.nextInt();
         target = scanner.nextInt();
         for (int i = 0; i < size; i++)
            numbers.add(scanner.nextInt());
      }

      public int process() {
         List<Integer> list = new ArrayList<>();
         int max = 0;
         for (int i = 0; i < numbers.size(); i++) {
            // build a new "list" with a different starting "anchor" value
            // obtained from "numbers" at every loop
            list.clear();
            list.add(numbers.get(i));
            for (int j = 0; j < numbers.size(); j++) {
               // try all the remaining values (non-anchor) of "numbers"
               if (j != i) {
                  // try adding that value with each value in "list", making sure
                  // the sum is not divisible by "target"
                  boolean divisible = false;
                  for (int k = 0; k < list.size(); k++) {
                     if ((numbers.get(j) + list.get(k)) % target == 0) {
                        divisible = true;
                        break;
                     }
                  }
                  if (!divisible)
                     list.add(numbers.get(j));
               }
            }
            // System.out.println(list);
            max = Math.max(max, list.size());
         }
         return max;
      }
   }
}
