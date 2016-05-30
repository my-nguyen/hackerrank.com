import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<Integer> numbers;

  public MyList()
  {
    numbers = new ArrayList<Integer>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of integers to fetch next
    int length = scanner.nextInt();
    for (int i = 0; i < length; i++)
      // read all the integers
      numbers.add(scanner.nextInt());

    scanner.close();
  }

  public int process()
  {
    // create a hash where key is the unique numbers in list, and value is
    // the frequency of occurrence of each unique key
    Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
    for (Integer key : numbers)
      if (hash.get(key) == null)
        hash.put(key, 1);
      else
        hash.put(key, hash.get(key)+1);

    Integer key = null;
    Integer value = 1;
    // look for the key whose value equals 1
    for (Map.Entry entry: hash.entrySet())
      if (value.equals(entry.getValue()))
      {
        key = (Integer)entry.getKey();
        break;
      }

    return key;
  }
}

class lonely_integer
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    System.out.println(list.process());
  }
}
