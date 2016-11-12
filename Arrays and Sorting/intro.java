import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<Integer> data;
  private int value;

  public MyList()
  {
    data = new ArrayList<Integer>();
    value = 0;
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    value = scanner.nextInt();
    int array_size = scanner.nextInt();
    for (int i = 0; i < array_size; i++)
      data.add(scanner.nextInt());

    scanner.close();
  }

  public int process()
  {
    return data.indexOf(value);
  }
}

class intro
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    System.out.println(list.process());
  }
}
