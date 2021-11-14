class CombinationIterator {
    LinkedList<String> ll;
    int i;
    public CombinationIterator(String characters, int combinationLength) {
        i=0;
        ll=new LinkedList<>();
        addToLL(0,new StringBuilder(""),sort(characters),combinationLength);
    }
    
    public String next() {
        String ans=ll.get(i);
        i++;
        return ans;
    }
    
    public boolean hasNext() {
        if(i==ll.size()){
            return false;
        }
        return true;
    }
    public void addToLL(int index,StringBuilder sb,String word,int length){
        if(sb.length()==length){
            ll.add(sb.toString());
            return;
        }
        if(index==word.length()){
            return;
        }
        sb.append(word.charAt(index));
        addToLL(index+1,sb,word,length);
        sb.setLength(sb.length()-1);
        addToLL(index+1,sb,word,length);
    }
    public String sort(String word){
        int[] arr=new int[26];
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]==1){
                sb.append((char)(97+i));
            }
        }
        return sb.toString();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
