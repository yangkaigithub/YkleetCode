public class Trie {

    class TreeNode{
        public TreeNode[] childs;
        public boolean isWord;


        public TreeNode(){
            childs = new TreeNode[26];
            isWord = false;
        }

    }

    TreeNode root;
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode treeNode = root;
        for(char c:word.toCharArray()){
            int index = c - 'a';
            if(treeNode.childs[index]==null){
                treeNode.childs[index] = new TreeNode();
            }
            treeNode = treeNode.childs[index];
        }
        treeNode.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode treeNode = root;
        for (char c:word.toCharArray()) {
            int index = c - 'a';
            if(treeNode.childs[index]==null){
                return false;
            }
            treeNode = treeNode.childs[index];
        }
        if(treeNode.isWord == true){
            return true;
        }else {
            return false;
        }

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode treeNode = root;
        for (char c:prefix.toCharArray()) {
            int index = c - 'a';
            if(treeNode.childs[index]==null){
                return false;
            }
            treeNode = treeNode.childs[index];
        }
        return true;
    }
}
