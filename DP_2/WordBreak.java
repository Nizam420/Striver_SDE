import java.util.*;

public class WordBreak {
    public static int wordBreak(String A, ArrayList<String> B )
   {
      Set<String> set= new HashSet<>();
      for(String s : B)
         set.add(s);
      return isPresent(0,set,A)? 1: 0;
   }
   public static boolean isPresent(int ind, Set<String> set,String A ){
       if(ind==A.length()) return true;
       for(int i=ind; i<A.length(); i++){
           if( set.contains(A.substring(ind,i+1))){
               if(isPresent(i+1, set, A)) return true;
           }
       }
       return false;
   }
}

// Expected time complexity: O(s2)

// Expected auxiliary space: O(s) , where s = length of string A