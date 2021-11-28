class Solution {
    public int count;
    public LinkedList<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int[] visited=new int[graph.length];
        List<Integer> al=new ArrayList<>();
        ans=new LinkedList<>();
        count=0;
        al.add(0);
        computeCount(graph,0,visited,al);
        return ans;
    }
    public void computeCount(int[][] graph,int i,int[] visited,List<Integer> al){
        if(i==graph.length-1){
            List<Integer> l=new ArrayList<>();
            for(int k:al){
                l.add(k);
            }
            ans.add(l);
            return;
        }
        for(int j=0;j<graph[i].length;j++){
            if(visited[graph[i][j]]==1){
                continue;
            }
            al.add(graph[i][j]);
            visited[graph[i][j]]=1;
            computeCount(graph,graph[i][j],visited,al);
            visited[graph[i][j]]=0;
            al.remove(al.size()-1);
        }
    }
}
