import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
    // number of cases to fetch next
    int count = scanner.nextInt();
    // read all the integers
    for (int i = 0; i < count; i++)
      data.add(scanner.nextInt());

    scanner.close();
  }

  private String process(int number)
  {
    Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
    hash.put(3, 0);
    hash.put(5, 0);
    boolean found = false;
    while (true)
    {
      // first, look for a number divisible by 3 (as opposed to divisible by 5),
      // because we want to find as many 5's in the resulting string as possible
      // Note that this if condition allows for numbers such as 3 and 4 to be
      // evaluated before the elsif condition
      if (number % 3 == 0)
      {
        // found a combination of 3's and 5's that add up to number
        hash.put(3, hash.get(3) + number/3);
        found = true;
        break;
      }
      else if (number >= 5)
      {
        number -= 5;
        hash.put(5, hash.get(5) + 1);
      }
      else
        break;
    }

    // construct the resulting string
    StringBuilder string = new StringBuilder();
    if (found)
    {
      for (int i = 0; i < hash.get(3); i++)
        string.append("555");
      for (int i = 0; i < hash.get(5); i++)
        string.append("33333");
    }
    else
      string.append("-1");

    return string.toString();
  }

  public List<String> process()
  {
    List<String> output = new ArrayList<String>();
    for (Integer number : data)
      output.add(process(number));
    return output;
  }
}

class sherlock_beast
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (String number : list.process())
      System.out.println(number);
  }
}
