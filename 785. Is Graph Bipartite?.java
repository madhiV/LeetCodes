import java.util.HashSet;
class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] explored=new boolean[graph.length];
        int[] setNumber=new int[graph.length];
        for(int node=0;node<graph.length;node++){
            if(!isBipartite(node,explored,setNumber,graph)){
                return false;
            }
        }
        return true;
    }
    private boolean isBipartite(int currentNode,boolean[] explored,int[] setNumber,int[][] graph){
        if(explored[currentNode]){
            return true;
        }
        explored[currentNode]=true;
        if(setNumber[currentNode]==0){
            setNumber[currentNode]=1;
        }
        //Checking for current node's bipartite...
        for(int neighbor:graph[currentNode]){
            if(setNumber[neighbor]==0){
                setNumber[neighbor]=setNumber[currentNode]==1?2:1;
            }
            else if(setNumber[neighbor]==setNumber[currentNode]){
                return false;
            }
        }
        //Checking for adjacent node's bipartite...
        for(int neighbor:graph[currentNode]){
            if(!isBipartite(neighbor,explored,setNumber,graph)){
                return false;
            }
        }
        return true;
    }
}
