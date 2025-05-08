// Missing element of AP


class Solution {
    public int findMissing(int[] arr) {
        int n = arr.length;
        if (n <= 1) return -1;

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] != minDiff) {
                return arr[i] + minDiff;
            }
        }

        return arr[n - 1] + minDiff;
    }
}