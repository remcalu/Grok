// https://www.educative.io/courses/grokking-the-coding-interview/YMzBx1gE5EO
import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    HashMap<Character, Boolean> map = new HashMap<>();
    int longest = 0;
    int start = 0;
    for (int end = 0; end < str.length(); end++) {
      char endChar = str.charAt(end);

      while (map.containsKey(endChar)) {
        char startChar = str.charAt(start);
        map.remove(startChar);
        start++;
      }

      map.put(endChar, true);

      if (longest == 0 || longest < (end - start + 1)) {
        longest = (end - start + 1);
      }
    }

    return longest;
  }
}
