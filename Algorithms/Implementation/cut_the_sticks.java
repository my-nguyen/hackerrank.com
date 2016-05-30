import java.util.*;

class cut_the_sticks {
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
         System.out.print(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      List<Integer> stickLengths = new ArrayList<>();
      List<Integer> stickCounts = new ArrayList<>();

      public Case(Scanner scanner) {
         int stickCounts = scanner.nextInt();
         for (int i = 0; i < stickCounts; i++)
            stickLengths.add(scanner.nextInt());
      }

      public String process() {
         StringBuilder builder = new StringBuilder();
         cutSticks();
         for (int stickCount : stickCounts)
            builder.append(stickCount).append("\n");
         return builder.toString();
      }

      private void cutSticks() {
         Collections.sort(stickLengths);
         // number of sticks that are left before each subsequent cut operations
         while (!stickLengths.isEmpty()) {
            // current stickLengths size is the current number of sticks
            stickCounts.add(stickLengths.size());
            // first list element has the smallest value since list is sorted
            Integer minimum = stickLengths.get(0);
            // remove those elements that equal the minimum
            Iterator<Integer> itr = stickLengths.iterator();
            while (itr.hasNext() && itr.next().equals(minimum))
               itr.remove();
         }
      }
   }
}
