public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode n1 = head;

        ListNode n4;
        ListNode n5 = null;
        if(n1 == null){
            return n1;
        }

        ListNode n2 = n1.next;
        ListNode n3;
        if(n1.next!=null){
            n3 = n2.next;
        }else {
            n3 = null;
        }
        if(m==n){
            return n1;
        }
        n4 = n1;
        int i=1;
        for ( i = 1; n2 != null ; i++) {
            if(m-i>=1){
                n4 = n1;
                n5 = n4.next;
                n1 = n1.next;
            }
            else if(i>=m&&i<n){
                if(i==m){
                    n2 = n1.next;
                    n3 = n2.next;
                }
                if(n2.next==null){
                    if(i==m){
                        n1.next = null;
                    }
                    n2.next = n1;
                    n1 = n2;
                    n2 = null;
                }else{
                    n2.next = n1;
                    if(i==m) {
                        n1.next = null;
                    }
                    n1 = n2;

                    n2 = n3;
                    n3 = n2.next;
                }
            }else{
                break;
            }
        }
        if(m==1&&n-1==i){
            return n1;
        }
        if(m==1){
            n4.next = n2;
            return n1;
        }
        if(n-1==i){
            n4.next = n1;
            return head;
        }
        n4.next = n1;
        n5.next = n2;
        return head;

    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        new ReverseLinkedListII().reverseBetween(l,3,4);

    }
}
