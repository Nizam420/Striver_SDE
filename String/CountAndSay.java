class Solution {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        if (n == 2){
            return "11";
        }
        String s = "11";
        for (int i = 3; i <= n; i++){
            String t = "";
            s = s + 'a';
            int c = 1;
            char[] arr = s.toCharArray();
            for (int j = 1; j < arr.length; j++){
                if (arr[j] != arr[j-1]){
                    t = t + c;
                    t = t + arr[j-1];
                    c = 1;
                }
                else{
                    c++;
                }
                s = t;
            }
        }
        return s;
    }
}

//Time complexity: O(N^2)
//Space complexity: O(N)