import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min;
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                //left-Up
                min=Integer.MAX_VALUE;
                if(j-1>=0){
                    min=triangle.get(i-1).get(j-1);
                }
                //Up
                if(j<triangle.get(i-1).size()){
                    min=Math.min(min,triangle.get(i-1).get(j));
                }
                triangle.get(i).set(j,triangle.get(i).get(j)+min);
            }
        }
        min=Integer.MAX_VALUE;
        for(int k:triangle.get(triangle.size()-1)){
            min=Math.min(min,k);
        }
        return min;
    }
}
