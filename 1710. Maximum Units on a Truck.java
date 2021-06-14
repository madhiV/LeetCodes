import java.util.*;
class Node implements Comparable<Node>{
    int units;
    int n;
    Node(int a,int b){
        units=a;
        n=b;
    }
    @Override
    public int compareTo(Node a){
        if(a.units>units){
            return 1;
        }
        return -1;
    }
}
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int count=0,ans=0;
        PriorityQueue<Node> q=new PriorityQueue<>();
        for(int i=0;i<boxTypes.length;i++){
            q.add(new Node(boxTypes[i][1],boxTypes[i][0]));
        }
        Node p;
        int t;
        while(!q.isEmpty()){
            p=q.peek();
            q.remove();
            t=p.n;
            while(t!=0){
                t--;
                count++;
                ans+=p.units;
                if(count==truckSize){
                    return ans;
                }
            }
        }
        return ans;
    }
}
