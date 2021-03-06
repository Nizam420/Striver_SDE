import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-3; i++){
            while(i > 0 && i < nums.length-3 && nums[i] == nums[i-1] ) i++;
            for(int j = i + 1; j< nums.length-2; j++){
                while(j > i+1 && j < nums.length-2 && nums[j] == nums[j-1] ) j++;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i]+nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right --;
                    }
                    else if(sum < target){
                        left++;
                    } 
                    else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        while(left < right && nums[left]==nums[left-1]) left++;
                    }
                }
            }
        }
        return result;
    }
}

// Time Complexity: O(N^3)

// Space Complexity: O(1)