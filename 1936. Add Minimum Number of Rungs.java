class Solution {
    public int addRungs(int[] rungs, int dist) {
        int i=0,count=0,temp;
        long curr=0;
        while(i<rungs.length){
            while(i<rungs.length && curr+dist>=rungs[i]){
                curr=rungs[i];
                i++;
            }
            if(i<rungs.length){
                temp=((int)(rungs[i]-curr))/dist;
                if(temp*dist+curr!=rungs[i]){
                    curr=temp+dist;
                    count++;
                }
                curr+=rungs[i];
                count+=temp-1;
            }
        }
        return count;
    }
}
