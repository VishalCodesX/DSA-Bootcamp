class Solution {

    private ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead =  reverseLinkedList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfStart = reverseLinkedList(slow.next);
        ListNode first = head;
        ListNode second = secondHalfStart;
        boolean isPalin = true;

        while(second != null) {
            if(first.val != second.val){
                isPalin = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        slow.next = reverseLinkedList(secondHalfStart);
        return isPalin;
        
    }
}
