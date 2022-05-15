import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
class Node{
    private int data;
    private LinkedList<Node> children;
    private LinkedList<Integer> childrenDistances;
    public Node(int data){
        this.data=data;
        children=new LinkedList<>();
        childrenDistances=new LinkedList<>();
    }
    public int getData(){
        return data;
    }
    public LinkedList<Node> getChildren(){
        return children;
    }
    public LinkedList<Integer> getChildrenDistances(){
        return childrenDistances;
    }
    public String toString(){
        return "Node  : "+data;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,Node> nodeMap=new HashMap<>();
        storeNodes(nodeMap,times);
        connectNodes(nodeMap,times);
        //k-1 since 0-indexed
        return networkDelayTime(nodeMap,k-1,n);
    }
    private void storeNodes(HashMap<Integer,Node> nodeMap,int[][] times){
        for(int[] entry:times){
            if(!nodeMap.containsKey(entry[0]-1)){
                nodeMap.put(entry[0]-1,new Node(entry[0]-1));
            }
            if(!nodeMap.containsKey(entry[1]-1)){
                nodeMap.put(entry[1]-1,new Node(entry[1]-1));                
            }
        }
    }
    private void connectNodes(HashMap<Integer,Node> nodeMap,int[][] times){
        for(int[] entry:times){
            Node sourceNode=nodeMap.get(entry[0]-1);
            Node destinationNode=nodeMap.get(entry[1]-1);
            LinkedList<Node> children=sourceNode.getChildren();
            LinkedList<Integer> childrenDistances=sourceNode.getChildrenDistances();
            children.add(destinationNode);
            childrenDistances.add(entry[2]);
        }
    }
    private int networkDelayTime(HashMap<Integer,Node> nodeMap,int startNodeIndex,int nodeCount){
        PriorityQueue<int[]> nodesPQ=new PriorityQueue<>((a,b)->a[1]-b[1]);
        boolean[] visitedNodes=new boolean[nodeCount];
        addNeighbors(nodeMap,startNodeIndex,nodesPQ,0);
        nodeCount--;
        visitedNodes[startNodeIndex]=true;
        int timeTaken=0;
        while(nodeCount!=0 && !nodesPQ.isEmpty()){
            int[] polledEntry=nodesPQ.poll();
            if(visitedNodes[polledEntry[0]]){
                continue;
            }
            visitedNodes[polledEntry[0]]=true;
            nodeCount--;
            timeTaken=polledEntry[1];
            addNeighbors(nodeMap,polledEntry[0],nodesPQ,timeTaken);
        }
        if(nodeCount==0){
            return timeTaken;
        }
        return -1;
    }
    private void addNeighbors(HashMap<Integer,Node> nodeMap,int nodeIndex,PriorityQueue<int[]> nodesPQ,int currentTime){
        Node currentNode=nodeMap.get(nodeIndex);
        List<Node> children=currentNode.getChildren();
        List<Integer> childrenDistances=currentNode.getChildrenDistances();
        for(int index=0;index<children.size();index++){
            Node child=children.get(index);
            nodesPQ.add(new int[]{child.getData(),currentTime+childrenDistances.get(index)});
        }
    }
}
