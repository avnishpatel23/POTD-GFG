// Find length of Loop

class Solution {
    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countLoopLength(slow);
            }
        }

        return 0;
    }

    private int countLoopLength(Node meetingPoint) {
        Node temp = meetingPoint;
        int count = 1;

        while (temp.next != meetingPoint) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
