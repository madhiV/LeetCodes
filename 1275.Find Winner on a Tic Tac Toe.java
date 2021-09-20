class Solution {
    char[][] grid;
    public String tictactoe(int[][] moves) {
        grid=new char[3][3];
        int turn=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j]='-';
            }
        }
        for(int i=0;i<moves.length;i++){
            grid[moves[i][0]][moves[i][1]]=(char)(turn+88);
            turn=(turn+1)%2;
        }
        if(diagonalWin('X') || rowWin('X') || colWin('X')){
            return "A";
        }
        if(diagonalWin('Y') || rowWin('Y') || colWin('Y')){
            return "B";
        }
        if(isCellsFilled()){
            return "Draw";
        }
        return "Pending";
    }
    public boolean diagonalWin(char c){
        boolean flag=true;
        //Left-Right diagonal
        for(int i=0,j=0;i<3;i++,j++){
            if(grid[i][j]!=c){
                flag=false;
                break;
            }
        }
        if(flag){
            return true;
        }
        flag=true;
        //Right - Left diagonal
        for(int i=0,j=2;i<3;i++,j--){
            if(grid[i][j]!=c){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public boolean rowWin(char c){
        boolean flag;
        for(int i=0;i<3;i++){
            flag=true;
            for(int j=0;j<3;j++){
                if(grid[i][j]!=c){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
    public boolean colWin(char c){
        boolean flag;
        for(int j=0;j<3;j++){
            flag=true;
            for(int i=0;i<3;i++){
                if(grid[i][j]!=c){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
    public boolean isCellsFilled (){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }
}
