/**
 * Created by tpusers on 2017/3/14.
 */
public class ReverseLinkNode {
    Node head;
    class Node{
        int val;
        Node next;
    }
    public ReverseLinkNode(){
        head = new Node();
        head.val = 0;
        Node n1 = head;
        Node n2 = null;
        for(int i = 1;i<5;i++){
            n2 = new Node();
            n2.val = i;
            n1.next = n2;
            n1 = n2;
            n2 = null;
        }
    }
    public Node Reverse(){
        Node n1 = head;
        Node n2 = head.next;
        Node n3 = head.next.next;
        head.next = null;
        while(n3!=null){
            n2.next = n1;
            n1 = n2;
            n2 = n3;
            n3 = n3.next;
        }
        n2.next = n1;
        return n2;
    }
    public static void main(String[] args){
        ReverseLinkNode reverseLinkNode = new ReverseLinkNode();
        Node n1 = reverseLinkNode.head;
        Node n2 = reverseLinkNode.Reverse();

        System.out.println();
    }
}
