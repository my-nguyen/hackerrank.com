import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<long[]> data;
  private long[] squares;
  private static final int SQUARE_MAX = 100000;

  public MyList()
  {
    data = new ArrayList<long[]>();

    squares = new long[SQUARE_MAX];
    for (int i = 0; i < SQUARE_MAX; i++)
      squares[i] = (i+1) * (i+1);
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of cases to fetch next
    int count = scanner.nextInt();
    // read all the integers
    for (int i = 0; i < count; i++)
    {
      long[] line = new long[2];
      for (int j = 0; j < 2; j++)
        line[j] = scanner.nextLong();
      data.add(line);
    }

    scanner.close();
  }

  // find the smallest square that is greater than or equal the number
  private long equal(long number)
  {
    for (int i = 0; i < SQUARE_MAX; i++)
      // with the list array containing square numbers that are so large, it is
      // guaranteed that a square will eventually be greater than given number
      if (squares[i] >= number)
        return i;

    // this point is never reached; but the method has to return something,
    // since the Java compiler requires a return statement
    return 0;
  }

  // find the smallest square that is greater than the number
  private long greater(long number)
  {
    for (int i = 0; i < SQUARE_MAX; i++)
      if (squares[i] > number)
        return i;
    return 0;
  }

  // return the number of squares between lower bound and upper bound, inclusive
  private long process(long[] bounds)
  {
    return greater(bounds[1]) - equal(bounds[0]);
  }

  public List<Long> process()
  {
    List<Long> output = new ArrayList<Long>();
    for (long[] list : data)
      output.add(process(list));
    return output;
  }
}

class sherlock_squares
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Long number : list.process())
      System.out.println(number);
  }
}
