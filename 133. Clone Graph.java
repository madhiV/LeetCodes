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
        Map<Integer,Node> map1=new HashMap<>();//Mapping of value to a node
        Map<Integer,ArrayList<Integer>> map2=new HashMap<>();//Mapping of node val to its neighbor
        Set<Integer> set=new HashSet<>();//To check corresponding node is visited already or not
        Queue<Node> q=new LinkedList<>();
        ArrayList<Integer> al;
        ArrayList<Node> l;
        Node p;
        if(node==null){
            return null;
        }
        //For filling map2
        q.add(node);
        set.add(1);
        while(!q.isEmpty()){
            p=q.poll();
            al=new ArrayList<>();
            for(Node k:p.neighbors){
                al.add(k.val);
                if(!set.contains(k.val)){
                    q.add(k);
                    set.add(k.val);
                }
            }
            map2.put(p.val,al);
        }
        //Creating nodes
        for(int i=1;i<=set.size();i++){
            map1.put(i,new Node(i));
        }
        //Assigning neighbors
        for(int i=1;i<=set.size();i++){
            l=new ArrayList<>();
            for(int k:map2.get(i)){
                l.add(map1.get(k));
            }
            map1.get(i).neighbors=l;
        }
        return map1.get(1);
    }
}
