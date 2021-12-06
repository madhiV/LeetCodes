class Solution {
    public int minCostToMoveChips(int[] position) {
        int first=0,second=0;
        for(int i=0;i<position.length;i++){
            if(position[i]%2==0){
                second++;
            }
            else{
                first++;
            }
        }
        return Math.min(first,second);
    }
}
