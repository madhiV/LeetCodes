import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ml=new ArrayList<List<Integer>>();
        ArrayList<Integer> l=new ArrayList<>();
        comb(ml,l,n,k,1);
        return ml;
    }
    void comb(List<List<Integer>> ml,ArrayList<Integer> l,int n,int k,int s){
        if(k==l.size()){
            ml.add(new ArrayList(l));
            return;
        }
        for(int i=s;i<=n;i++){
            l.add(i);
            comb(ml,l,n,k,i+1);
            l.remove(l.size()-1);
        }
    }
}
