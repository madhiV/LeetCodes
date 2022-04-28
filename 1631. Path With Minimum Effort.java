import java.util.*;
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> effortTillNowPQ=new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    return a[2]-b[2];
                }
            }
        );
        final int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        effortTillNowPQ.add(new int[]{0,0,0});
        //Computing answer...
        while(!effortTillNowPQ.isEmpty()){
            int[] popedEntry=effortTillNowPQ.poll();
            int row=popedEntry[0];
            int column=popedEntry[1];
            int currentEffort=popedEntry[2];
            //Checking if entry has reached bottom right cell...
            if(row==heights.length-1 && column==heights[0].length-1){
                return currentEffort;
            }
            //Already visited
            if(heights[row][column]==-1){
                continue;
            }
            //Go to all directions...
            for(int[] direction:directions){
                int x=direction[0]+row;
                int y=direction[1]+column;
                //Check boundary conditions...
                if(x==-1 || y==-1 || x==heights.length || y==heights[0].length || heights[x][y]==-1){
                    continue;
                }
                effortTillNowPQ.add(new int[]{x,y,Math.max(currentEffort,Math.abs(heights[x][y]-heights[row][column]))});
            }
            heights[row][column]=-1;
        }
        return -1;
    }
}
