class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder("");
        int i=num1.length()-1,j=num2.length()-1,temp,carry=0;
        while(i!=-1 && j!=-1){
            temp=carry+num1.charAt(i)-48+num2.charAt(j)-48;
            sb.insert(0,temp%10);
            carry=temp/10;
            i--;
            j--;
        }
        while(i!=-1){
            temp=carry+num1.charAt(i)-48;
            sb.insert(0,temp%10);
            carry=temp/10;
            i--;
        }
        while(j!=-1){
            temp=carry+num2.charAt(j)-48;
            sb.insert(0,temp%10);
            j--;
            carry=temp/10;
        }
        if(carry!=0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }
}
