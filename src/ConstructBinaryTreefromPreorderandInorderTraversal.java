import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();

        TreeNode root = new TreeNode(preorder[0]);
        TreeNode node = root;
        TreeNode subroot = root;
        treeNodeStack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            if(indexMap.get(preorder[i])<indexMap.get(node.val)) {
                treeNodeStack.push(node);
                node.left = new TreeNode(preorder[i]);
                node = node.left;
//                treeNodeStack.push(node);
            }else{
                while(treeNodeStack.size()>0){

                    subroot = treeNodeStack.peek();
                    if(treeNodeStack.size() == 1){
                        subroot.right = new TreeNode(preorder[i]);
                        node = subroot.right;
                        treeNodeStack.pop();
                        treeNodeStack.push(node);
                        break;
                    }
                    if(indexMap.get(subroot.val)>indexMap.get(preorder[i])){

                        node.right = new TreeNode(preorder[i]);
                        node = node.right;
                        break;
                    }
                    node = treeNodeStack.pop();

                }


            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{4,2,1,3};
        int[] inorder = new int[]{1,2,3,4};
        new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preorder,inorder);
    }

}
