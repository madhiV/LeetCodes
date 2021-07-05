class Solution {
    public boolean isHappy(int n) {
        int temp=n,t1=n;
        temp=t1=squareSum(t1);
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<30;i++){
            t1=squareSum(t1);
            if(t1==1){
                break;
            }
            if(set.contains(t1)){
                return false;
            }
            set.add(t1);
        }
        return true;
    }
    int squareSum(int t){
        int count=0;
        while(t!=0){
            count+=(t%10)*(t%10);
            t/=10;
        }
        return count;
    }
}
