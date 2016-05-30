import java.util.*;

class library_fine {
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
         System.out.println(cas);
         // System.out.println(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      Date actualReturn;
      Date expectedReturn;

      public Case(Scanner scanner) {
         actualReturn = new Date(scanner);
         expectedReturn = new Date(scanner);
      }

      public int process() {
         if (actualReturn.year > expectedReturn.year)
            return 10000;
         if (actualReturn.year < expectedReturn.year)
            return 0;
         int months = actualReturn.month - expectedReturn.month;
         if (months > 0)
            return 500 * months;
         if (months < 0)
            return 0;
         int days = actualReturn.day - expectedReturn.day;
         if (days > 0)
            return 15 * days;
         else
            return 0;
      }

      @Override
      public String toString() {
         return actualReturn + "\n" + expectedReturn;
      }

      class Date {
         int day;
         int month;
         int year;

         public Date(Scanner scanner) {
            day = scanner.nextInt();
            month = scanner.nextInt();
            year = scanner.nextInt();
         }

         @Override
         public String toString() {
            return day + " " + month + " " + year;
         }
      }
   }
}
