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

  private void swap(List<Integer> array, int left, int right)
  {
    int tmp = array.get(left);
    array.set(left, array.get(right));
    array.set(right, tmp);
  }

  private List<Integer> process(List<Integer> array)
  {
    if (array.size() <= 1)
      return array;
    else
    {
      int pivot = array.size()-1;
      int left = 0;
      int right = pivot-1;
      while (true)
      {
        // moving from left to right, look for a bigger element than that at pivot
        while (left < right && array.get(left) <= array.get(pivot))
          left += 1;

        // if these 2 indices cross, we're done
        if (left >= right)
          break;
        else
        {
          // moving from right to left, look for a smaller element than that at pivot
          while (right > left && array.get(right) > array.get(pivot))
            right -= 1;

          // if these 2 indices cross, we're done
          if (right <= left)
            break;
          else
          {
            // if they don't cross then swap the 2 values bigger and smaller
            // and repeat the cycle
            swap(array, left, right);
            left += 1;
            right -= 1;
          }
        }
      }

      if (array.get(left) > array.get(pivot))
      {
        swap(array, left, pivot);
        pivot = left;
        imprimer(array);
      }

      // return process(array[0..pivot-1]) + [array[pivot]] + process(array[pivot+1..array.length-1])
      List<Integer> tmp = new ArrayList<Integer>(process(array.subList(0, pivot-1)));
      tmp.add(array.get(pivot));
      tmp.addAll(process(array.subList(pivot+1, array.size()-1)));
      return tmp;
      // return process(array.subList(0, pivot-1)).addAll(new ArrayList(Integer)(array[pivot])).addAll(process(array.subList(pivot+1, array.length-1))));
    }
  }

  public void process()
  {
    process(data);
  }
}

class quick_sort_inplace
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    list.process();
  }
}
