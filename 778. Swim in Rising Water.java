import java.util.*;
class Node implements Comparable<Node>{
    int time,i,j;
    Node(int a,int b,int c){
        time=a;
        i=b;
        j=c;
    }
    @Override
    public int compareTo(Node o){
        if(time>o.time){
            return 1;
        }
        return -1;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Node> q=new PriorityQueue<>();
        int n=grid.length;
        q.add(new Node(grid[0][0],0,0));
        Node p;
        int i,j;
        while(!q.isEmpty()){
            p=q.poll();
            i=p.i;
            j=p.j;
            grid[p.i][p.j]=-1;
            if(p.i==n-1 && p.j==n-1){
                return p.time;
            }
            //Up
            if(i-1>=0 && grid[i-1][j]!=-1){
                q.add(new Node(Math.max(grid[i-1][j],p.time),i-1,j));
            }
            //Down
            if(i+1<=n-1 && grid[i+1][j]!=-1){
                q.add(new Node(Math.max(grid[i+1][j],p.time),i+1,j));
            }
            //Left
            if(j-1>=0 && grid[i][j-1]!=-1){
                q.add(new Node(Math.max(p.time,grid[i][j-1]),i,j-1));
            }
            //Right
            if(j+1<n && grid[i][j+1]!=-1){
                q.add(new Node(Math.max(p.time,grid[i][j+1]),i,j+1));
            }
        }
        return -1;
    }
}
