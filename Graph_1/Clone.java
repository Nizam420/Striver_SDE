class Solution {
    public Node clone(Node node, Map<Integer, Node> cache) {
       Node newNode = new Node(node.val);
       cache.put(node.val, newNode);
       for(Node n : node.neighbors) {
           if(cache.containsKey(n.val)) {
               newNode.neighbors.add(cache.get(n.val));
               continue;
           } 
           
           newNode.neighbors.add(clone(n, cache));
       }
       return newNode;
   }
   public Node cloneGraph(Node node) {
       if(node == null) return null;
       return clone(node, new HashMap());
   }
}