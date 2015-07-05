import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class tarray1 {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<Integer>();
    numbers.add(101);
    numbers.add(200);
    numbers.add(301);
    numbers.add(400);
    System.out.println("ArrayList Before : " + numbers);

    Iterator<Integer> itr = numbers.iterator();
    while (itr.hasNext()) {
      System.out.println("Going next");
      Integer number = itr.next();
      if (number % 2 == 0) {
        System.out.println("Removing " + number);
        itr.remove();
      }
    }
    System.out.println("ArrayList After : " + numbers);
  }
}
