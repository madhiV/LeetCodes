class Solution {
    HashSet<String> ans;
    Solution(){
        ans=new HashSet<>();
    }
    void comb(StringBuilder t,int o,int c,int n){
        if(o==c && c==n){
            ans.add(t.toString());
            return;
        }
        //include a '('
        if(o!=n){
            t.append('(');
            comb(t,o+1,c,n);
            t.replace(t.length()-1,t.length(),"");
        }
        if(c<o){
            t.append(')');
            comb(t,o,c+1,n);
            t.replace(t.length()-1,t.length(),"");
        }
    }
    public List<String> generateParenthesis(int n) {
        Solution obj=new Solution();
        StringBuilder t=new StringBuilder("");
        obj.comb(t,0,0,n);
        ArrayList<String> al=new ArrayList<>();
        al.addAll(obj.ans);
        return al;
    }
}
