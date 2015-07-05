import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  // must use Long instead of Integer to represent the numbers, since the
  // operations, including the range (index_b - index_a), the number of candies,
  // and the multiplication all could push the result over the limits of an
  // integer
  private List<Long[]> data;
  private int jar_count;

  public MyList()
  {
    data = new ArrayList<Long[]>();
    jar_count = 0;
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of integers to fetch next
    jar_count = scanner.nextInt();
    int operation_count = scanner.nextInt();
    // read all the integers
    for (int i = 0; i < operation_count; i++)
    {
      Long[] line = new Long[3];
      for (int j = 0; j < 3; j++)
        line[j] = scanner.nextLong();
      data.add(line);
    }

    scanner.close();
  }

  public long process()
  {
    long sum = 0;
    for (Long[] operation : data)
      // operation[1]-operation[0]+1: refers to all array elements from lower
      // bound to upper bound, inclusive
      // operation[2] is the number of candies to fill into those array elements
      // So at each iteration, the number of candies filled in all array elements
      // from lower bound to upper bound inclusive is added to the total
      // And at the end of the loop, the sum will be all candies filled in all
      // ranges (lower-upper) of all operations
      // Because all the numbers, including the lower bound, the upper bound,
      // the range between lower and upper, the number of candies, the
      // multiplied value, and the sum total all could be too big for an
      // integer to hold, a Long was used instead.
      sum += (operation[1]-operation[0]+1) * operation[2];

    // return the average candies per jar
    return sum / jar_count;
  }
}

class filling_jars
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    System.out.println(list.process());
  }
}
