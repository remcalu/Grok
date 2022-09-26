// https://www.educative.io/courses/grokking-the-coding-interview/YQ5o5vEXP69
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root) {
    return findSumOfPath(root, 0);
  }

  public static int findSumOfPath(TreeNode root, int curSum) {
    if (root == null) {
      return 0;
    }

    curSum = curSum * 10 + root.val;

    if (root.left == null && root.right == null) {
      return curSum;
    }

    return findSumOfPath(root.left, curSum) + findSumOfPath(root.right, curSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}
