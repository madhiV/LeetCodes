class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int pow=0,log=(int)(Math.log(right)/Math.log(2)),temp,ans=0,i;
        if(left<=(int)(Math.pow(2,log))-1){
            return 0;
        }
        temp=right-1;
        while(left<=temp){
            pow++;
            temp=right-(int)Math.pow(2,pow);
        }
        i=0;
        while(i<=log){
            if(i<pow){
                i++;
                left/=2;
                right/=2;
                continue;
            }
            if(left%2!=0 && right%2!=0){
                ans+=(int)(Math.pow(2,i));
            }
            left/=2;
            right/=2;
            i++;
        }
        return ans;
    }
}
