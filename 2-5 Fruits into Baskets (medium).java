// https://www.educative.io/courses/grokking-the-coding-interview/Bn2KLlOR0lQ
import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    int start = 0;
    int total = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    for (int end = 0 ; end < arr.length; end++) {
      char endFruit = arr[end];
      
      // If a new fruit is reached
      if (!map.containsKey(endFruit)) {

        // Pop fruit from the back to make room for a new basket
        while (map.keySet().size() == 2) {
          char startFruit = arr[start];

          if (map.get(startFruit) <= 1) {
            map.remove(startFruit);
          } else {
            map.put(startFruit, map.get(startFruit) - 1);
          }

          start++;
        }
      }

      if (map.containsKey(endFruit)) {
        map.put(endFruit, map.get(endFruit) + 1);
      } else {
        map.put(endFruit, 1);
      }

      if (total == 0 || total < (end - start)) {
        total = (end - start + 1);
      }
    }

    return total;
  }
}
