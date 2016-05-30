import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class sherlock_and_the_beast {
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
         // System.out.println(cas);
         System.out.println(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      int digitCount;

      public Case(Scanner scanner) {
         digitCount = scanner.nextInt();
      }

      public String process() {
         Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
         hash.put(3, 0);
         hash.put(5, 0);
         boolean found = false;
         while (true)
         {
            // first, look for a number divisible by 3 (as opposed to divisible by 5),
            // because we want to find as many 5's in the resulting string as possible
            // Note that this if condition allows for numbers such as 3 and 4 to be
            // evaluated before the elsif condition
            if (digitCount % 3 == 0)
            {
               // found a combination of 3's and 5's that add up to number
               hash.put(3, hash.get(3) + digitCount/3);
               found = true;
               break;
            }
            else if (digitCount >= 5)
            {
               digitCount -= 5;
               hash.put(5, hash.get(5) + 1);
            }
            else
               break;
         }

         // construct the resulting string
         StringBuilder builder = new StringBuilder();
         if (found)
         {
            for (int i = 0; i < hash.get(3); i++)
               builder.append("555");
            for (int i = 0; i < hash.get(5); i++)
               builder.append("33333");
         }
         else
            builder.append("-1");

         return builder.toString();
      }
   }
}
