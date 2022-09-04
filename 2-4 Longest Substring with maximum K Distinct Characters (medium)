// https://www.educative.io/courses/grokking-the-coding-interview/YQQwQMWLx80
import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    HashMap<Character, Integer> map = new HashMap<>();
    int longest = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char windowEndChar = str.charAt(windowEnd);

      // While map doesn't contain current letter, and if adding it would lead to having > k distinct chars,
      // Start popping off characters from the start
      if (!map.containsKey(windowEndChar)) {
        if (longest == 0 || longest < (windowEnd - windowStart)) {
          longest = (windowEnd - windowStart);
        }

        while (map.keySet().size() >= k) {
          char windowStartChar = str.charAt(windowStart);
        
          // If no occurances of a letter are present, remove the letter from map
          if (map.containsKey(windowStartChar)) {
            
            if (map.get(windowStartChar) == 1) {
              map.remove(windowStartChar);
            } else {
              map.put(windowStartChar, map.get(windowStartChar) - 1);
            }
          }

          windowStart++;
        }
      }

      // Track newest index inside map
      if (!map.containsKey(windowEndChar)) {
        map.put(windowEndChar, 1);
      } else {
        map.put(windowEndChar, map.get(windowEndChar) + 1);
      }
    }

    return longest;
  }
}
