// https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP
class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    int lPtr = 0;
    int rPtr = arr.length-1;

    while (lPtr < rPtr) {
      int curSum = arr[lPtr] + arr[rPtr];

      if (curSum > targetSum) {
        rPtr--;
      } else if (curSum < targetSum) {
        lPtr++;
      } else {
        return new int[] { lPtr, rPtr }; 
      }
    }
    return new int[] { -1, -1 };
  }
}
