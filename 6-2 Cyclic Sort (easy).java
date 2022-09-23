// https://www.educative.io/courses/grokking-the-coding-interview/B8qXVqVwDKY
class CyclicSort {

  public static void swap(int[] nums, int indexOne, int indexTwo) {
    int temp = nums[indexOne];
    nums[indexOne] = nums[indexTwo];
    nums[indexTwo] = temp;
  }

  public static void sort(int[] nums) {
    // Index that our num will actually be at
    int i = 0;
    while (i < nums.length) {
      // Index that we want our num to be at
      int j = nums[i] - 1;

      // Check if the num at the index our num is at is the same as the index we want our num to be at
      if(nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        i++;
      }
    }
  }
}
