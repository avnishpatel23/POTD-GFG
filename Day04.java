// Pascal Triangle

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        long val = 1;
        row.add((int) val); // First element is always 1
        
        for (int k = 1; k < n; k++) {
            val = val * (n - k);
            val = val / k;
            row.add((int) (val % 1000000007)); // Modulo to avoid overflow if needed
        }

        return row;
    }
}
