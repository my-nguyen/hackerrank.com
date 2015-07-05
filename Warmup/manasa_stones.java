import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

class MyList
{
  private List<int[]> data;

  public MyList()
  {
    data = new ArrayList<int[]>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of cases to fetch next
    int count = scanner.nextInt();
    // read all the integers
    for (int i = 0; i < count; i++)
    {
      int[] line = new int[3];
      for (int j = 0; j < 3; j++)
        line[j] = scanner.nextInt();
      data.add(line);
    }

    scanner.close();
  }

  private Set<Integer> process(int[] list)
  {
    // Using Set saves huge amount of space, and Set operations are fast too!
    // If using array, an array doubles in size at each iteration.
    // With a Set, the size only increases by 1 at each iteration.
    // Also TreeSet was chosen instead of HashSet in order to preserve sorting
    // order of elements
    Set<Integer> set = new TreeSet<Integer>();
    // list[0]: number of stones
    // list[1]: a
    // list[2]: b
    // Special case when a == b and stones == 2
    set.add(list[1]);
    if (list[1] != list[2])
      set.add(list[2]);

    for (int i = 0; i < list[0]-2; i++)
    {
      Set<Integer> tmp = new TreeSet<Integer>();
      for (Integer number : set)
      {
        tmp.add(number + list[1]);
        tmp.add(number + list[2]);
      }

      set.clear();
      set.addAll(tmp);
    }
    return set;
  }

  public List<Set<Integer>> process()
  {
    List<Set<Integer>> output = new ArrayList<Set<Integer>>();
    for (int[] list : data)
      output.add(process(list));
    return output;
  }
}

class manasa_stones
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (Set<Integer> set : list.process())
    {
      for (Integer number : set)
        System.out.print(number + " ");
      System.out.println();
    }
  }
}
