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
    // number of lines to read next
    int size = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < size; i++)
      data.add(scanner.nextLine());

    scanner.close();
  }

  // helper method that processes one single string and returnes one integer
  private int process(String string)
  {
    int count = 0;
    int length = string.length();
    for (int left = 0; left < length/2; left++)
    {
      // right index operates from right to left
      int right = length - 1 - left;
      // increase count by the absolute difference in the 2 characters found
      // at left and right indices
      count += Math.abs(string.charAt(right) - string.charAt(left));
    }
    return count;
  }

  public List<Integer> process()
  {
    List<Integer> output = new ArrayList<Integer>();
    for (String string : data)
      output.add(process(string));
    return output;
  }
}

class love_letter_mystery
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Integer count : list.process())
      System.out.println(count);
  }
}
