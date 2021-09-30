class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        int min,size,max,level;
        Map<Integer,List<Integer>> map=new HashMap<>();
        List<Integer> l;
        ArrayList<Integer> al=new ArrayList<>();
        Queue<Object[]> q=new LinkedList<>();
        Object[] p;
        Node node;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        q.add(new Object[]{root,0});
        while(!q.isEmpty()){
            size=q.size();
            while(size-->0){
                p=q.poll();
                node=(Node)p[0];
                level=(int)p[1];
                max=Math.max(max,level);
                min=Math.min(min,level);
                l=map.getOrDefault(level,new ArrayList<>());
                l.add(node.data);
                map.put(level,l);
                if(node.left!=null){
                    q.add(new Object[]{node.left,level-1});
                }
                if(node.right!=null){
                    q.add(new Object[]{node.right,level+1});
                }
            }
        }
        for(int i=min;i<=max;i++){
            for(int k:map.get(i)){
                al.add(k);
            }
        }
        return al;
    }
}
