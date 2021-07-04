class Solution {
    ArrayList[] graph;
    Integer[][] dp=null;
    int count,mod=1000000007,l;
    public int countVowelPermutation(int n) {
        l=n;
        graph=new ArrayList[5];
        ArrayList<Integer> al;
        dp=new Integer[5][n+1];
        //a
        al=new ArrayList<>();
        al.add(1);
        graph[0]=al;
        //e
        al=new ArrayList<>();
        al.add(0);
        al.add(2);
        graph[1]=al;
        //i
        al=new ArrayList<>();
        al.add(0);
        al.add(1);
        al.add(3);
        al.add(4);
        graph[2]=al;
        //o
        al=new ArrayList<>();
        al.add(2);
        al.add(4);
        graph[3]=al;
        //u
        al=new ArrayList<>();
        al.add(0);
        graph[4]=al;
        count=0;
        if(n==1){
            return 5;
        }
        for(int i=0;i<5;i++){
            count=(count+findCount(i,1))%mod;
        }
        return count;
    }
    private int findCount(int i,int length){
        if(length==l){
            return 1;
        }
        if(dp[i][length]==null){
            int temp=0;
            ArrayList<Integer> al=graph[i];
            for(int j=0;j<al.size();j++){
                temp=(temp+findCount(al.get(j),length+1))%mod;
            }
            dp[i][length]=temp;
        }
        count=(count+dp[i][length])%mod;
        return dp[i][length];
    }
}
