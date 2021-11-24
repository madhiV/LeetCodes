import java.util.*;
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> al=new ArrayList<>();
        int start,end;
        int[][] ans;
        for(int i=0;i<secondList.length;i++){
            for(int j=0;j<firstList.length;j++){
                start=end=-1;
                if(firstList[j][0]<=secondList[i][1] && firstList[j][1]>=secondList[i][0]){
                    start=Math.max(secondList[i][0],firstList[j][0]);
                    end=Math.min(secondList[i][1],firstList[j][1]);
                    al.add(new int[]{start,end});
                }
            }
        }
        ans=new int[al.size()][2];
        for(int i=0;i<al.size();i++){
            ans[i][0]=al.get(i)[0];
            ans[i][1]=al.get(i)[1];
        }
        return ans;
    }
}
