// Find rectangle with corners as 1

class Solution {
    public boolean ValidCorner(int[][] mat) {
        int n = mat.length;
        if (n == 0) return false;
        int m = mat[0].length;

        Set<String> seenPairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            List<Integer> ones = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    ones.add(j);
                }
            }
            for (int a = 0; a < ones.size(); a++) {
                for (int b = a + 1; b < ones.size(); b++) {
                    String key = ones.get(a) + "#" + ones.get(b);
                    if (seenPairs.contains(key)) {
                        return true;
                    }
                    seenPairs.add(key);
                }
            }
        }

        return false;
    }
}
