import java.util.*;
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] sector=new int[n+1];
        sector[rounds[0]]+=1;
        int j;
        for(int i=1;i<rounds.length;i++){
            j=add1(n,rounds[i-1]);
            do{
                sector[j]+=1;
                j=add1(n,j);
            }while(j!=rounds[i]);
            sector[j]+=1;
        }
        int max=-1;
        for(int i=1;i<=n;i++){
            if(max<sector[i]){
                max=sector[i];
            }
        }
        List<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            if(max==sector[i]){
                l.add(i);
            }
        }
        return l;
    }
    public int add1(int n,int i){
        if(i+1>n){
            return 1;
        }
        return i+1;
    }
}
