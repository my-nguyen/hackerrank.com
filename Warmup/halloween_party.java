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
    // number of integers to fetch next
    int count = scanner.nextInt();
    for (int i = 0; i < count; i++)
      // read all the integers
      data.add(scanner.nextInt());

    scanner.close();
  }

  private long process(int cuts)
  {
    // number of chocolate pieces
    long chocolates = 0;
    int increment = 0;
    // assuming there's at least 2 cuts
    for (int cut = 2; cut <= cuts; cut++)
    {
      // increase 'increment' by one at every two cuts
      if (cut % 2 == 0)
        increment += 1;
      chocolates += increment;
    }
    return chocolates;
  }

  public List<Long> process()
  {
    List<Long> output = new ArrayList<Long>();
    for (Integer cuts : data)
      output.add(process(cuts));
    return output;
  }
}

class halloween_party
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Long number : list.process())
      System.out.println(number);
  }
}
