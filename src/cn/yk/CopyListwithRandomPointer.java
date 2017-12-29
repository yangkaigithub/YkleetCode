package cn.yk;


class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
}


public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        RandomListNode node = head;
        RandomListNode newhead = new RandomListNode(head.label);
        RandomListNode newnode = newhead;
        while(node!=null){
            newnode = new RandomListNode(node.label);
            if(node.next!=null){
                newnode.next = node.next;
            }
            node.next = newnode;
            node = newnode.next;
        }
        node = head;
        newhead = head.next;
        while(node!=null){
            if(node.random!=null){
                node.next.random = node.random.next;
            }
            node = node.next.next;


        }
        node = head;
        while(node != null){
            RandomListNode n1 = node.next.next;
            if(n1 != null){
                RandomListNode n2 = node.next;
                node.next = node.next.next;
                n2.next = n2.next.next;
                node = n1;
            }else {
                node.next = null;
                node = null;
            }


        }
        return newhead;


    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(-1);

//        node.random = node;
        node.next = new RandomListNode(8);
        node.next.next = new RandomListNode(7);
        node.next.next.next = new RandomListNode(-3);
        node.next.next.next.next = new RandomListNode(4);
        node.random = node.next.next.next.next;
        node.next.random = node.next.next.next;
        node.next.next.random = null;
        node.next.next.next.random = null;
        node.next.next.next.next.random = node;
        new CopyListwithRandomPointer().copyRandomList(node);
    }


}
