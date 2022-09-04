class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int windowLen = 0;
    int minWindowLen = 0;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      // Increasing sliding window by 1
      sum += arr[i];
      windowLen++;

      // While the sum is greater than the target, reduce window size
      while (sum >= S) {
        if (minWindowLen > windowLen || minWindowLen == 0) {
          minWindowLen = windowLen;
        }
        sum -= arr[i-windowLen+1];
        windowLen--;
      }
    }
    return minWindowLen;
  }
}
