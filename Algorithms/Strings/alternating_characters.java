import java.util.*;

class alternating_characters {
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

      public int process()
      {
         int left = 0;
         int count = 0;
         // with StringBuiler, you can delete any character at any random index
         StringBuilder mutable = new StringBuilder(string);
         while (true) {
            // right index operates from the right of left index and keeps
            // looking for and deleting characters in sequence that match the
            // character at left index
            int right = left+1;
            while (right < mutable.length() && mutable.charAt(left) == mutable.charAt(right)) {
               // StringBuilder type comes in handy here
               mutable.deleteCharAt(right);
               count += 1;
            }

            // exit scenario when left is at the end of string
            if (left == mutable.length()-1)
               break;
            else
               left += 1;
         }
         return count;
      }
   }
}
