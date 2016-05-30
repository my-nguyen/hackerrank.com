import java.util.*;

class love_letter_mystery {
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
      String string;

      public Case(Scanner scanner) {
         string = scanner.next();
      }

      // helper method that processes one single string and returnes one integer
      public int process()
      {
         int count = 0;
         int length = string.length();
         for (int left = 0; left < length/2; left++) {
            // right index operates from right to left
            int right = length - 1 - left;
            // increase count by the absolute difference in the 2 characters found
            // at left and right indices
            count += Math.abs(string.charAt(right) - string.charAt(left));
         }
         return count;
      }
   }
}
