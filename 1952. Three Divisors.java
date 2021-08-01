class Solution {
    public boolean isThree(int n) {
        int count=0;
        for(int i=1;i<((int)Math.sqrt(n))+1;i++){
            if(i*i==n){
                count++;
            }
            else if(n%i==0){
                count+=2;
            }
        }
        if(count==3){
            return true;
        }
        return false;
    }
}
