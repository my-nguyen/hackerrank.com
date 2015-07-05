import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class tstring1
{
  private static List<String> read()
  {
    Scanner scanner = new Scanner(System.in);
    int size = Integer.parseInt(scanner.nextLine());
    List<String> numbers = new ArrayList<String>();
    for (int i = 0; i < size; i++)
      numbers.add(scanner.nextLine());

    scanner.close();
    return numbers;
  }

  private static void print(List<String> strings)
  {
    for (String str : strings)
      System.out.println(str);
  }

  private static char get(List<String> strings, int row, int column)
  {
    return strings.get(row).charAt(column);
  }

  private static List<String> set(List<String> strings, int row, int column)
  {
    String current = strings.get(row);
    String new_string = current.substring(0, column) + 'X' + current.substring(column + 1);
    strings.set(row, new_string);
    return strings;
  }

  public static void main(String[] args)
  {
    List<String> strings = read();
    print(strings);
    System.out.println("Char at 2, 1: " + get(strings, 2, 1));
    print(set(strings, 2, 1));
  }
}
