package cn.yk;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by tpusers on 2017/9/12.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        Boolean k = false;
        ListNode l3 = new ListNode(0);
        ListNode head3 = l3;
        while(l1!=null||l2!=null){
            if(l1==null){
                if(l2.next!=null){
                    l3.next = new ListNode(0);
                }
                k = false;
            }else if(l2==null){
                if(l1.next!=null){
                    l3.next = new ListNode(0);
                }
                k = true;
            }else {
                k = l1.val<l2.val?true:false;
                l3.next = new ListNode(0);
            }

            if(k){
                l3.val = l1.val;
                l1 = l1.next;
            }else{
                l3.val = l2.val;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        return head3;
    }

    public static void main(String[] args) {
        new MergeTwoSortedLists().mergeTwoLists(new ListNode(1),new ListNode(2));

        Map<String, String> map = new HashMap<>();
        map.put(null,"");
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, "");
    }

}
