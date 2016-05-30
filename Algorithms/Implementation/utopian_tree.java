import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class utopian_tree
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
      int cycleCount;

      public Case(Scanner scanner) {
         cycleCount = scanner.nextInt();
      }

      public int process()
      {
         int growth = 1;
         for (int i = 0; i < cycleCount; i++)
         {
            // spring growth: double in height
            if (i % 2 == 0)
               growth *= 2;
            // summer growth: just add 1 meter
            else
               growth += 1;
         }
         return growth;
      }
   }
}
