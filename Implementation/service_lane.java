import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class MyList
{
  private List<Integer> widths;
  private List<int[]> tests;

  public MyList()
  {
    widths = new ArrayList<Integer>();
    tests = new ArrayList<int[]>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    int freeway_length = scanner.nextInt();
    int test_count = scanner.nextInt();
    for (int i = 0; i < freeway_length; i++)
      widths.add(scanner.nextInt());
    for (int i = 0; i < test_count; i++)
    {
      int[] test = { scanner.nextInt(), scanner.nextInt() };
      tests.add(test);
    }

    scanner.close();
  }

  // test[0] is entry, and test[1] is exit. So widths[entry..exit] is the range
  // in which to find the minimum. This method returns the minimum value of
  // the range between entry and exit, by taking a sublist of the range
  // [entry..exit], sorting the sublist, before returning the first entry of
  // the sorted sublist
  private int process(int[] test)
  {
    List<Integer> sublist = new ArrayList<Integer>(widths.subList(test[0], test[1]+1));
    Collections.sort(sublist);
    return sublist.get(0);
  }

  public List<Integer> process()
  {
    List<Integer> output = new ArrayList<Integer>();
    for (int[] test : tests)
      output.add(process(test));
    return output;
  }
}

class service_lane
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Integer answer : list.process())
      System.out.println(answer);
  }
}
