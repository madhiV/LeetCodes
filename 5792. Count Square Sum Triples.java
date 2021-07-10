class Solution {
    public int countTriples(int n) {
        int count=0,temp,sum,l,r;
        for(int i=n;i>=5;i--){
            temp=i*i;
            r=i-1;
            l=1;
            while(l<r){
                sum=l*l+r*r;
                if(sum==temp){
                    count+=2;
                    l++;
                }
                else if(sum<temp){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }
}
