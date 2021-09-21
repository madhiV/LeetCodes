class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ll=new LinkedList<>();
        permutate(0,s,new StringBuilder(""),ll);
        return ll;
    }
    private void permutate(int index,String s,StringBuilder sb,List<String> ll){
        if(index==s.length()){
            ll.add(sb.toString());
            return;
        }
        char c=s.charAt(index);
        if(Character.isLetter(c)){
            //Lowercase
            if(c<97){
                c+=32;
            }
            sb.append((char)c);
            permutate(index+1,s,sb,ll);
            sb.setLength(sb.length()-1);
            
            //Uppercase
            c-=32;
            sb.append((char)c);
            permutate(index+1,s,sb,ll);
            sb.setLength(sb.length()-1);
        }
        else{
            sb.append(c);
            permutate(index+1,s,sb,ll);
            sb.setLength(sb.length()-1);
        }
    }
}
