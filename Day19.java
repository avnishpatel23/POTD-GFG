// Smallest range in K lists

class Solution {
    class Node {
        int data;
        int row;
        int col;

        Node(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            minHeap.offer(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int start = 0, end = Integer.MAX_VALUE;

        while (true) {
            Node curr = minHeap.poll();
            int min = curr.data;

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (curr.col + 1 < n) {
                int nextVal = arr[curr.row][curr.col + 1];
                minHeap.offer(new Node(nextVal, curr.row, curr.col + 1));
                max = Math.max(max, nextVal);
            } else {
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(start);
        result.add(end);
        return result;
    }
}
