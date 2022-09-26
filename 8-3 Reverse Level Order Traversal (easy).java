// https://www.educative.io/courses/grokking-the-coding-interview/m2N6GwARL8r
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class ReverseLevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int curLevelSize = 1;
    while (queue.size() > 0) {
      int nextLevelSize = 0;
      List<Integer> level = new ArrayList<>();

      while (curLevelSize > 0) {
        TreeNode curNode = queue.poll();
        level.add(curNode.val);

        if (curNode.left != null) {
          queue.add(curNode.left);
          nextLevelSize++;
        }
        if (curNode.right != null) {
          queue.add(curNode.right);
          nextLevelSize++;
        }
        curLevelSize--;
      }

      result.add(0, level);
      curLevelSize = nextLevelSize;
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }
}
