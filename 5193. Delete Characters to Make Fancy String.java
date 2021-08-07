class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder("");
        int count;
        char c;
        c=s.charAt(0);
        count=1;
        sb.append(c);
        for(int i=1;i<s.length();i++){
            if(c==s.charAt(i)){
                count++;
            }
            else{
                count=1;
                c=s.charAt(i);
            }
            if(count<=2){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
