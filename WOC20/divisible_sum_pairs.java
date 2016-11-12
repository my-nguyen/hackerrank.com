import java.util.*;

class divisible_sum_pairs {
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
      int target;
      List<Integer> numbers = new ArrayList<>();

      public Case(Scanner scanner) {
         int size = scanner.nextInt();
         target = scanner.nextInt();
         for (int i = 0; i < size; i++)
            numbers.add(scanner.nextInt());
      }

      public int process() {
         int total = 0;
         for (int i = 0; i < numbers.size()-1; i++) {
            for (int j = i+1; j < numbers.size(); j++) {
               if ((numbers.get(i) + numbers.get(j)) % target == 0)
                  total += 1;
            }
         }
         return total;
      }

      @Override
      public String toString() {
         StringBuilder builder = new StringBuilder();
         builder.append(target).append("\n");
         for (int number : numbers)
            builder.append(number).append(" ");
         return builder.toString();
      }
   }
}
