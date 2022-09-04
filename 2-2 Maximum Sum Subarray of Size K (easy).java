// https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int absMaxSum = 0;
    int localMaxSum = 0;

    for (int i = 0; i < arr.length; i++) {
      localMaxSum += arr[i];
      if (i >= k) {
        localMaxSum -= arr[i-k];
      }

      if (absMaxSum < localMaxSum) {
        absMaxSum = localMaxSum;
      }
    }

    return absMaxSum;
  }
}
