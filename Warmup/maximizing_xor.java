import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private int lower;
  private int upper;

  public MyList()
  {
    lower = 0;
    upper = 0;
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // read lower and upper bounds from standard input
    lower = scanner.nextInt();
    upper = scanner.nextInt();
    scanner.close();
  }

  public int process()
  {
    int max = 0;
    // look for the biggest xor of any two numbers between lower and upper
    // bounds, inclusive
    for (int left = lower; left < upper; left++)
      for (int right = left+1; right <= upper; right++)
        if (max < (left^right))
          max = left^right;
    return max;
  }
}

class maximizing_xor
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    System.out.println(list.process());
  }
}
