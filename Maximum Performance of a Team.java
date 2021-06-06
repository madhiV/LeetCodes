class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        if(k==1){
            int max=-1;
            for(int i=0;i<n;i++){
                if(speed[i]*efficiency[i]>max){
                    max=speed[i]*efficiency[i];
                }
            }
            return max;
        }
        return maxEff(0,speed,efficiency,0,0,Integer.MAX_VALUE,k,0);
    }
    /*s->selected engineer
    ans->maxPerformance
    sum->sum of speeds of selected engineers
    eff->minimum efficiency of selected engineers
    size->number of engineers selected*/
    int maxEff(int s,int[] speed,int[] efficiency,int ans,int sum,int eff,int k,int size){
        if(sum*eff>ans){
            ans=sum*eff;
        }
        if(size==k){
            return ans;
        }
        int temp;
        for(int i=s;i<speed.length;i++){
            temp=eff;
            if(temp>efficiency[i]){
                temp=efficiency[i];
            }
            ans=maxEff(i+1,speed,efficiency,ans,sum+speed[i],temp,k,size+1);
        }
        return ans;
    }
}
