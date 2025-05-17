//  Sort the given array after applying the given equation

class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int[] temp = new int[n];
        
        int left = 0, right = n - 1;
        int idx = (A >= 0) ? n - 1 : 0;

        while (left <= right) {
            int valLeft = transform(arr[left], A, B, C);
            int valRight = transform(arr[right], A, B, C);

            if (A >= 0) {
                if (valLeft > valRight) {
                    temp[idx--] = valLeft;
                    left++;
                } else {
                    temp[idx--] = valRight;
                    right--;
                }
            } else {
                if (valLeft < valRight) {
                    temp[idx++] = valLeft;
                    left++;
                } else {
                    temp[idx++] = valRight;
                    right--;
                }
            }
        }

        for (int val : temp) {
            result.add(val);
        }

        return result;
    }

    private int transform(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }
}