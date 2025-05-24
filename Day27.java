// Sum of all substrings of a number

class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        long res = s.charAt(0) - '0';
        long prev = res;
        
        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            prev = prev * 10 + (long) digit * (i + 1);
            res += prev;
        }
        
        return (int) res;
    }
}

