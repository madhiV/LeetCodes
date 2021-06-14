class Solution {
    public int myAtoi(String s) {
        StringBuilder t=new StringBuilder("");
        s=s.trim();
        int i=0;
        char c;
        int flag=1;
        if(s.length()==0){
            return 0;
        }
        if(Character.isDigit(s.charAt(0))==false){
            c=s.charAt(0);
            if(c=='+' || c=='-'){
                if(c=='-'){
                    flag=0;
                }
            }
            else{
                return 0;
            }
            i++;
        }
        while(i<s.length()){
            c=s.charAt(i);
            if(Character.isDigit(c)==false){
                break;
            }
            if(t.length()==0){
                if(c=='0'){
                    i++;
                    continue;
                }
            }
            t.append(c);
            i++;
        }
        if(t.length()>10){
            if(flag==1){
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }
        if(t.length()==10){
            if(Long.parseLong(String.valueOf(t.toString()))>(long)Integer.MAX_VALUE){
                if(flag==1){
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
            }
        }
        if(t.length()==0){
            return 0;
        }
        if(flag==0){
            return -Integer.parseInt(String.valueOf(t.toString()));
        }
        return Integer.parseInt(String.valueOf(t.toString()));
    }
}
