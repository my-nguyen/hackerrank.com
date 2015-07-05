public class tbinary1 {
  public static void main(String[] args) {
    // long[] array = {2147483647, 1, 0};
    long[] array = {2147483647, 1, 0};
    for (int i = 0; i < array.length; i++)
    {
      long negative = -array[i] - 1;
      String binary = Long.toBinaryString(negative).substring(32);
      long integer = Long.parseLong(binary, 2);
      System.out.println("Binary value of " + negative + " is " + binary);
      System.out.println("Integer value of binary '" + binary + "' is " + integer);
    }
  }
}
