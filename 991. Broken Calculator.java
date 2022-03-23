class Solution {
    public int brokenCalc(int startValue, int target) {
        int count=0;
        while(target>startValue){
            if(target%2==1){
                target++;
            }
            else{
                target/=2;
            }
            count++;
        }
        count+=startValue-target;
        return count;
    }
}
