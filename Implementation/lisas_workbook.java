import java.util.*;

class lisas_workbook {
   public static void main(String[] args) {
      process(read());
   }

   private static List<Case> read() {
      List<Case> cases = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      cases.add(new Case(scanner));
      scanner.close();
      return cases;
   }

   private static void process(List<Case> cases) {
      for (Case cas : cases)
         System.out.println(cas.process());
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      // max number of problems per page
      int maxPerPage;
      // number of problems in each chapter
      List<Integer> chapters = new ArrayList<>();

      public Case(Scanner scanner) {
         int pageCount = scanner.nextInt();
         maxPerPage = scanner.nextInt();
         for (int i = 0; i < pageCount; i++)
            chapters.add(scanner.nextInt());
      }

      public int process() {
         // build a list of pages; each page contains between 1 and maxPerPage
         // problems
         List<List<Integer>> pages = new ArrayList<List<Integer>>();
         for (int chapter : chapters) {
            List<Integer> page = null;
            for (int i = 0; i < chapter; i++) {
               // a new page is necessary once a problem number goes beyond the
               // maximum per page
               if (i % maxPerPage == 0) {
                  page = new ArrayList<>();
                  pages.add(page);
               }
               // add problem number to the current page
               page.add(i);
            }
         }

         // go thru the pages and tally the pages whose number matches a problem
         // number on that page
         int total = 0;
         for (int i = 0; i < pages.size(); i++) {
            for (int number : pages.get(i))
               if (number == i) {
                  // System.out.println(i);
                  total += 1;
               }
         }
         return total;
      }
   }
}
