import java.util.*;

class angry_professor {
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
      for (Case cas : cases)
         System.out.println(cas.classCancelled() ? "YES" : "NO");
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      int cancelThreshold;
      List<Integer> arrivalTimes = new ArrayList<>();

      public Case(Scanner scanner) {
         int studentTotal = scanner.nextInt();
         cancelThreshold = scanner.nextInt();
         for (int i = 0; i < studentTotal; i++)
            arrivalTimes.add(scanner.nextInt());
      }

      public boolean classCancelled() {
         int studentPresent = 0;
         for (int arrivalTime : arrivalTimes) {
            // keep count of those students whose arrival time is non-positive
            if (arrivalTime <= 0) {
               studentPresent += 1;
               // if going beyond the cancellation threshold, this class is
               // active, and there's no need to loop any further
               if (studentPresent >= cancelThreshold)
                  return false;
            }
         }
         return true;
      }
   }
}
