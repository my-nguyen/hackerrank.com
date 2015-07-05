import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class tscanner1
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int test_count = scanner.nextInt();
    List<int[]> tests = new ArrayList<int[]>();
    for (int i = 0; i < test_count; i++)
    {
      int[] test = { scanner.nextInt(), scanner.nextInt() };
      tests.add(test);
    }
    scanner.close();

    for (int[] test : tests)
      System.out.println(test[0] + " " + test[1]);
  }
}
