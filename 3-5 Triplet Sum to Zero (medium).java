// https://www.educative.io/courses/grokking-the-coding-interview/gxk639mrr5r
import java.util.*;

class TripletSumToZero {

  // Main method that loops through all elements and checks if they can be used for a triplet
  public static List<List<Integer>> searchTriplets(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> triplets = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      triplets.addAll(findTriplets(arr, i));
    }

    return triplets;
  }

  // Use 2 pointers to find sum such that (numL + numR = -target)
  public static List<List<Integer>> findTriplets(int[] arr, int index) {
    List<List<Integer>> triplets = new ArrayList<>();
    int target = arr[index] * -1;

    // Settings pointers
    int lPtr = index+1;
    int rPtr = arr.length-1;

    while (lPtr < rPtr) {
      int lNum = arr[lPtr];
      int rNum = arr[rPtr];
      int curSum = lNum + rNum;

      if (curSum < target) {
        lPtr++;
      } else if (curSum > target) {
        rPtr--;
      } else {
        // Skipping duplicates
        while (arr[lPtr] == arr[lPtr+1]) {
          lPtr++;
        }
        while (arr[rPtr] == arr[rPtr-1]) {
          rPtr--;
        }
        triplets.add(new ArrayList<Integer>(Arrays.asList(arr[index], lNum, rNum)));
        lPtr++;
        rPtr--;
      }
    }

    return triplets;
  }
}
