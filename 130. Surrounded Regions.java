import java.util.*;
class Solution {
    int[][] dir=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        Queue<int[]> q1,q2;
        int[][] left=new int[board.length][board[0].length],right=new int[board.length][board[0].length],up=new int[board.length][board[0].length],down=new int[board.length][board[0].length];
        boolean flag;
        int[] p;
        //Left
        for(int i=0;i<board.length;i++){
            flag=false;
            for(int j=0;j<board[0].length;j++){
                if(flag){
                    left[i][j]=1;
                    continue;
                }
                if(board[i][j]=='X'){
                    flag=true;
                }
            }
        }
        
        //Right
        for(int i=0;i<board.length;i++){
            flag=false;
            for(int j=board[0].length-1;j>=0;j--){
                if(flag){
                    right[i][j]=1;
                    continue;
                }
                if(board[i][j]=='X'){
                    flag=true;
                }
            }
        }
        
        //Down
        for(int j=0;j<board[0].length;j++){
            flag=false;
            for(int i=board.length-1;i>=0;i--){
                if(flag){
                    down[i][j]=1;
                    continue;
                }
                if(board[i][j]=='X'){
                    flag=true;
                }
            }
        }
        
        //Up
        for(int j=0;j<board[0].length;j++){
            flag=false;
            for(int i=0;i<board.length;i++){
                if(flag){
                    up[i][j]=1;
                    continue;
                }
                if(board[i][j]=='X'){
                    flag=true;
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    q1=new LinkedList<>();
                    q2=new LinkedList<>();
                    addAllOnes(board,i,j,q1);
                    flag=true;
                    while(!q1.isEmpty()){
                        p=q1.poll();
                        if(left[p[0]][p[1]]==0 || right[p[0]][p[1]]==0 || up[p[0]][p[1]]==0 || down[p[0]][p[1]]==0){
                            flag=false;
                        }
                        q2.add(p);
                    }
                    while(!q2.isEmpty()){
                        p=q2.poll();
                        if(flag){
                            board[p[0]][p[1]]='1';//Finally change all 1 entries in board to 'X'
                        }
                        else{
                            board[p[0]][p[1]]='0';//Finally change all 0 entries in board to 'O'
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='1'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='0'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void addAllOnes(char[][] board,int i,int j,Queue<int[]> q){
        int x,y;
        board[i][j]='P';
        q.add(new int[]{i,j});
        for(int[] k:dir){
            x=k[0]+i;
            y=k[1]+j;
            if(x==-1 || y==-1 || x==board.length || y==board[0].length || board[x][y]!='O'){
                continue;
            }
            addAllOnes(board,x,y,q);
        }
    }
}
