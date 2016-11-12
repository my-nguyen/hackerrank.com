import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// solution to the hackerrank.com One-Hour Challenge named Longest Subarray
// given an int[] and a target number, find the length of the longest subarray
// so that the sum of all of its element is <= the target number
class LongestSubarray {
   static int maxLength(int[] array, int target) {
      // tmp subarray
      int[] tmp = new int[array.length];
      // max length
      int max = 0;
      for (int i = 0; i < array.length; i++) {
         // count the number of elements in the subarray
         int count = 0;
         // sum of all elements in the subarray
         int sum = 0;
         for (int j = i; j < array.length; j++) {
            // copy elements, one by one, into the subarray while keeping track
            // of the number of elements in the array and the sum of the
            // elements so far
            tmp[count] = array[j];
            count++;
            sum += array[j];
            // break out of loop when sum exceeds the target number
            if (sum > target) {
               count--;
               break;
            }
         }
         // reset the max length
         max = Math.max(max, count);
      }
      return max;
   }

   public static void main(String[] args) throws IOException{
      Scanner in = new Scanner(System.in);
      final String fileName = "output";
      BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
      int res;

      int _a_size = 0;
      _a_size = Integer.parseInt(in.nextLine().trim());
      int[] _a = new int[_a_size];
      int _a_item;
      for(int _a_i = 0; _a_i < _a_size; _a_i++) {
         _a_item = Integer.parseInt(in.nextLine().trim());
         _a[_a_i] = _a_item;
      }

      int _k;
      _k = Integer.parseInt(in.nextLine().trim());

      res = maxLength(_a, _k);
      bw.write(String.valueOf(res));
      bw.newLine();

      bw.close();
   }
}
