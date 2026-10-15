/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        //hashmap for storing value and neighbour node
        HashMap<Integer , Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        //head copy
        Node head = new Node(node.val);
        map.put(node.val , head);
        q.add(node);

        while(q.size()>0){
            Node poll = q.poll();
            Node dumy = map.get(poll.val);
            List<Node> neigh = new ArrayList<>();

            for(Node n:poll.neighbors){
                if(map.containsKey(n.val)){
                    neigh.add(map.get(n.val));
                }else{
                    Node news = new Node(n.val);
                    map.put(n.val , news);
                    neigh.add(news);
                    q.add(n);
                }
            }

            dumy.neighbors = neigh;
        }

        return head;
    }
}