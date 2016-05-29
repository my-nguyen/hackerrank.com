import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
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
    // number of integers to fetch next
    int length = scanner.nextInt();
    for (int i = 0; i < length; i++)
      // read all the integers
      data.add(scanner.nextInt());

    scanner.close();
  }

  public List<Integer> process()
  {
    List<Integer> output = new ArrayList<Integer>();
    for (Integer cycle : data)
    {
      int growth = 1;
      for (int i = 0; i < cycle; i++)
      {
        // spring growth: double in height
        if (i % 2 == 0)
          growth *= 2;
        // summer growth: just add 1 meter
        else
          growth += 1;
      }
      output.add(growth);
    }
    return output;
  }
}

class utopian_tree
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Integer number : list.process())
      System.out.println(number);
  }
}
