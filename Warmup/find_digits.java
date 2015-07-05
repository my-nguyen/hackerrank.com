import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<String> data;

  public MyList()
  {
    data = new ArrayList<String>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of cases to fetch next
    int size = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < size; i++)
      data.add(scanner.nextLine());

    scanner.close();
  }

  private int process(String string)
  {
    int count = 0;
    int value = Integer.parseInt(string);
    for (int i = 0; i < string.length(); i++)
    {
      int digit = (int)(string.charAt(i) - '0');
      // count the number of non-zero digits that is divisible by value
      if (digit != 0 && value % digit == 0)
        count += 1;
    }
    return count;
  }

  public List<Integer> process()
  {
    List<Integer> output = new ArrayList<Integer>();
    for (String number : data)
      output.add(process(number));
    return output;
  }
}

class find_digits
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Integer number : list.process())
      System.out.println(number);
  }
}
