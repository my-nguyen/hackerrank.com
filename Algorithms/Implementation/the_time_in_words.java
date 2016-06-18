import java.util.*;

class the_time_in_words {
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
      int hours, minutes;
      String[] words = {
         "one", "two", "three", "four", "five",
         "six", "seven", "eight", "nine", "ten",
         "eleven", "twelve", "thirteen", "fourteen", "fifteen",
         "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
         "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
         "twenty six", "twenty seven", "twenty eight", "twenty nine"
      };

      public Case(Scanner scanner) {
         hours = scanner.nextInt();
         minutes = scanner.nextInt();
      }

      public String process() {
         if (minutes == 0) {
            return words[hours-1] + " o' clock";
         } else if (minutes == 15) {
            return "quarter past " + words[hours-1];
         } else if (minutes < 30) {
            return words[minutes-1] + " minutes past " + words[hours-1];
         } else if (minutes == 30) {
            return "half past " + words[hours-1];
         } else if (minutes == 45) {
            return "quarter to " + words[hours];
         } else {
            return words[60-minutes-1] + " minutes to " + words[hours];
         }
      }

      @Override
      public String toString() {
         return hours + ":" + minutes;
      }
   }
}
