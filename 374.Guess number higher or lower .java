/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long l,r;
        int mid;
        l=1;
        r=n;
        while(l<=r){
            mid=(int)((l+r)/2);
            n=guess(mid);
            if(n==0){
                return mid;
            }
            if(n>0){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
}
