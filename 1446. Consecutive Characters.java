class Solution {
    public int maxPower(String s) {
        int curr,max;
        char prev=s.charAt(0);
        max=1;
        curr=1;
        for(int i=1;i<s.length();i++){
            if(prev==s.charAt(i)){
                curr++;
                max=Math.max(max,curr);
            }
            else{
                prev=s.charAt(i);
                curr=1;
            }
        }
        return max;
    }
}
