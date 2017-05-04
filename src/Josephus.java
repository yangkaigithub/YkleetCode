/**
 * Created by tpusers on 2017/1/10.
 */
public class Josephus {
    public static void main(String[] args){
        Josephus josephus = new Josephus(41);
        josephus.buildup();
        josephus.kill();
    }

    private int num;

    private Node first;

    private Node last;

    public Josephus(int num){
        this.num = num;
        first= new Node(1);
    }

    public void buildup(){
        buildup(first);


    }

    public Node buildup(Node x){
        if(x.index==num+1)
            return first;
        else{
            x.next = buildup(new Node(x.index+1));
            if(x.index == num )
                last = x;
            return x;
        }
    }

    public void deleteNode(Node x){
        Node y = first;
        if(y.index == x.index){
            last.next = y.next;
            first = y.next;

        }
        for(int i=0 ;i<num;i++){
            if(y.next.index == x.index){
                if(y.next == last){
                    last = y;
                }

                if(y.next == first){
                    first = y.next.next;
                }
                y.next = y.next.next;
            }
            y = y.next;
        }
    }

    public void kill(){
        int i = 1;
        for(Node x=first;;x=x.next){
            if(x.next == x){
                System.out.print(x.index+"->");
                break;
            }
            if(i++==3){
                i = 1;
                System.out.print(x.index+"->");
                deleteNode(x);
            }



        }
    }

    class Node{
        int index;
        Node next;
        public Node(int index){
            this.index = index;
        }
    }
}
