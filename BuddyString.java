class Solution {
    public boolean buddyStrings(String s, String goal) {
        char[] p=new char[2];
        char[] q=new char[2];
        int count=0,l1,l2;
        l1=s.length();
        l2=goal.length();
        if(l1!=l2 || l1==1 ){
            return false;
        }
        for(int i=0;i<l1;i++){
            if(s.charAt(i)!=goal.charAt(i)){
                if(count==2){
                    return false;
                }
                p[count]=s.charAt(i);
                q[count]=goal.charAt(i);
                count++;
            }
        }
        char c;
        int flag=0;
        if(count==0){
            Set<Character> set=new HashSet<>();
            for(int i=0;i<l1;i++){
                c=s.charAt(i);
                if(set.contains(c)){
                    flag=1;
                }
                set.add(c);
            }
            if(flag==1){
                return true;
            }
            return false;
        }
        if(p[0]==q[1] && p[1]==q[0]){
            return true;
        }
        return false;
    }
}
