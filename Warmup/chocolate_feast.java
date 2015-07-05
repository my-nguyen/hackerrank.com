import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<int[]> data;

  public MyList()
  {
    data = new ArrayList<int[]>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of cases to fetch next
    int count = scanner.nextInt();
    // read all the integers
    for (int i = 0; i < count; i++)
    {
      int[] line = new int[3];
      for (int j = 0; j < 3; j++)
        line[j] = scanner.nextInt();
      data.add(line);
    }

    scanner.close();
  }

  private int process(int[] list)
  {
    // data[0] is dollar amount
    // data[1] is chocolate price
    // data[2] is the discount; the number of wrappers equivalent to one chocolate
    //
    // the number of wrappers based on the dollar amount
    int wrappers = list[0] / list[1];
    // oririnally, chocolates is the same as wrappers
    int chocolates = wrappers;

    // start the exchange based on the number of wrappers and offer discount
    while (wrappers >= list[2])
    {
      // exchange wrappers for chocolates
      int exchange = wrappers / list[2];
      chocolates += exchange;
      // the number of wrappers includes the number of chocolates obtained from
      // the exchange, plus the number of wrappers left over from the exchange
      wrappers = exchange + (wrappers % list[2]);
    }
    return chocolates;
  }

  public List<Integer> process()
  {
    List<Integer> output = new ArrayList<Integer>();
    for (int[] list : data)
      output.add(process(list));
    return output;
  }
}

class chocolate_feast
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Integer number : list.process())
      System.out.println(number);
  }
}
