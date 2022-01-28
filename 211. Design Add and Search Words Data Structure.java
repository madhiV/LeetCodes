class TrieNode{
    char data;
    TrieNode[] children;
    boolean end=false;
    TrieNode(char data){
        this.data=data;
        children=new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root=null;
    public WordDictionary() {
        root=new TrieNode('-');
    }
    
    public void addWord(String word) {
        addWord(root,word,0);
    }
    
    public boolean search(String word) {
        return search(root,word,0);
    }
    public void addWord(TrieNode root,String word,int i){
        if(i==word.length()){
            root.end=true;
            return;
        }
        int temp=word.charAt(i);
        TrieNode[] p=root.children;
        temp-=97;
        if(p[temp]==null){
            p[temp]=new TrieNode(word.charAt(i));
        }
        addWord(p[temp],word,i+1);
    }
    public boolean search(TrieNode root,String word,int i){
        if(word.length()==i){
            return root.end;
        }
        int temp=word.charAt(i);
        TrieNode[] p=root.children;
        if(temp==46){
            for(int k=0;k<26;k++){
                if(p[k]!=null && search(p[k],word,i+1)){
                    return true;
                }
            }
            return false;
        }
        else{
            temp-=97;
            if(p[temp]==null){
                return false;
            }
            return search(p[temp],word,i+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
