import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class MyList
{
  private List<Integer> data;
  private int subset_k;

  public MyList()
  {
    data = new ArrayList<Integer>();
    subset_k = 0;
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of integers to fetch next
    int total_n = scanner.nextInt();
    subset_k = scanner.nextInt();
    for (int i = 0; i < total_n; i++)
      // read all the integers
      data.add(scanner.nextInt());

    scanner.close();
  }

  public int process()
  {
    // sort the array of numbers so that given a range of k numbers, the
    // followings are readily available: min is at index 0, and max is at
    // index+subset_k-1
    Collections.sort(data);
    int sum = 0;
    for (int i = 0; i <= data.size()-subset_k; i++)
    {
      // find the difference between the max and the min values of this range
      int diff = data.get(i+subset_k-1) - data.get(i);
      if (sum == 0 || sum > diff)
        sum = diff;
    }
    return sum;
  }
}

class angry_children
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    System.out.println(list.process());
  }
}
