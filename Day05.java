// Bitonic Point

class Solution {
    public int findMaximum(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Handle boundaries safely
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            } else if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1; // Go right (increasing part)
            } else {
                high = mid - 1; // Go left (decreasing part)
            }
        }

        return -1; // This should not happen due to problem guarantees
    }
}
