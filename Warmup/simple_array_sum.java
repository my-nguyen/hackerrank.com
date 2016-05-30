// this problem is too easy!
class simple_array_sum {
   public static void main(String[] args) {
      List<Integer> data = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      // array size
      int size = scanner.nextInt();
      // all the integers
      for (int i = 0; i < size; i++)
         data.add(scanner.nextInt());
      scanner.close();

      int total = 0;
      for (int number : data)
         total += number;
      System.out.println(total);
   }
}
