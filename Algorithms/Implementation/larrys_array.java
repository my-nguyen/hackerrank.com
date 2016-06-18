import java.util.*;

class larrys_array {
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

      public Case(Scanner scanner) {
         text = scanner.next();
      }

      public String process() {
      }

      @Override
      public String toString() {
         StringBuilder builder = new StringBuilder();
         return builder.toString();
      }
   }
}
