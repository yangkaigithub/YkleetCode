/**
 * Created by Administrator on 2017/4/5.
 */
public class Probabilitytree {
    Node root;
    double ex;
    class Node{
        Node left;
        Node right;
        int value;
        int rank;
        public Node(int value,int rank){
            this.value = value;
            this.rank = rank;
        }
    }
    public Probabilitytree(){
        root = new Node(100,0);
        ex = 0;
    }

    public void probabilitytree(int p,int q){
        root.left = new Node(p,1);
        ex += p/100.0;
        root.right = probabilitytree(root.right,p,q,1,p/100.0);
    }
    public Node probabilitytree(Node x ,int p,int q,int rank,double acc){
        x = new Node(100-p,rank);
        if(p+q>=100) {
            x.left = new Node(100, rank + 1);
            ex += acc * (rank+1);
        }
        else{
            x.left = new Node(p+q,rank + 1);
            ex += acc * (p+q)/100.0 * (rank+1);
            x.right = probabilitytree(x.right,p+q,q,rank + 1,acc * (100-p-q)/100.0);
        }
        return x;
    }


    public double getExpection(){
        return ex;
    }

    public static void main(String[] args){
        Probabilitytree pt = new Probabilitytree();
        pt.probabilitytree(50,25);
        Node x = pt.root;
        Node y = pt.root;
        System.out.println(pt.getExpection());
    }

}
