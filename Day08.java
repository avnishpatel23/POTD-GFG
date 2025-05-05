// Search in an almost Sorted Array


class Solution {
    public int findTarget(int arr[], int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return mid;
            if (mid - 1 >= left && arr[mid - 1] == target) return mid - 1;
            if (mid + 1 <= right && arr[mid + 1] == target) return mid + 1;

            if (target < arr[mid]) {
                right = mid - 2;
            } else {
                left = mid + 2;
            }
        }

        return -1;
    }
}
