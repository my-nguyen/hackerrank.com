import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

final class Struct
{
  int topics;
  int teams;

  Struct()
  {
    topics = 0;
    teams = 0;
  }
}

class MyList
{
  private List<String> data;

  public MyList()
  {
    data = new ArrayList<String>();
  }

  public void read()
  {
    Scanner scanner = new Scanner(System.in);
    String[] list = scanner.nextLine().split(" ");
    int people_count = Integer.parseInt(list[0]);
    int topic_count = Integer.parseInt(list[1]);
    for (int i = 0; i < people_count; i++)
      data.add(scanner.nextLine());

    scanner.close();
  }

  public Struct process()
  {
    Struct struct = new Struct();
    for (int left = 0; left < data.size()-1; left++)
    {
      for (int right = left+1; right < data.size(); right++)
      {
        // First, convert the 32-bit strings back to long integers
        // long left_binary = Long.parseLong(data.get(left), 2);
        // long right_binary = Long.parseLong(data.get(right), 2);
        BigInteger left_binary = new BigInteger(data.get(left), 2);
        BigInteger right_binary = new BigInteger(data.get(right), 2);

        // Next, performm the bitwise OR operation
        // long bitwise_or = left_binary | right_binary;
        BigInteger bitwise_or = left_binary.or(right_binary);

        // Then, count the number of 1-bits in the result
        // int bit_count = Long.bitCount(bitwise_or);
        int bit_count = bitwise_or.bitCount();

        // found a new maximum number of topics
        if (struct.topics < bit_count)
        {
          struct.topics = bit_count;
          struct.teams = 1;
        }
        // increment the number of teams that know the maximum number of topics
        else if (struct.topics == bit_count)
          struct.teams += 1;
      }
    }
    return struct;
  }
}

class acm_icpc_team
{
  public static void main(String[] args)
  {
    MyList list = new MyList();
    list.read();
    Struct struct = list.process();
    System.out.println(struct.topics);
    System.out.println(struct.teams);
  }
}
