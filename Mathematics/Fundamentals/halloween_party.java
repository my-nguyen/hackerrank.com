import java.util.*;

class halloween_party {
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
      int cutCount;

      public Case(Scanner scanner) {
         cutCount = scanner.nextInt();
      }

      public long process()
      {
         // number of chocolate pieces
         long chocolates = 0;
         int increment = 0;
         // assuming there's at least 2 cuts
         for (int cut = 2; cut <= cutCount; cut++) {
            // increase 'increment' by one at every two cuts
            if (cut % 2 == 0)
               increment += 1;
            chocolates += increment;
         }
         return chocolates;
      }
   }
}
