import java.util.*;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if(n==0){
            return treeNodes;
        }
        Set<Integer> set = new LinkedHashSet<>();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i+1;
            set.add(a[i]);
        }


        for (int i = 0; i < n; i++) {

            TreeNode head = new TreeNode(i+1);
            set.remove(i+1);
            head = generateTrees(treeNodes,a,head,head,set,i+1);
        }
        return treeNodes;
    }
    public TreeNode generateTrees(List<TreeNode> treeNodes, int[] a,  TreeNode head ,TreeNode node,Set<Integer> set,int m){
        if(node==null){
            node = new TreeNode(m);
        }
        for(int i:a){
            if(set.contains(i)){
                continue;
            }
            node.left = generateTrees(treeNodes,a,head,node.left,set,i);



        }

    }

}
