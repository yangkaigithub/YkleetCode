import java.util.*;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if(n==0){
            return treeNodes;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i+1;

        }
        List<List<Integer>> lists = permute(a);
        for(List list:lists){
            TreeNode node = new TreeNode((int) list.get(0));
            for (int i = 1; i < list.size(); i++) {
                node = treeAdd(node,(int)list.get(i));
            }
            boolean flag = false;
            for (int i = 0; i < treeNodes.size(); i++) {
                flag = flag||treeEquals(node,treeNodes.get(i));
            }
            if(!flag){
                treeNodes.add(node);
            }

        }


        return treeNodes;
    }

    public List<TreeNode> generateTrees3(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        List<TreeNode>[][] dp = new ArrayList[n+2][n+2];
        for (int i = n+1; i > 0 ; i--) {
            for (int j = 0; j <= n ; j++) {
                dp[i][j] = new ArrayList<>();
                if(i>j){
                    dp[i][j].add(null);
                }else if(i==j){
                    dp[i][j].add(new TreeNode(i));
                }else{
                    for(int k = i;k<=j;k++){
                        List<TreeNode> lNodes = dp[i][k-1];
                        List<TreeNode> rNodes = dp[k+1][j];
                        for(TreeNode lnode:lNodes){
                            for(TreeNode rnode:rNodes){
                                TreeNode root = new TreeNode(k);
                                root.right = rnode;
                                root.left = lnode;
                                dp[i][j].add(root);
                            }
                        }
                    }
                }
            }
        }
        return dp[1][n];
    }

    public List<TreeNode> generateTrees2(int n) {

        return genTrees(1,n);
    }

    public List<TreeNode> genTrees (int start, int end)
    {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }

    public TreeNode treeAdd(TreeNode node,int target){
        if(node==null){
            node = new TreeNode(target);
            return node;
        }
        if(target<node.val){
            node.left = treeAdd(node.left,target);
        }else{
            node.right = treeAdd(node.right,target);
        }
        return node;
    }


    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<Integer>());
        for (int n : nums) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public boolean treeEquals(TreeNode n1,TreeNode n2){
        if(n1==null){
            return true;
        }
        if(n1.val!=n2.val){
            return false;
        }
        return treeEquals(n1.left,n2.left)&&treeEquals(n1.right,n2.right);
    }

    public static void main(String[] args) {
        new UniqueBinarySearchTreesII().generateTrees3(3);
    }




}
