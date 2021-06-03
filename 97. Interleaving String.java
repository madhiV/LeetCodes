class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int[][] T=new int[s1.length()+1][s2.length()+1];
        return func(s1,s2,s3,0,0,0,T);
    }
    boolean func(String s1,String s2,String s3,int i,int j,int k,int[][] T){
        if(k==s3.length()){
            return true;
        }
        if(i!=s1.length() && s3.charAt(k)==s1.charAt(i)){
            if(T[i][j]==-1){
                return false;
            }
            if(T[i][j]==1){
                return true;
            }
            if(func(s1,s2,s3,i+1,j,k+1,T)){
                T[i+1][j]=1;
                return true;
            }
        }
        if(j!=s2.length() && s2.charAt(j)==s3.charAt(k)){
            if(T[i][j]==-1){
                return false;
            }
            if(T[i][j]==1){
                return true;
            }
            if(func(s1,s2,s3,i,j+1,k+1,T)){
                T[i][j+1]=1;
                return true;
            }
        }
        T[i][j]=-1;
        return false;
    }
}
