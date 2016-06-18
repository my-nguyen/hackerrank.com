import java.util.*;

class encryption {
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
      String text;
      char[][] matrix;

      public Case(Scanner scanner) {
         text = scanner.next();
      }

      public String process() {
         int length = text.length();
         double root = Math.sqrt(length);
         int columnCount = (int)Math.ceil(root);
         int rowCount = (int)Math.floor(root);
         // must meet the condition of rowCount * columnCount >= length
         if (rowCount * columnCount < length)
            rowCount += 1;

         // build a matrix with rowCount and columnCount as defined above
         matrix = new char[rowCount][columnCount];
         for (int i = 0; i < length; i++) {
            int row = i / columnCount;
            int column = i % columnCount;
            matrix[row][column] = text.charAt(i);
         }

         // extract the columns
         StringBuilder builder = new StringBuilder();
         for (int j = 0; j < columnCount; j++) {
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < rowCount; i++) {
               if (i * columnCount + j < length)
                  string.append(matrix[i][j]);
            }
            builder.append(string).append(" ");
         }
         return builder.toString();
      }

      @Override
      public String toString() {
         StringBuilder builder = new StringBuilder();
         builder.append(text).append("\n");
         // builder.append(matrix.length).append("\n");
         for (int i = 0; i < matrix.length; i++) {
            builder.append(matrix[i]).append("\n");
         }
         return builder.toString();
      }
   }
}
