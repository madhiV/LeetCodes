class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp=new int[dungeon.length+1][dungeon[0].length+1];
        int min;
        //Filling max values for last row and last col...
        for(int j=dungeon[0].length,i=0;i<=dungeon.length;i++){
            dp[i][j]=Integer.MAX_VALUE;
        }
        for(int i=dungeon.length,j=0;j<=dungeon[0].length;j++){
            dp[i][j]=Integer.MAX_VALUE;
        }
        dp[dungeon.length][dungeon[0].length-1]=1;
        dp[dungeon.length-1][dungeon[0].length]=1;
        for(int i=dungeon.length-1;i>=0;i--){
            for(int j=dungeon[0].length-1;j>=0;j--){
                min=Math.min(dp[i][j+1],dp[i+1][j]);
                if(dungeon[i][j]>=0){
                    if(min<=dungeon[i][j]){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j]=min-dungeon[i][j];
                    }
                }
                else{
                    dp[i][j]=Math.abs(dungeon[i][j])+min;
                }
            }
        }
        return dp[0][0];
    }
}
