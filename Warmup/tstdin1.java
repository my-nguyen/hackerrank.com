import java.util.Scanner;

class tstdin1
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    /*
    int people_count = scanner.nextInt();
    String line = scanner.nextLine();
    System.out.println("count: " + people_count + ", line: " + line);
    int topic_count = Integer.parseInt(line);
    */
    String line = scanner.nextLine();
    String[] list = line.split(" ");
    int people_count = Integer.parseInt(list[0]);
    int topic_count = Integer.parseInt(list[1]);
    System.out.println("line: " + line + ", people: " + people_count + ", topic: " + topic_count);
    for (int i = 0; i < people_count; i++)
    {
      line = scanner.nextLine();
      System.out.println(line);
    }
    scanner.close();
  }
}
