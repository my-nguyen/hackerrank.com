import java.util.*;

class manasa_and_stones {
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
      int stoneCount, a, b;

      public Case(Scanner scanner) {
         stoneCount = scanner.nextInt();
         a = scanner.nextInt();
         b = scanner.nextInt();
      }

      public String process()
      {
         // Using Set saves huge amount of space, and Set operations are fast too!
         // If using array, an array doubles in size at each iteration.
         // With a Set, the size only increases by 1 at each iteration.
         // Also TreeSet was chosen instead of HashSet in order to preserve sorting
         // order of elements
         Set<Integer> set = new TreeSet<Integer>();
         // Special case when a == b and stones == 2
         set.add(a);
         if (a != b)
            set.add(b);

         for (int i = 0; i < stoneCount-2; i++) {
            Set<Integer> tmp = new TreeSet<Integer>();
            for (Integer number : set) {
               tmp.add(number + a);
               tmp.add(number + b);
            }

            set.clear();
            set.addAll(tmp);
         }

         return setToString(set);
      }

      private String setToString(Set<Integer> set) {
         StringBuilder builder = new StringBuilder();
         for (int number : set)
            builder.append(number).append(" ");
         return builder.toString();
      }
   }
}
