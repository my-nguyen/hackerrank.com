import java.util.*;

class cavity_map {
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
      List<String> map = new ArrayList<>();

      public Case(Scanner scanner) {
         int mapSize = scanner.nextInt();
         for (int i = 0; i < mapSize; i++)
            map.add(scanner.next());
      }

      public String process()
      {
         for (int i = 1; i < map.size()-1; i++) {
            for (int j = 1; j < map.size()-1; j++) {
               // compare character at (i, j) with the surrounding 4 characters
               char depth = map.get(i).charAt(j);
               if (map.get(i-1).charAt(j) < depth &&
                   map.get(i+1).charAt(j) < depth &&
                   map.get(i).charAt(j-1) < depth &&
                   map.get(i).charAt(j+1) < depth) {
                  // a match is found: need to replace that character with 'X'
                  String current = map.get(i);
                  String replacement = current.substring(0, j) + 'X' + current.substring(j + 1);
                  map.set(i, replacement);
               }
            }
         }
         return toString();
      }

      @Override
      public String toString() {
         StringBuilder builder = new StringBuilder();
         for (String string : map)
            builder.append(string).append("\n");
         return builder.toString();
      }
   }
}
