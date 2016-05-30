import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  // Because an Integer is a 32-bit signed integer, type Long is needed to
  // represent 32-bit unsigned integers.
  private List<Long> data;

  public MyList()
  {
    data = new ArrayList<Long>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of integers to fetch next
    int length = scanner.nextInt();
    for (int i = 0; i < length; i++)
      // read all the integers
      data.add(scanner.nextLong());

    scanner.close();
  }

  public List<Long> process()
  {
    List<Long> output = new ArrayList<Long>();
    for (Long number : data)
    {
      // subtracting 1 is a trick to flip an unsigned 32-bit integer correctly.
      long negative = -number - 1;
      // convert from a long to a 64-bit string, then chop the results to a
      // 32-bit string
      String binary = Long.toBinaryString(negative).substring(32);
      // convert the 32-bit string back to a long integer
      output.add(Long.parseLong(binary, 2));
    }
    return output;
  }
}

class flipping_bits
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    List<Long> flips = list.process();
    for (Long number : flips)
      System.out.println(number);
  }
}
