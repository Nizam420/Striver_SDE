import java.util.ArrayList;

public class RobinKarp {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		// Write your code here.
            ArrayList<Integer>ans=new ArrayList<>();
       int dp[]=new int[pat.length()+1];
        int i=0,j=1;
        while(j<pat.length()){
            if(pat.charAt(i)==pat.charAt(j)){
                dp[j]=i+1;
                i++;j++;
            }
            else{
                if(i>0)
                i=dp[i-1];
                while(i>0){
                 if(pat.charAt(i)==pat.charAt(j)){
                     dp[j]=i+1;
                     break;
                 }
                    i=dp[i-1];
                }
                  if(i==0&&pat.charAt(i)==pat.charAt(j))
                      dp[j]=1;
                j++;
            }
        }
        i=0;j=0;
//         for(i=0;i<pat.length();i++)
//             System.out.print(dp[i]+" ");
        i=0;
        while(i<str.length()){
              if(str.charAt(i)==pat.charAt(j)){
                i++;j++;
                    if(j==pat.length()){
                ans.add(i-pat.length());
                j=dp[j-1];
            }
            }
            else
            {
                if(j>0)
                j=dp[j-1];
                while(str.charAt(i)!=pat.charAt(j) &&j>0){
                    j=dp[j-1];
                }
                if(str.charAt(i)!=pat.charAt(j))
                    i++;
            }
          
          
        }
           if(j==pat.length()){
                ans.add(i-pat.length());
                j=dp[j-1];
            }
        return ans;
	}
}

//Time complexity: O(N + M)
//Space complexity: O(1)