class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int max=-1,l,r,l1=0,l2=0;
        int[][] table=new int[n][n];
        for(int k=0;k<n;k++){//Diagonal looping
            for(int i=0,j=k;i<n-k && j<n;i++,j++){
                if(j-i==0){//filling up first diagonal
                    table[i][j]=1;
                    if((j-i+1)>max){
                        max=j-i+1;
                        l1=i;
                        l2=j;
                    }
                }
                else if(j-i==1){//2nd diagonal 
                    if(s.charAt(i)==s.charAt(j)){
                        table[i][j]=1;
                        if((j-i+1)>max){
                            max=j-i+1;
                            l1=i;
                            l2=j;
                        }
                    }
                }
                else{//Other diagonals
                    if(s.charAt(i)==s.charAt(j)){
                        l=i+1;
                        r=j-1;
                        while(r-l!=0 && r-l!=1){
                            if(table[l][r]==0){
                                break;
                            }
                            r--;
                            l++;
                        }
                        if(r-l==0){
                            table[i][j]=1;
                            if((j-i+1)>max){
                                max=j-i+1;
                                l1=i;
                                l2=j;
                            }
                        }
                        else if(r-l==1 && s.charAt(r)==s.charAt(l)){
                            table[i][j]=1;
                            if((j-i+1)>max){
                                max=j-i+1;
                                l1=i;
                                l2=j;
                            }
                        }
                    }
                }
            }
        }
        return s.substring(l1,l2+1);
    }
}
