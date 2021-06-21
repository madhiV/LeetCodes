import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> al=new ArrayList<>();
        LinkedList<Integer> l;
            l=new LinkedList<Integer>();
            l.add(1);
            al.add(l);
        for(int i=1;i<numRows;i++){
            l=new LinkedList<Integer>();
            l.add(1);
            for(int j=1;j<i;j++){
                l.add(al.get(i-1).get(j)+al.get(i-1).get(j-1));
            }
            l.add(1);
            al.add(l);
        }
        return al;
    }
}
