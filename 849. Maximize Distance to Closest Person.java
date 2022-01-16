class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] ans=new int[seats.length];
        int p=Integer.MAX_VALUE;
        //Left
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                p=0;
                ans[i]=0;
            }
            else if(p==Integer.MAX_VALUE){
                ans[i]=p;
            }
            else{
                p++;
                ans[i]=p;
            }
        }
        p=Integer.MAX_VALUE;
        //Right
        for(int i=seats.length-1;i>=0;i--){
            if(seats[i]==1){
                p=0;
                ans[i]=0;
            }
            else if(p==Integer.MAX_VALUE){
                ans[i]=Math.min(ans[i],p);
            }
            else{
                p++;
                ans[i]=Math.min(ans[i],p);
            }
        }
        p=0;
        //Finding ans
        for(int i=0;i<ans.length;i++){
            if(ans[i]==0){
                continue;
            }
            p=Math.max(p,ans[i]);
        }
        return p;
    }
}
