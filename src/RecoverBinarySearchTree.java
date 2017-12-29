import org.w3c.dom.NodeList;

import java.util.*;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<Integer> nodeList = new LinkedList<>();
        tree2array(nodeList,root);
        int pos1 = -1;
        int pos2 = -1;
        for (int i = 0; i < nodeList.size(); i++) {
            if(pos1 == -1 && nodeList.get(i)>nodeList.get(i+1)){
                pos1 = i;
                i++;
                continue;
            }
            if(pos1 != -1 && nodeList.get(i)<nodeList.get(i-1)){
                pos2 = i;
                break;
            }
        }
        if(pos2 == -1){
            pos2 = pos1 + 1;
        }
        int tmp = nodeList.get(pos1);
        nodeList.set(pos1,nodeList.get(pos2));
        nodeList.set(pos2,tmp);
        treeSet(root,nodeList);

    }

    public void recoverTree2(TreeNode root) {
        TreeNode node = null;
        List<TreeNode> nodeList = new ArrayList<>();
        TreeNode pos1 = null;
        TreeNode pos2 = null;

        nodeList.add(node);
        nodeList.add(pos1);
        nodeList.add(pos2);

        recoverTree2(root,nodeList);
        recoverTree2(root,nodeList.get(1).val,nodeList.get(2).val);
        System.out.println();
    }
    public void recoverTree2(TreeNode node,int val1,int val2){
        if(node==null){
            return;
        }
        recoverTree2(node.left,val1,val2);
        if(node.val == val1){
            node.val = val2;
        }else{
            if (node.val == val2) {
                node.val = val1;
            }
        }
        recoverTree2(node.right,val1,val2);
    }

    public void recoverTree2(TreeNode node,List<TreeNode> nodeList) {
        if(node == null){
            return;
        }
        recoverTree2(node.left,nodeList);
        if(nodeList.get(0) != null){
            if(nodeList.get(1)==null&&nodeList.get(0).val>node.val){
                nodeList.set(1,nodeList.get(0));
                nodeList.set(2,node);
            }
            if(nodeList.get(1)!=null&&nodeList.get(0).val>node.val){
                nodeList.set(2,node);
            }
        }
        nodeList.set(0,node);
        recoverTree2(node.right,nodeList);
    }

    public void treeSet(TreeNode node, List<Integer> nodeList){
        if(node == null){
            return;
        }
        treeSet(node.left,nodeList);
        node.val = nodeList.remove(0);
        treeSet(node.right,nodeList);
    }

    public void tree2array(List<Integer> nodeList,TreeNode node){
        if(node == null){
            return;
        }
        tree2array(nodeList,node.left);
        nodeList.add(node.val);
        tree2array(nodeList,node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(1);
        new RecoverBinarySearchTree().recoverTree2(node);

    }
}
