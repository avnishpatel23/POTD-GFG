// Smallest distinct window


class Solution {
    public int findSubString(String str) {
        Set<Character> distinctChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            distinctChars.add(ch);
        }
        int required = distinctChars.size();

        Map<Character, Integer> windowCounts = new HashMap<>();
        int start = 0, minLength = str.length() + 1, formed = 0;

        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);
            windowCounts.put(endChar, windowCounts.getOrDefault(endChar, 0) + 1);

            if (windowCounts.get(endChar) == 1) {
                formed++;
            }

            while (formed == required) {
                minLength = Math.min(minLength, end - start + 1);

                char startChar = str.charAt(start);
                windowCounts.put(startChar, windowCounts.get(startChar) - 1);
                if (windowCounts.get(startChar) == 0) {
                    formed--;
                }
                start++;
            }
        }

        return minLength;
    }
}
