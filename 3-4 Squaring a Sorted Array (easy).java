// https://www.educative.io/courses/grokking-the-coding-interview/R1ppNG3nV9R
class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int lPtr = 0;
    int rPtr = arr.length-1;
    int entryIndecies = arr.length-1;

    while (lPtr < rPtr) {
      int lSquare = arr[lPtr] * arr[lPtr];
      int rSquare = arr[rPtr] * arr[rPtr];

      if (lSquare >= rSquare) {
        squares[entryIndecies] = lSquare;
        lPtr++;
      } else {
        squares[entryIndecies] = rSquare;
        rPtr--;
      }
      entryIndecies--;
    }

    return squares;
  }
}
