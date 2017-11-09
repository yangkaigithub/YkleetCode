import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if(root == null){
            return integers;
        }

        inorderTraversal(root,integers);
        return integers;
    }
    public void inorderTraversal(TreeNode node,List<Integer> integers){
        if(node == null){
            return;
        }

        inorderTraversal(node.left,integers);
        integers.add(node.val);
        inorderTraversal(node.right,integers);
    }
}
