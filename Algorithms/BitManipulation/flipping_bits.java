import java.util.*;

class flipping_bits {
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
      long number;

      public Case(Scanner scanner) {
         number = scanner.nextLong();
      }

      public long process()
      {
         // subtracting 1 is a trick to flip an unsigned 32-bit integer correctly.
         long negative = -number - 1;
         // convert from a long to a 64-bit string, then chop the results to a 32-bit
         // string
         String binary = Long.toBinaryString(negative).substring(32);
         // convert the 32-bit string back to a long integer
         return Long.parseLong(binary, 2);
      }
   }
}
