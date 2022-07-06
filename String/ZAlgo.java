public class ZAlgo {

	public static int zAlgorithm(String s1, String s2, int n, int m) {
        
        int i=0,j=0,p1=0,p2=0,count,res=0;
        for(i=0;i<=n-m;i++){
            if(s1.charAt(i)==s2.charAt(j)){
                p1=i;
                p2=0;
                count=0;
                while(p1<n && p2<m){
                    if(s1.charAt(p1)==s2.charAt(p2)){
                        count++;
                        p1++;
                        p2++;
                    }
                    else{
                        break;
                    }
                }
                if(count==s2.length()){
                    res++;
                }
            }
        }
        return res;
	}
}

//Time complexity: O(N)
//Space complexity: O(1)