class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q=new LinkedList<>();
        int i,j,target;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        int[] arr;
        target=image[sr][sc];
        for(i=0;i<image.length;i++){
            for(j=0;j<image[0].length;j++){
                if(image[i][j]==target){
                    image[i][j]=-1;
                }
            }
        }
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            arr=q.poll();
            image[arr[0]][arr[1]]=newColor;
            for(int[] k: dir){
                i=arr[0]+k[0];
                j=arr[1]+k[1];
                if(i==-1 || j==-1 || j==image[0].length || i==image.length || image[i][j]!=-1){
                    continue;
                }
                q.add(new int[]{i,j});
            }
        }
        for(i=0;i<image.length;i++){
            for(j=0;j<image[0].length;j++){
                if(image[i][j]==-1){
                    image[i][j]=target;
                }
            }
        }
        return image;
    }
}
