final class Struct
{
  int one;
  int two;
  Struct()
  {
    one = 0;
    two = 0;
  }
}

class tstruct1
{
  public static void main(String[] args)
  {
    Struct struct = new Struct();
    System.out.println("struct: " + struct.one + ", " + struct.two);
    struct.one = 75;
    struct.two = 3;
    System.out.println("struct: " + struct.one + ", " + struct.two);
  }
}
