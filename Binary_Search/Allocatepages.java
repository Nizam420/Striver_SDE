import java.util.*;

//to check if allocation of books among given students is possible.
class TUF {
    static boolean isPossible(ArrayList<Integer> A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.size(); i++) {
            if (sumAllocated + A.get(i) > pages) {
                cnt++;
                sumAllocated = A.get(i);
                if (sumAllocated > pages)
                    return false;
            } else {
                sumAllocated += A.get(i);
            }
        }
        if (cnt < students)
            return true;
        return false;
    }

    public static int books(ArrayList<Integer> A, int B) {
        if (B > A.size())
            return -1;
        int low = A.get(0);
        int high = 0;
        for (int i = 0; i < A.size(); i++) {
            high = high + A.get(i);
            low = Math.min(low, A.get(i));
        }
        // int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            // cout << low << " " << high << " " << mid << endl;
            if (isPossible(A, mid, B)) {
                // res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return res -> this is also correct
        return low;
    }

    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(12);
        A.add(34);
        A.add(67);
        A.add(90);
        int B = 2;
        System.out.println("Minimum Possible Number is " + books(A, B));
    }
}

// Time Complexity : O(NlogN)

// Reason: Binary search takes O(log N). For every search, we are checking if an
// allocation is possible or not. Checking for allocation takes O(N).

// Space Complexity: O(1)

// Reason: No extra data structure is used to store spaces.