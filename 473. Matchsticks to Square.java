class Solution {
    public boolean makesquare(int[] matchsticks) {
        int[] side=new int[4];
        int sum=0;
        for(int i=0;i<matchsticks.length;i++){
            sum+=matchsticks[i];
        }
        if(sum%4!=0){
            return false;
        }
        return canForm(matchsticks,side,sum/4,0);
    }
    boolean canForm(int[] matchsticks,int[] side,int a,int index){
       if(side[0]==a && side[0]==side[1] &&side[1]==side[2] && side[2]==side[3]){
           return true;
       }
       if(index>=matchsticks.length){
           return false;
       }
       for(int i=0;i<4;i++){
           side[i]+=matchsticks[index];
           if(side[i]<=a){
               if(canForm(matchsticks,side,a,index+1)){
                   return true;
               }
           }
           side[i]-=matchsticks[index];
       }
        return false;
    }
}
