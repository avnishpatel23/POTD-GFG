// Prime List

class Solution {

    boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    int nearestPrime(int n) {
        if (n <= 1) return 2;
        int offset = 0;
        while (true) {
            if (isPrime(n - offset)) return n - offset;
            if (isPrime(n + offset)) return n + offset;
            offset++;
        }
    }

    Node primeList(Node head) {
        Node current = head;
        while (current != null) {
            current.val = nearestPrime(current.val);  // Changed to .val
            current = current.next;
        }
        return head;
    }
}