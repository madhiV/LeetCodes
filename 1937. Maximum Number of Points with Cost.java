class Solution {
    long[][] points;
    long[][] left,right;
    public long maxPoints(int[][] points) {
        long max=0;
        this.points=new long[points.length][points[0].length];
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points[0].length;j++){
                this.points[i][j]=points[i][j];
            }
        }
        left=new long[points.length][points[0].length];
        right=new long[points.length][points[0].length];
        
        //Filling last row maxs'
        fillRight(points.length-1);
        fillLeft(points.length-1);
        for(int i=points.length-1,j=0;j<points[0].length;j++){
            this.points[i][j]=Math.max(left[i][j],right[i][j]);
        }
        
        //Filling other row maxs'
        for(int i=points.length-2;i>=0;i--){
            for(int j=0;j<points[0].length;j++){
                this.points[i][j]+=this.points[i+1][j];
            }
            if(i==0){
                break;
            }
            fillRight(i);
            fillLeft(i);
            fillRow(i);
        }
        for(int i=0,j=0;j<points[0].length;j++){
            max=Math.max(max,this.points[i][j]);
        }
        return max;
    }
    private void fillRight(int i){
        long max=-1;
        for(int j=0;j<points[0].length;j++){
            max=Math.max(max,points[i][j]);
            right[i][j]=max;
            max--;
        }
    }
    private void fillLeft(int i){
        long max=-1;
        for(int j=points[0].length-1;j>=0;j--){
            max=Math.max(max,points[i][j]);
            left[i][j]=max;
            max--;
        }
    }
    private void fillRow(int i){
        for(int j=0;j<points[0].length;j++){
            points[i][j]=Math.max(left[i][j],right[i][j]);
        }
    }
}
