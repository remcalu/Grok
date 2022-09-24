// https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK
import java.util.*;

class AllMissingNumbers {
  public static void swap(int[] nums, int indexOne, int indexTwo) {
    int temp = nums[indexOne];
    nums[indexOne] = nums[indexTwo];
    nums[indexTwo] = temp;
  }

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> missingNumbers = new ArrayList<>();
    
    int i = 0;
    while (i < nums.length) {
      int iDesired = nums[i] - 1;
      if (nums[i] != nums[iDesired]) {
        swap(nums, i, iDesired);
      } else {
        i++;
      }
    }

    for (i = 1; i <= nums.length; i++) {
      if (i != nums[i-1]) {
        missingNumbers.add(i);
      }
    }

    return missingNumbers;
  }
}
