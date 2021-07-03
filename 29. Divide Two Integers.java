class Solution {
    public int divide(int dividend, int divisor) {
        int c,flag=0,count=0;
        long a=dividend,b=divisor,temp;
        if(a>0){
            flag++;
            temp=a;
            a=temp-temp-temp;
        }
        if(b>0){
            temp=divisor;
            flag++;
            b=temp-temp-temp;
        }
        while(a<=b){
            temp=b;
            c=1;
            while(a<=temp){
                a-=temp;
                count+=c;
                temp+=temp;
                c+=c;
            }
        }
        if(flag==1){
            return -count;
        }
        else{
            if(count==Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return count;
        }
    }
}
