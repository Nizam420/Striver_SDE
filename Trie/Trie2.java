class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    int cntendWith = 0;
    int cntprefix = 0;
    
    public Node(){
        
    }
    boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    Node get(char ch){
        return links[ch - 'a'];
    }
    void setEnd(){
        flag = true;
    }
    void incEnd(){
        cntendWith++;
    }
    void incPre(){
        cntprefix++;
    }
    void delEnd(){
        cntendWith--;
    }
    void redPre(){
        cntprefix--;
    }
   int getEnd(){
       return cntendWith;
   }
    int getPre(){
        return cntprefix;
    }
}
public class Trie2 {
    private Node root;
    public Trie2() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++){
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.incPre();
        }
        node.incEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++){
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else{
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++){
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else{
                return 0;
            }
        }
        return node.getPre();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++){
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.redPre();
            }
            else{
                return;
            }
        }
        node.delEnd();
    }

}
