// Longest Subarray with Majority Greater than K


class Solution {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] trans = new int[n];

        for (int i = 0; i < n; i++) {
            trans[i] = (arr[i] > k) ? 1 : -1;
        }

        int prefixSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        firstOccurrence.put(0, -1);

        for (int i = 0; i < n; i++) {
            prefixSum += trans[i];

            if (prefixSum > 0) {
                maxLen = i + 1;
            } else if (firstOccurrence.containsKey(prefixSum - 1)) {
                maxLen = Math.max(maxLen, i - firstOccurrence.get(prefixSum - 1));
            }

            if (!firstOccurrence.containsKey(prefixSum)) {
                firstOccurrence.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}