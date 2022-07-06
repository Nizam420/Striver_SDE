public class KMPalgo {
    public static boolean findPattern(String p, String s) {
        // Write your code here.
        int M = p.length();
        int N = s.length();
  
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]
  
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(p, M, lps);
  
        int i = 0; // index for txt[]
        while (i < N) {
            if (p.charAt(j) == s.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                j = lps[j - 1];
                return true;
            }
  
            // mismatch after j matches
            else if (i < N && p.charAt(j) != s.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }
    public static void computeLPSArray(String p, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
  
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
  
                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}