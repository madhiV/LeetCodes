class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max=0,i,start,temp;
        //Finding max consecutive true...
        i=start=0;
        temp=k;
        while(i<answerKey.length()){
            if(answerKey.charAt(i)=='F'){
                if(temp>0){
                    temp--;
                    max=Math.max(max,i-start+1);
                }
                else{
                    while(answerKey.charAt(start)!='F'){
                        start++;
                    }
                    start++;
                }
            }
            else{
                max=Math.max(max,i-start+1);
            }
            i++;
        }
        //Finding max consecutive false...
        i=start=0;
        temp=k;
        while(i<answerKey.length()){
            if(answerKey.charAt(i)=='T'){
                if(temp>0){
                    temp--;
                    max=Math.max(max,i-start+1);
                }
                else{
                    while(answerKey.charAt(start)!='T'){
                        start++;
                    }
                    start++;
                }
            }
            else{
                max=Math.max(max,i-start+1);
            }
            i++;
        }
        return max;
    }
}
