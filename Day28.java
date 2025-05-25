// Pythagorean Triplet


class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        HashSet<Integer> squares = new HashSet<>();

        for (int i = 0; i < n; i++) {
            squares.add(arr[i] * arr[i]);
        }

        for (int i = 0; i < n; i++) {
            int a2 = arr[i] * arr[i];
            for (int j = i + 1; j < n; j++) {
                int b2 = arr[j] * arr[j];
                int sum = a2 + b2;
                if (squares.contains(sum)) {
                    return true;
                }
            }
        }

        return false;
    }
}
