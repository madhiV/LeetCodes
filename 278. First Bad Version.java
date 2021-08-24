/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int ans=-1,mid;
        long l,r;
        l=1;
        r=n;
        while(l<=r){
            mid=(int)((l+r)/2);
            if(isBadVersion(mid)){
                ans=mid;
                if(l==r){
                    break;
                }
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}
