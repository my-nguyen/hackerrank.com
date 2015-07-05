import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<String> list;

  public MyList()
  {
    list = new ArrayList<String>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of lines to read next
    int size = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < size; i++)
      list.add(scanner.nextLine());

    scanner.close();
  }

  public void process()
  {
    for (int i = 1; i < list.size()-1; i++)
      for (int j = 1; j < list.size()-1; j++)
      {
        // compare character at (i, j) with the surrounding 4 characters
        char current = list.get(i).charAt(j);
        if (list.get(i-1).charAt(j) < current && list.get(i+1).charAt(j) < current &&
            list.get(i).charAt(j-1) < current && list.get(i).charAt(j+1) < current)
        {
          // a match is found: need to replace that character with 'X'
          String cur_string = list.get(i);
          String new_string = cur_string.substring(0, j) + 'X' + cur_string.substring(j + 1);
          list.set(i, new_string);
        }
      }
  }

  public void print()
  {
    for (String str : list)
      System.out.println(str);
  }
}

class cavity_map
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    list.process();
    list.print();
  }
}
