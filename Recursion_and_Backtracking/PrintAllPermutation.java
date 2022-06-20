import java.util.*;
class Solution {
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void permute(int ind, int[] nums, List<List<Integer>> ans){
        if (ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < nums.length; i++){
            swap(i, ind, nums);
            permute(ind+1, nums, ans);
            swap(i, ind, nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(0, nums, ans);
        return ans;
    }
}

// Time Complexity: O(N! X N)

// Space Complexity: O(1)