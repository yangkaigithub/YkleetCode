public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head,fast=head,pre=null;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode pre11=l1,pre12=l1,pre2=l2;
        while(node1!=null||node2!=null) {
            if (node2 == null) {
                pre2.next = pre11;
                break;
            }
            if (node1 == null) {
                if (pre2 != node2) {
                    pre2.next = pre11;
                    pre12.next = node2;
                } else {
                    pre12.next = l2;
                    l2 = pre11;
                }
                break;
            }
            if (node1.val > node2.val) {
                if (pre11 != node1) {
                    if (pre2 != node2) {
                        pre2.next = pre11;
                        pre12.next = node2;
                    } else {
                        pre12.next = node2;
                        l2 = pre11;
                    }
                    pre11 = node1;
                    pre12 = node1;
                }
                pre2 = node2;
                node2 = node2.next;
            } else {
                pre12 = node1;
                node1 = node1.next;
            }
        }
        return l2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next =  new ListNode(3);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(2);
        l2.next.next =  new ListNode(3);
        l2.next.next.next = new ListNode(3);
//        l1.next.next.next.next = l2;

        ListNode l3 = new SortList().merge(l1,l2);
        System.out.println("dsfadfdaf");
    }
}
