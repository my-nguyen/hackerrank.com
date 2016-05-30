import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MyList
{
  private List<List<Integer>> list;

  public MyList()
  {
    list = new ArrayList<List<Integer>>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    int case_count = scanner.nextInt();
    for (int i = 0; i < case_count; i++)
    {
      List<Integer> numbers = new ArrayList<Integer>();
      int numbers_size = scanner.nextInt();
      for (int j = 0; j < numbers_size; j++)
        numbers.add(scanner.nextInt());
      list.add(numbers);
    }

    scanner.close();
  }

  private long sum(List<Integer> numbers, int low, int high)
  {
    long sum = 0;
    for (int i = low; i <= high; i++)
      sum += numbers.get(i);
    return sum;
  }

  private String process(List<Integer> numbers)
  {
    if (numbers.size() == 1)
      return "YES";
    else if (numbers.size() == 2)
      return "NO";
    else
    {
      // (1) have a pivot that moves from 1 to next to last element of array
      // (2) pre-calculate 2 sums: one to the left and one to the right of pivot
      long sum_left = numbers.get(0);
      long sum_right = sum(numbers, 2, numbers.size()-1);
      for (int pivot = 1; pivot < numbers.size()-1; pivot++)
        if (sum_left == sum_right)
          return "YES";
        else
        {
          // if the sums on the 2 sides of the pivot don't equate, then move
          // the pivot to the right, and adjust the 2 sums accordingly.
          sum_left += numbers.get(pivot);
          sum_right -= numbers.get(pivot+1);
        }

      return "NO";
    }
  }

  public List<String> process()
  {
    List<String> output = new ArrayList<String>();
    for (List<Integer> numbers : list)
      output.add(process(numbers));
    return output;
  }
}

class sherlock_numbers
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    for (String answer : list.process())
      System.out.println(answer);
  }
}
