class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1){
            return "";
        }
        int latest=0;
        char c=palindrome.charAt(0);
        boolean flag=true;
        char[] ch=palindrome.toCharArray();
        
        //Case 1: all characters are same
        for(int i=1;i<ch.length;i++){
            if(ch[i]!=c){
                flag=false;
                break;
            }
        }
        if(flag){
            if(c=='a'){
                ch[ch.length-1]='b';
                return String.valueOf(ch);
            }
            else{
                ch[0]='a';
                return String.valueOf(ch);
            }
        }
        
        //Case 2: all characters are same except middle of odd length palindrome
        if(ch.length%2!=0){
            c=ch[0];
            for(int i=1;i<ch.length;i++){//Finding latest different character...
                if(ch[i]!=c){
                    latest=i;
                }
            }
            if(latest==ch.length/2){//if latest is at middle then true
                if(c==97){
                    ch[ch.length-1]='b';
                }
                else{
                    ch[0]='a';
                }
                return String.valueOf(ch);
            }
        }
        
        //Case 3: odd length pallindrome
        if(ch.length%2==1){
            flag=false;//Here flag will be used if a char is replaced or not
            for(int i=0;i<ch.length;i++){
                if(ch[i]==97){
                    latest=i;
                }
                else{
                    ch[i]='a';
                    flag=true;
                    break;
                }
            }
            if(!flag){
                ch[latest]='b';
            }
            return String.valueOf(ch);
        }
        
        //Case 4: even length 
        flag=false;
        for(int i=0;i<ch.length;i++){
            if(ch[i]==97){
                latest=i;
            }
            else{
                ch[i]='a';
                flag=true;
                break;
            }
        }
        if(!flag){
            ch[latest]='b';
        }
        return String.valueOf(ch);
    }
}
