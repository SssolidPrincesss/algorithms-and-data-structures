import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode golova = new ListNode(0);
        ListNode hvost = golova;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                hvost.next = list1;
                list1 = list1.next;
            }
            else{
                hvost.next = list2;
                list2 = list2.next; 
            }
            hvost = hvost.next;
        }

        if (list1 != null){
            hvost.next = list1;
        }

        if (list2 != null){
            hvost.next = list2;
        }

        return golova.next;
    }
}