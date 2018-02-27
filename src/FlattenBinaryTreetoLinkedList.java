
public class FlattenBinaryTreetoLinkedList {
    private static TreeNode x = null;
    public void flatten(TreeNode root) {
        help(root);
        System.out.println();
    }

    public TreeNode help(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }
        if(treeNode.left == null){
            if(treeNode.right !=null) {
                treeNode.right = help(treeNode.right);
            }else{
                x = treeNode;
                return treeNode;
            }
        }else{
            TreeNode r = treeNode.right;
            treeNode.right = help(treeNode.left);
            treeNode.left = null;
            x.right = r;
            help(r);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left= new TreeNode(1);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        new FlattenBinaryTreetoLinkedList().flatten(root);
    }

}
