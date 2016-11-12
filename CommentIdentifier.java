import java.io.*;
import java.util.*;

public class CommentIdentifier {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int index = line.indexOf("/*");
            if (index != -1) {
                line = line.substring(index);
                while (!line.contains("*/")) {
                    System.out.println(line);
                    line = sc.nextLine();
                }
                index = line.indexOf("*/");
                line = line.substring(0, index+2);
                System.out.println(line);
            } else {
                index = line.indexOf("//");
                if (index != -1) {
                    line = line.substring(index);
                    System.out.println(line);
                }
            }
        }
    }
}
