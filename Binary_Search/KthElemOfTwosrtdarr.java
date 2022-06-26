class Solution {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        if (m < n) {
            return kthElement(arr2, arr1, m, n, k);
        }

        int low = Math.max(0, k - m);

        int high = Math.min(k, n);

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = k - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int right1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > left2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 1;

    }
}

// Time Complexity : log(min(m,n))

// Reason: We are applying binary search in the array with minimum size among
// the two. And we know the time complexity of the binary search is log(N) where
// N is the size of the array. Thus, the time complexity of this approach is
// log(min(m,n)), where m,n are the sizes of two arrays.

// Space Complexity: O(1)

// Reason: Since no extra data structure is used, making space complexity to
// O(1).