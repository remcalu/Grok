// https://www.educative.io/courses/grokking-the-coding-interview/mEEA22L5mNA
class RemoveDuplicates {

  public static int remove(int[] arr) {
    int numElements = 1;
    int ptrA = 0;
    int ptrB = 0;

    while (ptrB != arr.length) {
      if (arr[ptrA] == arr[ptrB]) {
        ptrB++;
      } else {
        ptrA = ptrB;
        numElements++;
      }
      
    }

    return numElements;
  }
}
