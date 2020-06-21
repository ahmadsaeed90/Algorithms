
/**
 * Sorts linked list using merge sort in O(n(logn)) using constant space
 * @author Ahmad
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
	
        if (head == null || head.next == null)
            return head;

        var middle = findMiddle(head);
        var middleNext = middle.next;
        middle.next = null;

        var left  = sortList(head);
        var right = sortList(middleNext);

        return merge(left, right);
     }

    public ListNode findMiddle(ListNode head) {
	
        if (head == null || head.next == null)
            return head;

        var fast = head;
        var slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
	
	    return slow;
    }

    ListNode merge(ListNode head1, ListNode head2) {
	
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        ListNode merged = null;
        ListNode mergedTail = null;
        ListNode current1 = head1;
        ListNode current2 = head2;

        while (current1 != null && current2 != null) {

            ListNode selected = null;

            if (current1.val < current2.val) {
                // use current 1
                selected = current1;
                current1 = current1.next;
            }
            else {
                selected = current2;
                current2 = current2.next;
            }

            selected.next = null;

            if (merged == null) {
                merged = mergedTail = selected;
            }
            else {
                mergedTail.next = selected;
                mergedTail = selected;
            }
        }

        while (current1 != null) {
            var next = current1.next;
            current1.next = null;
            mergedTail.next = current1;
            mergedTail = current1;
            current1 = next;
        }

        while (current2 != null) {
            var next = current2.next;
            current2.next = null;
            mergedTail.next = current2;
            mergedTail = current2;
            current2 = next;
        }

        return merged;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode() {}
    	ListNode(int val) { this.val = val; }
    	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}