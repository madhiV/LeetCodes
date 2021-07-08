class Solution {
    int[] one,zero;
    int m,n;
    Integer[][][] dp=null;
    public int findMaxForm(String[] strs, int m, int n) {
        int count1,count2;
        this.m=m;
        this.n=n;
        count1=count2=0;
        dp=new Integer[n+1][m+1][strs.length];
        one=new int[strs.length];
        zero=new int[strs.length];
        for(int i=0;i<strs.length;i++){
            count1=count2=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0'){
                    count1++;
                }
                else{
                    count2++;
                }
            }
            one[i]=count2;
            zero[i]=count1;
        }
        return findLargest(0,0,0);
    }
    int findLargest(int o,int z,int index){
        if(index==one.length){
            return 0;
        }
        if(dp[o][z][index]==null){
            //Not feasible to include in subset
            if(o+one[index]>n || z+zero[index]>m){
                //Exclude
                dp[o][z][index]=findLargest(o,z,index+1);
            }
            else{
                //Exclude , //Include
                dp[o][z][index]=Math.max(findLargest(o,z,index+1),1+findLargest(o+one[index],z+zero[index],index+1));
            }
        }
        return dp[o][z][index];
    }
}
