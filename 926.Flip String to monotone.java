class Solution {
    public int minFlipsMonoIncr(String s) {
        int min=Integer.MAX_VALUE,zero=0,flips=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zero++;
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zero--;
                if(zero==0){
                    min=Math.min(flips,min);
                }
            }
            else{
                min=Math.min(min,flips+zero);
                flips++;
            }
        }
        return min;
    }
}
