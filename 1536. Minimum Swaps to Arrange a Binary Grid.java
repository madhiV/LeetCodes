class Solution {
    int[][] grid;
    public int minSwaps(int[][] grid) {
        int i,j,temp,swaps=0;
        this.grid=grid;
        int[] arr=new int[grid.length];
        for(i=0;i<grid.length;i++){
            arr[i]=find(i);
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]<=i+1){
                continue;
            }
            j=-1;
            for(int k=i+1;k<arr.length;k++){
                if(arr[k]<=i+1){
                    j=k;
                    break;
                }
            }
            if(j==-1){
                return -1;
            }
            for(int k=j;k>i;k--){
                temp=arr[k];
                arr[k]=arr[k-1];
                arr[k-1]=temp;
                swaps++;
            }
        }
        if(i==arr.length){
            return swaps;
        }
        return -1;
    }
    public int find(int i){
        for(int j=grid[0].length-1;j>=0;j--){
            if(grid[i][j]==1){
                return j+1;
            }
        }
        return 1;
    }
}
