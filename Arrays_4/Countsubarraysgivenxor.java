import java.util.* ;
import java.util.ArrayList;

public class Countsubarraysgivenxor {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int[] nums = new int[arr.size()];
        for (int i = 0; i < nums.length; i++){
            nums[i] = arr.get(i);
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        int cnt = 0;
        int xorr = 0;
        for (int i = 0; i < nums.length; i++){
            xorr = xorr ^ nums[i];
            
            if (freq.get(xorr ^ x) != null){
                cnt += freq.get(xorr ^ x);
            }
            if (xorr == x){
                cnt++;
            }
            if (freq.get(xorr) != null){
                freq.put(xorr, freq.get(xorr) + 1);
            }
            else{
                freq.put(xorr, 1);
            }
        }
        return cnt;
	}
}