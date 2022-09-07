// https://www.educative.io/courses/grokking-the-coding-interview/3YlQz7PE7OA
import java.util.*;
import java.lang.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    Arrays.sort(arr);

    int savedSum = Integer.MAX_VALUE;
    int smallestDistance = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      int stationaryNum = arr[i];
      int lPtr = i + 1;
      int rPtr = arr.length - 1;

      while (lPtr < rPtr) {
        int lNum = arr[lPtr];
        int rNum = arr[rPtr];
        int sum = stationaryNum + lNum + rNum;
        int curDistance = Math.abs(sum - targetSum);

        if (smallestDistance > curDistance) {
          smallestDistance = curDistance;
          savedSum = sum;
        }

        if (sum < targetSum) {
          lPtr++;
        } else if (sum > targetSum) {
          rPtr--;
        } else {
          return savedSum;
        }
      }

    }

    return savedSum;
  }
}
