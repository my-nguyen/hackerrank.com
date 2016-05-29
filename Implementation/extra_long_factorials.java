import java.math.*;
import java.util.*;

class extra_long_factorials {
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
      int number;

      public Case(Scanner scanner) {
         number = scanner.nextInt();
      }

      public BigInteger process() {
         BigInteger factorial = BigInteger.ONE;
         BigInteger target = new BigInteger("" + number);
         for (BigInteger i = new BigInteger("2"); i.compareTo(target) <= 0; i = i.add(BigInteger.ONE)) {
            factorial = factorial.multiply(i);
         }
         return factorial;
      }

      @Override
      public String toString() {
         return "" + number;
      }
   }
}
