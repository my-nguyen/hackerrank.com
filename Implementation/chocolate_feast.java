import java.util.*;

class chocolate_feast {
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
      int pocketAmount, chocolatePrice, discount;

      public Case(Scanner scanner) {
         pocketAmount = scanner.nextInt();
         chocolatePrice = scanner.nextInt();
         discount = scanner.nextInt();
      }

      public int process() {
         // the number of wrappers based on the dollar amount
         int wrappers = pocketAmount / chocolatePrice;
         // oririnally, chocolates is the same as wrappers
         int chocolateCounts = wrappers;

         // start the exchange based on the number of wrappers and offer discount
         while (wrappers >= discount) {
            // exchange wrappers for chocolates
            int exchange = wrappers / discount;
            chocolateCounts += exchange;
            // the number of wrappers includes the number of chocolates obtained from
            // the exchange, plus the number of wrappers left over from the exchange
            wrappers = exchange + (wrappers % discount);
         }
         return chocolateCounts;
      }
   }
}
