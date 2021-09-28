class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> al=new ArrayList<>();
        int i,j,up,down,left,right,totalCount;
        totalCount=matrix.length*matrix[0].length;
        i=j=0;
        up=1;
        right=matrix[0].length-1;
        down=matrix.length-1;
        left=0;
        while(al.size()!=totalCount){
            //Right
            while(j!=right){
                al.add(matrix[i][j]);
                j++;
            }
            al.add(matrix[i][j]);
            i++;
            right--;
            if(al.size()==totalCount){
                break;
            }
            //Down
            while(i!=down){
                al.add(matrix[i][j]);
                i++;
            }
            al.add(matrix[i][j]);
            j--;
            down--;
            if(al.size()==totalCount){
                break;
            }
            //Left
            while(j!=left){
                al.add(matrix[i][j]);
                j--;
            }
            left++;
            al.add(matrix[i][j]);
            i--;
            if(al.size()==totalCount){
                break;
            }
            //Up 
            while(i!=up){
                al.add(matrix[i][j]);
                i--;
            }
            up++;
            al.add(matrix[i][j]);
            j++;
            if(al.size()==totalCount){
                break;
            }
        }
        return al;
    }
}