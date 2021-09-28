class Solution {
    public boolean isNumber(String s) {
        // Empty string...
        if(s.length()==0){
            return false;
        }
        int i=0;
        while(i<s.length() && s.charAt(i)!='e' && s.charAt(i)!='E'){
            i++;
        }
        if(i==s.length()){
            return isDecimal(s) || isInteger(s);
        }
        return (isDecimal(s.substring(0,i)) || isInteger(s.substring(0,i))) && isInteger(s.substring(i+1,s.length()));
    }
    public boolean isDecimal(String s){
        int i=0;
        char[] ch=s.toCharArray();
        boolean flag=false;
        //String is empty...
        if(i==ch.length){
            return false;
        }
        
        //First character is a symbol...
        if(ch[i]=='+' || ch[i]=='-'){
            i++;
        }
        //String contains only symbol...
        if(i==ch.length){
            return false;
        }
        
        while(i<ch.length && ch[i]!='.'){
            flag=true;//To confirm the string has atleast one digit...
            if(!Character.isDigit(ch[i])){
                return false;
            }
            i++;
        }
        
        if(i==ch.length-1 && flag){
            return true;//one or more digits followed by a dot...
        }
        
        i++;
        if(i==ch.length){
            return false;
        }
        while(i<ch.length && Character.isDigit(ch[i])){
            i++;
        }
        return i==ch.length;
    }
    public boolean isInteger(String s){
        int i=0;
        char[] ch=s.toCharArray();
        boolean flag=false;
        //String is empty...
        if(i==ch.length){
            return false;
        }
        
        //First character is a symbol...
        if(ch[i]=='+' || ch[i]=='-'){
            i++;
        }
        //String contains only symbol...
        if(i==ch.length){
            return false;
        }
        
        while(i<ch.length){
            flag=true;//To confirm the string has atleast one digit...
            if(!Character.isDigit(ch[i])){
                return false;
            }
            i++;
        }
        return i==ch.length;
    }
}
