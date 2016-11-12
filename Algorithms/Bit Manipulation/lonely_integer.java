import java.util.*;

class lonely_integer {
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
      List<Integer> numbers = new ArrayList<>();

      public Case(Scanner scanner) {
         int numberCount = scanner.nextInt();
         for (int i = 0; i < numberCount; i++)
            numbers.add(scanner.nextInt());
      }

      public int process()
      {
         // create a hash where key is the unique numbers in list, and value is
         // the frequency of occurrence of each unique key
         Map<Integer, Integer> hash = new HashMap<>();
         for (Integer key : numbers)
            // if frequency doesn't exist, create one with value 1
            if (hash.get(key) == null)
               hash.put(key, 1);
            // if frequency exists, increment its value
            else
               hash.put(key, hash.get(key)+1);

         Integer key = null;
         Integer value = 1;
         // look for the key whose value equals 1
         for (Map.Entry entry: hash.entrySet())
            if (value.equals(entry.getValue())) {
               key = (Integer)entry.getKey();
               break;
            }

         return key;
      }
   }
}
