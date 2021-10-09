class Solution {
    int[][] dir=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ll=new LinkedList<>();
        boolean flag;
        for(int k=0;k<words.length;k++){
            flag=false;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==words[k].charAt(0) && isPresent(board,words[k],0,i,j)){
                        ll.add(words[k]);
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
        }
        return ll;
    }
    public boolean isPresent(char[][] board,String word,int index,int i,int j){
        if(index==word.length()-1){
            return true;
        }
        int x,y;
        boolean flag=false;
        char prev=board[i][j];
        board[i][j]='.';
        for(int[] k:dir){
            x=k[0]+i;
            y=k[1]+j;
            if(x==-1 || y==-1 || x==board.length || y==board[0].length || board[x][y]!=word.charAt(index+1)){
                continue;
            }
            if(isPresent(board,word,index+1,x,y)){
                flag=true;
                break;
            }
        }
        board[i][j]=prev;
        return flag;
    }
}
