import java.util.*;
class Node implements Comparable<Node>{
    int index;
    int start;
    int end;
    Node(int a,int b,int c){
        index=a;
        start=b;
        end=c;
    }
    @Override
    public int compareTo(Node o){
        if(start>o.start){
            return 1;
        }
        else if(start==o.start){
            if(end>o.end){
                return 1;
            }
        }
        return -1;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<List<Integer>> al=new ArrayList<>();
        ArrayList<Integer> l;
        PriorityQueue<Node> q=new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            q.add(new Node(i,intervals[i][0],intervals[i][1]));
        }
        Node p;
        while(!q.isEmpty()){
            p=q.poll();
            while(!q.isEmpty()){
                if(q.peek().start<=p.end){
                    p.end=Math.max(q.poll().end,p.end);
                }
                else{
                    break;
                }
            }
            l=new ArrayList<>();
            l.add(p.start);
            l.add(p.end);
            al.add(l);
        }
        int[][] arr=new int[al.size()][2];
        for(int i=0;i<al.size();i++){
            arr[i][0]=al.get(i).get(0);
            arr[i][1]=al.get(i).get(1);
        }
        return arr;
    }
}
