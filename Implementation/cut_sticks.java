// Version 2: object-oriented methodology
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

class MyList
{
  private List<Integer> numbers;

  // Use List<Integer> instead of an array as return type because:
  // (1) It's awkward to convert from an int[] to a List<Integer>.
  // (2) An Integer[] would cause an exception upon calling Iterator::remove()
  // because the underlying data storage (array) doesn't allow such a removal.
  public MyList()
  {
    numbers = new ArrayList<Integer>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    // number of sticks
    int length = scanner.nextInt();
    for (int i = 0; i < length; i++)
      // all sticks' length
      numbers.add(scanner.nextInt());

    scanner.close();
  }

  public List<Integer> process()
  {
    // work on a temporary sorted copy of list
    List<Integer> sorted_copy = new ArrayList(numbers);
    Collections.sort(sorted_copy);

    List<Integer> cut_counts = new ArrayList<>();
    while (sorted_copy.isEmpty() == false)
    {
      // current list size is the current number of cuts
      cut_counts.add(sorted_copy.size());
      // first list element has the smallest value since list is sorted
      Integer minimum = sorted_copy.get(0);
      Iterator<Integer> itr = sorted_copy.iterator();
      // remove those elements that equal the minimum
      while (itr.hasNext() && itr.next().equals(minimum))
        itr.remove();
    }

    return cut_counts;
  }
}

class cut_sticks
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    List<Integer> output = list.process();
    for (int i = 0; i < output.size(); i++)
      System.out.println(output.get(i));
  }
}
