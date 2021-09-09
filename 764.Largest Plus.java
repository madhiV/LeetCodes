import java.util.*;
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        //ArrayList rowAl is to store all the columns in each row which has 0
        //ArrayList colAl is to store all the row in each column which has 0
        
        ArrayList<TreeSet<Integer>> rowAl=new ArrayList<>();
        ArrayList<TreeSet<Integer>> colAl=new ArrayList<>();
        int left,right,up,down,ans=0;
        for(int i=0;i<n;i++){
            rowAl.add(new TreeSet<>());
            colAl.add(new TreeSet<>());
        }
        for(int i=0;i<mines.length;i++){
            rowAl.get(mines[i][0]).add(mines[i][1]);
            colAl.get(mines[i][1]).add(mines[i][0]);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!rowAl.get(i).contains(j) && !colAl.get(j).contains(i)){
                    left=j;
                    right=n-j-1;
                    up=i;
                    down=n-i-1;
                    //UP
                    if(rowAl.get(i).lower(j)!=null){
                        left=j-rowAl.get(i).lower(j)-1;
                    }
                    //RIGHT
                    if(rowAl.get(i).higher(j)!=null){
                        right=rowAl.get(i).higher(j)-j-1;
                    }
                    //LEFT
                    if(colAl.get(j).lower(i)!=null){
                        up=i-colAl.get(j).lower(i)-1;
                    }
                    //DOWN
                    if(colAl.get(j).higher(i)!=null){
                        down=colAl.get(j).higher(i)-i-1;
                    }
                    ans=Math.max(ans,1+Math.min(up,Math.min(down,Math.min(left,right))));
                }
            }
        }
        return ans;
    }
}
