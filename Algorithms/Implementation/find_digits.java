import java.util.*;

class find_digits
{
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
      String number;

      public Case(Scanner scanner) {
         number = scanner.next();
      }

      public int process() {
         int count = 0;
         int value = Integer.parseInt(number);
         for (int i = 0; i < number.length(); i++)
         {
            int digit = (int)(number.charAt(i) - '0');
            // count the number of non-zero digits that is divisible by value
            if (digit != 0 && value % digit == 0)
               count += 1;
         }
         return count;
      }
   }
}
