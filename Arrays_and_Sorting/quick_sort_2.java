import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
    int array_size = scanner.nextInt();
    for (int i = 0; i < array_size; i++)
      data.add(scanner.nextInt());
    scanner.close();
  }

  private void imprimer(List<Integer> array)
  {
    for (int i : array)
      System.out.print(i + " ");
    System.out.println();
  }

  private List<Integer> process(List<Integer> array)
  {
    if (array.size() <= 1)
      return array;
    else
    {
      int pivot = array.remove(0);
      List<Integer> lower = new ArrayList<Integer>();
      int i = 0;
      while (i < array.size())
        if (array.get(i) < pivot)
        {
          // copy the smaller element to the "lower" array
          lower.add(array.get(i));
          // remove the smaller element from current array
          array.remove(i);
        }
        else
          i += 1;

      // assemble the lower, pivot and upper parts. Note the recursive calls
      List<Integer> upper = new ArrayList<Integer>(array);
      array = process(lower);
      array.add(pivot);
      array.addAll(process(upper));
      imprimer(array);
      return array;
    }
  }

  public void process()
  {
    process(data);
  }
}

class quick_sort_2
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    list.process();
  }
}
