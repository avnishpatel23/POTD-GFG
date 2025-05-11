// K-th Largest Sum Contiguous Subarray


class Solution {
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                if (minHeap.size() < k) {
                    minHeap.add(sum);
                } else if (sum > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(sum);
                }
            }
        }

        return minHeap.peek();
    }
}
