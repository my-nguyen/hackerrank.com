import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<Long> data;
  private List<Long> fibonacci;

  public MyList()
  {
    data = new ArrayList<Long>();

    fibonacci = new ArrayList<Long>();
    fibonacci.add(0L);
    fibonacci.add(1L);
    // it seems an array of 50 fibonacci numbers is adequate to pass the
    // submission at hackerrank.com
    for (int i = 1; i <= 50; i++)
      fibonacci.add(fibonacci.get(i) + fibonacci.get(i-1));
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of lines to read next
    int length = scanner.nextInt();
    for (int i = 0; i < length; i++)
      // read all the integers
      data.add(scanner.nextLong());

    scanner.close();
  }

  // helper method that processes one single string and returnes one integer
  private String process(long number)
  {
    return fibonacci.contains(number) ? "IsFibo" : "IsNotFibo";
  }

  public List<String> process()
  {
    List<String> output = new ArrayList<String>();
    for (Long number : data)
      output.add(process(number));
    return output;
  }
}

class fibonacci
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (String count : list.process())
      System.out.println(count);
  }
}
