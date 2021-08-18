import java.util.*;
class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        ArrayList<Integer> l;
        l=new ArrayList<>();
        l.add(1);
        al.add(l);
        if(rowIndex==0){
            return l;
        }
        l=new ArrayList<>();
        l.add(1);
        l.add(1);
        al.add(l);
        for(int i=2;i<=rowIndex;i++){
            l=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    l.add(1);
                }
                else{
                    l.add(al.get(i-1).get(j)+al.get(i-1).get(j-1));
                }
            }
            al.add(l);
        }
        return al.get(al.size()-1);
    }
}
