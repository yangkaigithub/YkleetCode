/**
 * Created by Administrator on 2016/11/19.
 */
public class AddTwoNum {
    public static void main(String[] args){
        new AddTwoNum().Test();


    }
    void Test(){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
      //  l2.next.next = new ListNode(4);
        ListNode l4 = addTwoNumbers(l1,l2);
        while(l4!=null){
            System.out.print(l4.val +" ");
            l4 = l4.next;
        }

    }
    int i = 0;
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&& l2==null&&i==0){
            return null;
        }else if(l1==null&&l2==null){
            l1 = new ListNode(0);
            l2 = new ListNode(0);
        }else if(l1==null){
            l1 = new ListNode(0);
        }else if(l2 == null){
            l2 = new ListNode(0);
        }
        int x = 0;
        if(l1.val+l2.val+i>=10){
            x = l1.val+l2.val -10+i;
            i = 1;
        }
        else{
            x = l1.val+l2.val+i;
            i = 0;
        }
        ListNode l3 = new ListNode(x);
        l3.next = addTwoNumbers(l1.next,l2.next);
        return l3;

          }
        int list2data (ListNode l){
            int s = 0;
            for (int i = 0; l != null; i++) {
                s += l.val * 10 ^ i;
                l = l.next;
            }
            return s;
        }
        ListNode data2list ( int s){
            ListNode l = new ListNode(0);
            while (s != 0) {
                //l.val;
            }
            return l;
        }

        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

}
