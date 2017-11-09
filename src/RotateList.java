class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        ListNode n1 = head;
        ListNode n2 = null;
        if(k==0||head==null){
            return head;
        }
        int l=0;
        for (int i = 0; n1 != null; i++,n1=n1.next) {
            l++;
        }
        k = k%l;
        k = l-k-1;
        n1 = head;
        for (int i = 0; n1 != null; i++,n1=n1.next) {
            if(i==k){
                if(n1.next==null){
                    return head;
                }
                n2 = n1.next;
                n1.next = null;
            }
        }
        if(n2==null){
            return head;
        }
        n1 = n2;
        for (int i = 0; n2!=null; i++,n2=n2.next) {
            if(n2.next==null){
                n2.next = head;
                break;
            }
        }
        return n1;

    }
    public ListNode rotateRight2(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        new RotateList().rotateRight(n1,2000000000);

    }
}
