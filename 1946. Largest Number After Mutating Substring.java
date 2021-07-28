class Solution {
    public String maximumNumber(String num, int[] change) {
        StringBuilder sb=new StringBuilder("");
        int i=0,temp;
        while(i<num.length()){
            temp=num.charAt(i)-48;
            if(temp<change[temp]){
                break;
            }
            sb.append(num.charAt(i));
            i++;
        }
        while(i<num.length()){
            temp=num.charAt(i)-48;
            if(temp>change[temp]){
                break;
            }
            sb.append(change[temp]);
            i++;
        }
        while(i<num.length()){
            sb.append(num.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
