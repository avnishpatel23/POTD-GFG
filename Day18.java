// Substrings with same first and last characters

class Solution {
    public int countSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int count = 0;

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // For each character with frequency f, add f * (f + 1) / 2
        for (int f : freq.values()) {
            count += (f * (f + 1)) / 2;
        }

        return count;
    }
}
