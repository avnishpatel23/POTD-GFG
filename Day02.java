// Sort a linked list of 0s, 1s and 2s


class Solution {
    static Node segregate(Node head) {
        if (head == null) {
            return null;
        }

        Node zeroHead = new Node(0);
        Node oneHead = new Node(0);
        Node twoHead = new Node(0);

        Node zero = zeroHead, one = oneHead, two = twoHead;
        Node current = head;

        while (current != null) {
            if (current.data == 0) {
                zero.next = current;
                zero = zero.next;
            } else if (current.data == 1) {
                one.next = current;
                one = one.next;
            } else {
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }

        two.next = null;
        one.next = twoHead.next;
        zero.next = oneHead.next;

        return zeroHead.next;
    }
}
