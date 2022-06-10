import java.util.*;
class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int maxi = 0;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum = sum + arr[i];
            if (sum == 0){
                maxi = i + 1;
            }
            else{
                if (mp.get(sum) != null){
                    maxi = Math.max(maxi, i - mp.get(sum));
                }
                else{
                    mp.put(sum, i);
                }
            }
        }
        return maxi;
    }
}

// Time Complexity: O(NlogN)

// Space Complexity: O(N)