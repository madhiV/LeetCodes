class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set=new HashSet<>();
        ArrayList<String> al=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j && isSub(words[i],words[j])){
                    set.add(words[i]);
                }
            }
        }
        for(String k:set){
            al.add(k);
        }
        return al;
    }
    public boolean isSub(String a,String b){
        int count,j;
        if(a.length()>b.length()){
            return false;
        }
        if(a.length()==0 && b.length()==0){
            return true;
        }
        for(int i=0;i<b.length()-a.length()+1;i++){
            count=0;
            j=i;
            while(b.charAt(j)==a.charAt(count)){
                j++;
                count++;
                if(count==a.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
