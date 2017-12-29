import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<Integer> integers = new ArrayList<>();
        treeNode2List(root,integers);
        TreeNode root2 = new TreeNode(integers.get(0));
        for(int i:integers){
            root2 = treeAdd(root2,i);
        }
        return treeEqual(root,root2);
    }
    public void treeNode2List(TreeNode node, List<Integer> integers){
        if(node == null){
            return;
        }
        integers.add(node.val);
        treeNode2List(node.left,integers);
        treeNode2List(node.right,integers);

    }

    public TreeNode treeAdd(TreeNode node,int target){
        if(node == null){
            node = new TreeNode(target);
            return node;
        }
        if(target>node.val){
            node.right = treeAdd(node.right,target);
        }else if(target<node.val){
            node.left = treeAdd(node.left,target);
        }
        return node;
    }

    public boolean treeEqual(TreeNode node1,TreeNode node2){
        if(node1 == null || node2 == null){
            if(node1 == null && node2 == null){
                return true;
            }else{
                return false;
            }
        }
        if(node1.val == node2.val){
            return treeEqual(node1.left,node2.left) && treeEqual(node1.right,node2.right);
        }else{
            return false;
        }
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
}
