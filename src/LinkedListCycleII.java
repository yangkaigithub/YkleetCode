
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                if(fast == head){
                    return head;
                }
                slow = head;
                while(slow!=null){
                    fast = fast.next;
                    slow = slow.next;
                    if(fast == slow){
                        return fast;
                    }
                }
            }
        }
        return null;
    }
}
