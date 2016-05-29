import java.util.*;

class the_grid_search {
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
         // System.out.print(cas);
         System.out.println(cas.match() ? "YES" : "NO");
      }
   }

   // class is static so objects can be instantiated in read() a static method
   static class Case {
      List<String> grid;
      List<String> pattern;

      public Case(Scanner scanner) {
         grid = read(scanner);
         pattern = read(scanner);
      }

      @Override
      public String toString() {
         StringBuilder builder = new StringBuilder();
         builder.append("GRID:\n");
         for (String string : grid)
            builder.append(string).append("\n");
         builder.append("PATTERN:\n");
         for (String string : pattern)
            builder.append(string).append("\n");
         return builder.toString();
      }

      public boolean match() {
         // scan all rows in grid for a match with motif
         for (int row = 0; row < grid.size(); row++) {
            // index to substring of the current row of grid; starts at 0
            int substringIndex = 0;
            while (true) {
               // substring of the current row of grid
               String substring = grid.get(row).substring(substringIndex);
               // first row of pattern
               String motif = pattern.get(0);
               // look for a match in the current row
               int column = substring.indexOf(motif);
               // no match in the current row: skip to the next row
               if (column == -1)
                  break;
               // match found: look ahead to see if the next several rows in
               // grid match the remaining rows of pattern at the same column
               int patternIndex = 1;
               while (patternIndex < pattern.size()) {
                  // current row of pattern match: keep looking
                  if (match(grid.get(row+patternIndex), pattern.get(patternIndex), substringIndex, column))
                     patternIndex++;
                  // no match in the current row of pattern
                  else
                     break;
               }
               // match all rows of pattern
               if (patternIndex == pattern.size())
                  return true;
               // no match in the next rows: keep searching in the current row
               else {
                  // i += motif.length();
                  substringIndex += 1;
               }
            }
         }
         // no match
         return false;
      }

      // grille must start at the correct subindex, and motif must be in grille
      // and at the correct column position
      private boolean match(String grille, String motif, int subindex, int column) {
         int index = grille.substring(subindex).indexOf(motif);
         return index != -1 && index == column;
      }

      private List<String> read(Scanner scanner) {
         List<String> list = new ArrayList<>();
         int rowCount = scanner.nextInt();
         int columnCount = scanner.nextInt();
         for (int i = 0; i < rowCount; i++) {
            String string = scanner.next();
            list.add(string);
         }
         return list;
      }
   }
}
