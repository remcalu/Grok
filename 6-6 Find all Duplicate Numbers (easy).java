// https://www.educative.io/courses/grokking-the-coding-interview/RLw1Pjk1GQ0
import java.util.*;

class FindAllDuplicate {
  public static void swap(int[] nums, int j, int i) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> duplicateNumbers = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      int iDesired = nums[i] - 1;
      if (nums[i] != nums[iDesired]) {
        swap(nums, i, iDesired);
      } else {
        i++;
      }
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        duplicateNumbers.add(nums[i]);
      }
    }

    return duplicateNumbers;
  }
}
