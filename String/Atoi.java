public class Atoi {
    public static int atoi(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                ans = ans * 10 + (str.charAt(i) - '0');
            }
        }
        return str.charAt(0) == '-' ? -ans : ans;
    }
}

//Time complexity: O(N)
//Space complexity: O(1)