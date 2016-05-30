import java.util.*;

class taum_and_bday {
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
         // System.out.println(cas);
         System.out.println(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      long blackCount;
      long whiteCount;
      long blackCost;
      long whiteCost;
      long conversionCost;

      public Case(Scanner scanner) {
         blackCount = scanner.nextLong();
         whiteCount = scanner.nextLong();
         blackCost = scanner.nextLong();
         whiteCost = scanner.nextLong();
         conversionCost = scanner.nextLong();
      }

      public long process() {
         if (blackCost + conversionCost < whiteCost)
            return blackCount*blackCost + whiteCount*(blackCost+conversionCost);
         else if (whiteCost + conversionCost < blackCost)
            return whiteCount*whiteCost + blackCount*(whiteCost+conversionCost);
         else
            return blackCount*blackCost + whiteCount*whiteCost;
      }

      @Override
      public String toString() {
         return blackCount + " " + whiteCount + "\n" +
                blackCost + " " + whiteCost + " " + conversionCost;
      }
   }
}
