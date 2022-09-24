// https://www.educative.io/courses/grokking-the-coding-interview/3wEkKy6Pr9A
class FindDuplicate {
  public static void swap(int[] nums, int indexOne, int indexTwo) {
    int temp = nums[indexOne];
    nums[indexOne] = nums[indexTwo];
    nums[indexTwo] = temp;
  }

  public static int findNumber(int[] nums) {
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
        return nums[i];
      }
    }

    return -1;
  }
}
