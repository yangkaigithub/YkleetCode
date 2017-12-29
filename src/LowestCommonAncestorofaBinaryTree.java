import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofaBinaryTree {
    static TreeNode p;
    static TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> treeNodes = new ArrayList<>();
        this.p = p;
        this.q = q;
        lowestCommonAncestor(0,root,treeNodes);
        return treeNodes.get(2);
    }
    public TreeNode lowestCommonAncestor(int n, TreeNode node, List<TreeNode> treeNodes){
        if(node == null){
            return null;
        }
        if(treeNodes.size() == 3){
            return node;
        }

        if(node == p){
            n++;
            treeNodes.add(p);
        }
        if(node == q){
            n++;
            treeNodes.add(q);
        }
        node.left = lowestCommonAncestor(n,node.left,treeNodes);
        if(n==0&&treeNodes.size()==1){
            if(treeNodes.get(0) == p){
                p = node;
                treeNodes.set(0,p);
            }else{
                q = node;
                treeNodes.set(0,q);
            }
            n = 1;
        }
        node.right = lowestCommonAncestor(n,node.right,treeNodes);
        if(n==1&&treeNodes.size()==2){
            treeNodes.add(treeNodes.get(0));
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(4);
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(-2);
        root.left.right = q;
        root.left.left.left = p;
        root.right = new TreeNode(3);
//        root.left = p;
//        p.left = new TreeNode(4);
//        p.left.left = q;
//        p.left.right = new TreeNode(6);
//        p.right = new TreeNode(7);
//        root.right = new TreeNode(8);
        new LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(root,p,q);
    }
}
