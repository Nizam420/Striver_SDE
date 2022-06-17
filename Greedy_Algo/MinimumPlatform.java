import java.util.*;

class Solution {

    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1;
        int result = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            if (plat_needed > result) {
                result = plat_needed;
            }
        }
        return result;
    }

}

// Time Complexity: O(NlogN)

// Space Complexity: O(1)
