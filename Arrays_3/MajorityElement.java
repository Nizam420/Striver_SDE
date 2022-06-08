class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int cand = 0;
        for (int i : nums){
            if(count == 0){
                cand = i;
            }
            if (i == cand){
                count++;
            }
            else{
                count--;
            }
        }
        return cand;
    }
}