import java.util.*;

class Solution {
    public void f(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            ds.add(candidates[i]);
            f(i + 1, candidates, target - candidates[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        f(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}

// Time Complexity:O(2^n*k)

// Reason: Assume if all the elements in the array are unique then the no. of
// subsequence you will get will be O(2^n). we also add the ds to our ans when
// we reach the base case that will take “k”//average space for the ds.

// Space Complexity:O(k*x)

// Reason: if we have x combinations then space will be x*k where k is the
// average length of the combination.