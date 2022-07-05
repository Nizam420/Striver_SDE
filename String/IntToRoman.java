class Solution {
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String ans = "";
        int i = 0;
        int len = 13;
        while (i < len){
            while (num >= value[i]){
                num = num - value[i];
                ans = ans + symbol[i];
                if (num == 0){
                    break;
                }
            }
            if (num == 0){
                break;
            }
            i++;
        }
        return ans;
    }
}

//Time complexity: O(N)
//Space complexity: O(1)