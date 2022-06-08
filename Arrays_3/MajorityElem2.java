class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int nums1 = -1;
        int nums2 = -1;
        int count1 = 0;
        int count2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == nums1){
                count1++;
            }
            else if (nums[i] == nums2){
                count2++;
            }
            else if (count1 == 0){
                nums1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0){
                nums2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == nums1){
                count1++;
            }
            else if (nums[i] == nums2){
                count2++;
            }
        }
        if (count1 > n / 3){
                ans.add(nums1);
        }
        if (count2 > n / 3){
            ans.add(nums2);
        }
        return ans;
    }
}

// Time Complexity: O(N)

// Space Complexity: O(1)