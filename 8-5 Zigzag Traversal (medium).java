// https://www.educative.io/courses/grokking-the-coding-interview/qVA27MMYYn0
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean reverse = false;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> level = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        TreeNode curNode = queue.poll();

        if (reverse) {
          level.add(0, curNode.val);
        } else {
          level.add(curNode.val);
        }


        if (curNode.left != null) {
          queue.add(curNode.left);
        }
        if (curNode.right != null) {
          queue.add(curNode.right);
        }
      }
      result.add(level);
      reverse = !reverse;
    }
    // TODO: Write your code here
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverse(root);
    System.out.println("Zigzag traversal: " + result);
  }
}
