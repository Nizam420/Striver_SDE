import java.util.*;

class TUF {
    static boolean isPossible(int a[], int n, int cows, int minDist) {
        int cntCows = 1;
        int lastPlacedCow = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - lastPlacedCow >= minDist) {
                cntCows++;
                lastPlacedCow = a[i];
            }
        }
        if (cntCows >= cows)
            return true;
        return false;
    }

    public static void main(String args[]) {
        int n = 5, cows = 3;
        int a[] = { 1, 2, 8, 4, 9 };
        Arrays.sort(a);

        int low = 1, high = a[n - 1] - a[0];

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (isPossible(a, n, cows, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("The largest minimum distance is " + high);

    }
}

// Time Complexity: O(N*log(M)).

// Reason: For binary search in a space of M, O(log(M)) and for each search, we
// iterate over max N stalls to check. O(N).

// Space Complexity: O(1)