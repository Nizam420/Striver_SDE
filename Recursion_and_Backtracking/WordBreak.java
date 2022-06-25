import java.util.*;

public class WordBreak {
    public static ArrayList<String> ans;

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        // Write your code here.
        ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String string : dictionary)
            set.add(string);
        find(s, set, new ArrayList<>());
        return ans;
    }

    public static void find(String s, Set<String> set, ArrayList<String> m) {
        // System.out.println(s+"pp");
        if (s.length() == 0) {
            // System.out.println(s+"pp;ll");
            StringBuilder temp = new StringBuilder();

            for (String t : m) {
                temp.append(t);
            }
            ans.add(temp.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {

            if (set.contains(s.substring(0, i + 1))) {

                m.add(s.substring(0, i + 1) + " ");
                find(s.substring(i + 1), set, m);
                m.remove(m.size() - 1);
            }
        }
    }

}
