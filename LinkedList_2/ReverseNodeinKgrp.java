class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        ListNode nex = dummy;
        
        int count = 0;
        while (cur.next != null){
            cur = cur.next;
            count++;
        }
        while (count >= k){
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++){
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }
}

// Time Complexity: O(N)

// Space Complexity: O(1)