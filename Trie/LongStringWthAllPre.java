class Node {
    Node[] child;
    boolean isword;

    public Node() {
        this.child = new Node[26];
        isword = false;
    }
}

class Trie {
    static Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String s) {
        s = s.toLowerCase();
        Node cur = root;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (cur.child[index] == null) {
                Node node = new Node();
                cur.child[index] = node;
                cur = node;
            } else {
                cur = cur.child[index];
            }
        }
        cur.isword = true;
    }

    public boolean compstring(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (cur.child[index] != null) {
                cur = cur.child[index];
                if (cur.isword == false) {
                    return false;
                }
            }
        }
        return cur.isword;
    }
}

class Solution {
    public static String completeString(int n, String[] a) {
        // Write your code here   
        Trie obj = new Trie();
        for (int i = 0; i < n; i++) {
            obj.insert(a[i]);
        }
        String longest = "";
        for (int i = 0; i < n; i++) {
            if (obj.compstring(a[i])) {
                if (a[i].length() > longest.length()) {
                    longest = a[i];
                } else if (a[i].length() == longest.length()) {
                    longest = a[i];
                }
            }
        }
        if (longest == "") return "None";
        return longest;
    }
}