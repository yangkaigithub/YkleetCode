public class mergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int l = lists.length-1;
        int h = 0;
        while(l!=0){
            l = l/2;
        }
        for (int i = 0; i < h; i++) {
            int gap = (int)Math.pow(2,i);
            for (int j = 0; j < lists.length-gap; j = j+2*gap) {
                lists[j] = mergeTwoLists(lists[j],lists[j+gap]);
            }
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode mergeNode;
        if(l1.val<l2.val){
            mergeNode = l1;
            mergeNode.next = mergeTwoLists(l1.next,l2);
        }else{
            mergeNode = l2;
            mergeNode.next = mergeTwoLists(l1,l2.next);
        }
        return mergeNode;
    }

    public static void main(String[] args) {
        System.out.println(Math.log1p(2));
    }

}
