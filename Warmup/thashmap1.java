import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class thashmap1
{
  public static void main(String[] args)
  {
    Map<String, Integer> hash = new HashMap<String, Integer>();
    hash.put("Zero", 0);
    hash.put("One", 1);
    hash.put("Two", 2);
    hash.put("Three", 3);
    hash.put("Four", 4);
    hash.put("Five", 5);
    hash.put("Six", 6);
    hash.put("Seven", 7);
    hash.put("Eight", 8);
    hash.put("Nine", 9);

    Set<String> keys = hash.keySet();
    for (String key : keys)
      System.out.println("key: " + key + ", value: " + hash.get(key));

    String key = null;
    Integer value = 6;
    for(Map.Entry entry: hash.entrySet())
    {
      if (value.equals(entry.getValue()))
      {
        key = entry.getKey().toString();
        break; //breaking because its one to one map
      }
    }
    System.out.println("Value: " + value + ", key: " + key);
  }
}
