import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<Integer> data;

  public MyList()
  {
    data = new ArrayList<Integer>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    int array_size = scanner.nextInt();
    for (int i = 0; i < array_size; i++)
      data.add(scanner.nextInt());
    scanner.close();
  }

  public List<Integer> process()
  {
    int p = data.get(0);
    List<Integer> lower = new ArrayList<Integer>();
    int i = 1;
    while (i < data.size())
      if (data.get(i) < p)
      {
        // copy the smaller element to the "lower" array
        lower.add(data.get(i));
        // remove the smaller element from current array
        data.remove(i);
      }
      else
        i += 1;

    // the result is the combination of the lower and the current array
    lower.addAll(data);
    return lower;
  }
}

class quick_sort_1
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (int element : list.process())
      System.out.print(element + " ");
    System.out.println();
  }
}
