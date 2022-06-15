class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while (cur.next != null){
            len++;
            cur = cur.next;
        }
        cur.next = head;
        
        k = k % len;
        k = len - k;
        while (k-- > 0){
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}

// Time Complexity: O(N)

// Space Complexity: O(1)