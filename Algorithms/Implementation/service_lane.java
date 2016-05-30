import java.util.*;

class service_lane {
   private static List<Integer> widths = new ArrayList<>();

   public static void main(String[] args) {
      process(read());
   }

   private static List<Case> read() {
      List<Case> cases = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      int freewayLength = scanner.nextInt();
      int caseCount = scanner.nextInt();
      for (int i = 0; i < freewayLength; i++)
         widths.add(scanner.nextInt());
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
      int entryIndex, exitIndex;

      public Case(Scanner scanner) {
         entryIndex = scanner.nextInt();
         exitIndex = scanner.nextInt();
      }

      public int process()
      {
         // widths[entryIndex..exitIndex] is the range in which to find the minimum
         List<Integer> subWidths = widths.subList(entryIndex, exitIndex+1);
         // make a copy of the range
         List<Integer> copy = new ArrayList<Integer>(subWidths);
         // sort the copy
         Collections.sort(copy);
         // return the first entry of the sorted copy
         return copy.get(0);
      }

      @Override
      public String toString() {
         return entryIndex + " " + exitIndex;
      }
   }
}
