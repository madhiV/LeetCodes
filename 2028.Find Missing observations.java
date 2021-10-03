class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int i,sum=0,bal=0,curr,total;
        for(i=0;i<rolls.length;i++){
            sum+=rolls[i];
        }
        total=(rolls.length+n)*mean;
        bal=total-sum;
        if(bal<n || bal>6*n){
            return new int[]{};
        }
        i=0;
        curr=6;
        int[] arr=new int[n];
        while(i<n){
            if(bal-curr<n-i-1){
                curr--;
                continue;
            }
            bal-=curr;
            arr[i]=curr;
            i++;
        }
        return arr;
    }
}
