class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        for(int i=0;i<cost.length;i++){
            cost[i]=gas[i]-cost[i];
        }
        for(int i=cost.length-1;i>=0;i--){
            sum+=cost[i];
            if(sum>0){
                sum=0;
                gas[i]=0;
            }
            else{
                gas[i]=-sum;
            }
        }
        sum=0;
        for(int i=cost.length-1;i>=0;i--){
            sum+=cost[i];
            if(gas[i]==0){
                if(sum>=gas[0]){
                    return i;
                }
            }
        }
        return -1;
    }
}
