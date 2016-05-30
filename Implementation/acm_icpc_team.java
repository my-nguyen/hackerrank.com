import java.util.*;
import java.math.*;

class acm_icpc_team {
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
         System.out.print(cas.process());
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      List<String> knowledgePeople = new ArrayList<>();

      public Case(Scanner scanner) {
         int personCount = scanner.nextInt();
         int topicCount = scanner.nextInt();
         for (int i = 0; i < personCount; i++)
            knowledgePeople.add(scanner.next());
      }

      public String process()
      {
         int maxTopics = 0;
         int maxTeams = 0;
         for (int left = 0; left < knowledgePeople.size()-1; left++) {
            for (int right = left+1; right < knowledgePeople.size(); right++) {
               // First, convert the 32-bit strings back to BigIntegers
               BigInteger leftBinary = new BigInteger(knowledgePeople.get(left), 2);
               BigInteger rightBinary = new BigInteger(knowledgePeople.get(right), 2);
               // Next, perform a bitwise OR operation
               BigInteger bitwiseOr = leftBinary.or(rightBinary);
               // Then, count the number of 1-bits in the result
               int bitCount = bitwiseOr.bitCount();
               // found a new maximum number of topics
               if (maxTopics < bitCount) {
                  maxTopics = bitCount;
                  maxTeams = 1;
               } else if (maxTopics == bitCount)
                  // the number of teams that know the maximum number of topics
                  maxTeams += 1;
            }
         }

         StringBuilder builder = new StringBuilder();
         builder.append(maxTopics).append("\n").append(maxTeams).append("\n");
         return builder.toString();
      }
   }
}
