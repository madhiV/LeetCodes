class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set=new HashSet<>();
        //checking rows
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }
        //checking columns
        for(int j=0;j<9;j++){
            for(int i=0;i<9;i++){
                if(board[i][j]!='.' && set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }
        //checking boxes
        for(int r=0;r<9;r+=3){
            for(int c=0;c<9;c+=3){
                for(int i=r;i<r+3;i++){
                    for(int j=c;j<c+3;j++){
                        if(board[i][j]!='.' && set.contains(board[i][j])){
                            return false;
                        }
                        set.add(board[i][j]);
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
