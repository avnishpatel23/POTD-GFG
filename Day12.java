// Largest number in K swaps

class Solution {
    String max;

    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        max = s;
        char[] chars = s.toCharArray();
        findMaxHelper(chars, k, 0);
        return max;
    }

    private void findMaxHelper(char[] chars, int k, int index) {
        if (k == 0 || index == chars.length) return;

        // Find the max digit from index to end
        char maxDigit = chars[index];
        for (int i = index + 1; i < chars.length; i++) {
            if (chars[i] > maxDigit) {
                maxDigit = chars[i];
            }
        }

        // If maxDigit is different from chars[index], we will perform swap(s)
        if (maxDigit != chars[index]) {
            for (int i = chars.length - 1; i >= index; i--) {
                if (chars[i] == maxDigit) {
                    // Swap
                    swap(chars, index, i);
                    String current = new String(chars);
                    if (current.compareTo(max) > 0) {
                        max = current;
                    }
                    // Recur
                    findMaxHelper(chars, k - 1, index + 1);
                    // Backtrack
                    swap(chars, index, i);
                }
            }
        } else {
            // No beneficial swap, move to next index
            findMaxHelper(chars, k, index + 1);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
