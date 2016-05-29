import java.util.*;

class caesar_cipher {
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
         // System.out.println(cas);
         System.out.println(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      String string;
      int offset;

      public Case(Scanner scanner) {
         int stringLength = scanner.nextInt();
         string = scanner.next();
         offset = scanner.nextInt();
      }

      public String process() {
         StringBuilder builder = new StringBuilder();
         // shift one character at a time
         for (char letter : string.toCharArray())
            builder.append(shift(letter));
         return builder.toString();
      }

      private char shift(char letter) {
         char result = letter;
         // lowercase letter
         if (letter >= 'a' && letter <= 'z') {
            String lowercase = "abcdefghijklmnopqrstuvwxyz";
            // current position of letter relative to letter 'a'
            int position = letter - 'a';
            // next position of letter after encoding (shifting), taking into
            // account looping around (from z loop to a)
            int shiftPosition = (position + offset) % 26;
            result = lowercase.charAt(shiftPosition);
         }
         // uppercase letter
         else if (letter >= 'A' && letter <= 'Z') {
            String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int position = letter - 'A';
            int shiftPosition = (position + offset) % 26;
            result = uppercase.charAt(shiftPosition);
         }
         else
            result = letter;
         return result;
      }

      @Override
      public String toString() {
         return "string: " + string + ", offset: " + offset;
      }
   }
}
