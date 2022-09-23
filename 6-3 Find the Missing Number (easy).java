// https://www.educative.io/courses/grokking-the-coding-interview/JPnp17NYXE9
class MissingNumber {

  public static void swap(int[] nums, int indexOne, int indexTwo) {
    int temp = nums[indexOne];
    nums[indexOne] = nums[indexTwo];
    nums[indexTwo] = temp;
  }

  public static int findMissingNumber(int[] nums) {
    // Index of the num we're currently on
    int i = 0;
    while (i < nums.length) {

      // Index that the num we're currently on should be at
      int j = nums[i];

      // Check if the index that the num should be is at that index, and that we're not on the last number
      // The last number won't be directly swapped, it will end up in the final place by other swaps if there
      // Are is no number that is missing
      if (j < nums.length && nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        i++;
      }
    }
    

    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }

    System.out.println("\n");
    return -1;
  }
}
