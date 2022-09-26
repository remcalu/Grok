// https://www.educative.io/courses/grokking-the-coding-interview/m280XNlPOkn
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    return findPathRecursive(root, sequence, 0);
  }

  public static boolean findPathRecursive(TreeNode root, int[] sequence, int index) {
    // If we've passed the leaf, or we know the sequence can't be made, return false
    if (root == null || root.val != sequence[index] || index >= sequence.length) {
      return false;
    }

    // If the node is a leaf, and its depth is the same as the length of the sequence return true (match)
    if (root.left == null && root.right == null && index + 1 == sequence.length) {
      return true;
    }

    return findPathRecursive(root.left, sequence, index + 1) || findPathRecursive(root.right, sequence, index + 1);
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}
