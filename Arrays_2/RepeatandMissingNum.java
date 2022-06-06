import java.util.ArrayList;

public class RepeatandMissingNum {
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int[] temp = new int[n];
        int[] ans = new int[2];
        int dup=0;
        int mis=0;

       for(int i:arr){
           temp[i-1]++;
        }

       for(int i=1;i<=temp.length;i++){
           int r = temp[i-1];
           if(r==0){
               mis=i;
           }
           if(r==2){
               dup =i;
           }
       }
        ans[0] = mis;
        ans[1] = dup;
        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
