// https://www.educative.io/courses/grokking-the-coding-interview/xV7E64m4lnz
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    int curLevelSize = 1;

    // Looping until there are no longer any nodes in the queue
    while (queue.size() > 0) {
      int nextLevelSize = 0;

      List<Integer> level = new ArrayList<>();

      // Popping off all nodes from the current level
      while (curLevelSize > 0) {
        TreeNode curNode = queue.poll();
        
        // Adding its value to the current level
        level.add(curNode.val);
        
        // Check if popped off node has children, add them to the queue and increase level size
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

      curLevelSize = nextLevelSize;
      result.add(level);
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
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}
