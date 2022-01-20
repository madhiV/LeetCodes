import java.util.*;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int m,l,r,ans=Integer.MAX_VALUE;
        l=1;
        r=1;
        for(int i=0;i<piles.length;i++){
            r=Math.max(r,piles[i]);
        }
        while(l<=r){
            m=(l+r)/2;
            if(satisfies(piles,m,h)){
                r=m-1;
                ans=Math.min(ans,m);
            }
            else{
                l=m+1;
            }
        }
        return ans;
    }
    public boolean satisfies(int[] piles,int k,int h){
        int count=0;
        for(int i=0;i<piles.length;i++){
            count+=piles[i]/k;
            if(piles[i]%k!=0){
                count++;
            }
        }
        return count<=h;
    }
}
