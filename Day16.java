// nCr

class Solution {
    public int nCr(int n, int r) {
        if (r > n) return 0;
        r = Math.min(r, n - r);
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
