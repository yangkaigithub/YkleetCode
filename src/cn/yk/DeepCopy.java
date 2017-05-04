package cn.yk;

import java.lang.reflect.Constructor;

/**
 * Created by tpusers on 2017/5/3.
 */
public class DeepCopy {
    class Node{
        Node next;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    Node head;

    public void ConstructorNodes(){
        head = new Node(0);
        Node x = head;
        for(int i=1;i<5;i++,x=x.next){
            x.next = new Node(i);
        }

    }

    public void boom(){
        Node x = this.head;
        Node n = null;
        Node m = x.next;
        while(x!=null){
            x.next = new Node(x.val);
            x.next.next = n;
            n = x;
            x = m;
            if(m!=null)
                m = m.next;
        }
        head = n;
    }
    public static void main(String[] args){
        DeepCopy deepCopy = new DeepCopy();
        deepCopy.ConstructorNodes();

        deepCopy.boom();

        Node z = new DeepCopy().head;



    }
}
