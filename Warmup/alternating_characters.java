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
    int left = 0;
    int count = 0;
    // StringBuiler is chosen for its ability to delete any character at a
    // random index
    StringBuilder mutable = new StringBuilder(string);
    while (true)
    {
      // right index operates from the right of left index and keeps looking for
      // and deleting characters in sequence that match that at left index
      int right = left+1;
      while (right < mutable.length() && mutable.charAt(left) == mutable.charAt(right))
      {
        // StringBuilder type comes in handy here
        mutable.deleteCharAt(right);
        count += 1;
      }

      // exit scenario when left is at the end of string
      if (left == mutable.length()-1)
        break;
      else
        left += 1;
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

class alternating_characters
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Integer count : list.process())
      System.out.println(count);
  }
}
