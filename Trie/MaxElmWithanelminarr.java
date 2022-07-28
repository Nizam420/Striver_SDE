import java.util.*;

public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        ArrayList<Integer> ans=new ArrayList<>();
        Trie trie=new Trie();
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> newQueries=new ArrayList<>();
        int k=0;
        for(ArrayList<Integer> q:queries)
        {
            //newQueries.add(new ArrayList<>());
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(q.get(0));
            temp.add(q.get(1));
            temp.add(k);
            newQueries.add(temp);
            k++;
        }
        for(int i=0;i<k;i++)
            ans.add(-1);
        Collections.sort(newQueries,(a,b)->(a.get(1)-b.get(1)));
        int i=0;
        for(ArrayList<Integer> q:newQueries)
        {
            int max=-1;
            int query=q.get(0);
            int limit=q.get(1);
            int index=q.get(2);
            boolean flag=false;
            while(i<arr.size() && arr.get(i)<=limit)
            {
                trie.insert(arr.get(i));
                i++;
                flag=true;
            }
            
            if(i!=0)
            {
                max=Math.max(max,trie.max(query));
                ans.set(index,max);
            }
            
            
        }
        return ans;
    }
}
class Node
{
    private Node[] links;
    Node()
    {
        links=new Node[2];
    }
    Node get(int bit)
    {
        return links[bit];
    }
    void put(int bit,Node node)
    {
        links[bit]=node;
    }
    boolean contains(int bit)
    {
        return links[bit]!=null;
    }
}
class Trie
{
    private Node root;
    Trie()
    {
        root=new Node();
    }
    public void insert(int num)
    {
        Node node=root;
        for(int i=31;i>=0;i--)
        {
            int bit=((num>>i)&1);
            if(!node.contains(bit))
            {
                node.put(bit,new Node());
            }
            node=node.get(bit);
        }
    }
    public int max(int num)
    {
        Node node=root;
        int max=0;
        for(int i=31;i>=0;i--)
        {
            int bit=((num>>i)&1);
            if(node.contains(1-bit))
            {
                max=(max|(1<<i));
                node=node.get(1-bit);
            }
            else
            {
                node=node.get(bit);
            }
            
        }
        return max;
    }
}