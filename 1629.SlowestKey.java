class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max=0,index;
        char ans='m';
        for(int i=releaseTimes.length-1;i>0;i--){
            releaseTimes[i]-=releaseTimes[i-1];
            if(max==releaseTimes[i]){
                if(ans<keysPressed.charAt(i)){
                    ans=keysPressed.charAt(i);
                }
            }
            else if(max<releaseTimes[i]){
                max=releaseTimes[i];
                ans=keysPressed.charAt(i);
            }
        }
        if(max==releaseTimes[0]){
            if(ans<keysPressed.charAt(0)){
                ans=keysPressed.charAt(0);
            }
        }
        else if(max<releaseTimes[0]){
            ans=keysPressed.charAt(0);
        }
        return ans;
    }
}
