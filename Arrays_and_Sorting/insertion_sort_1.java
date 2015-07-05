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

  private void emprunter()
  {
    for (Integer element : data)
      System.out.print(element + " ");
    System.out.println();
  }

  private List<Integer> process(int index)
  {
    int value = data.get(index);
    // starting from left of index, proceed leftward
    int i = index - 1;
    while (i >= 0 && data.get(i) > value)
    {
      // shift data[i] one to the right
      data.set(i+1, data.get(i));
      emprunter();
      i--;
    }
    // insert value into its rightful place
    data.set(i+1, value);
    emprunter();

    return data;
  }

  public void process()
  {
    process(data.size()-1);
  }
}

class insertion_sort_1
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    list.process();
  }
}
