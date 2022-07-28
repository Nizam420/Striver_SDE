import java.util.*;
class Solution {
    
    static ArrayList<ArrayList <Integer>> ans = new ArrayList<ArrayList<Integer>> ();
    
    public static void pwsetHelper(ArrayList<Integer> arr, int i, ArrayList<Integer> subset) {
        
        if(i == arr.size()) {
            ans.add(new ArrayList<Integer> (subset)); // Line of doubt
            return;
        }
        
        subset.add(arr.get(i));
        pwsetHelper(arr, i+1, subset);
        
        subset.remove(subset.size() - 1);
        pwsetHelper(arr, i+1, subset);
    }
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
        // WRITE YOUR CODE HERE
        ArrayList<Integer> subset = new ArrayList < > ();
        pwsetHelper(arr, 0, subset);
        return ans;
    }
}