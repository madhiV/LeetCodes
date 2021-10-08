class Node{
    private char data;
    private Node[] children;
    private boolean end;
    Node(char data){
        this.data=data;
        end=false;
        children=new Node[26];
    }
    public char getData(){
        return data;
    }
    public Node[] getChildren(){
        return children;
    }
    public boolean isEnd(){
        return end;
    }
    public void setEnd(boolean flag){
        end=flag;
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node(' ');
    }
    
    public void insert(String word) {
        insert(root,word,0);
    }
    
    public boolean search(String word) {
        return search(root,word,0);
    }
    
    public boolean startsWith(String prefix) {
        return isPrefix(root,prefix,0);
    }
    public void insert(Node root,String word,int index){
        if(index==word.length()){
            root.setEnd(true);
            return;
        }
        Node[] k=root.getChildren();
        char c=word.charAt(index);
        int temp=c-'a';
        if(k[temp]==null){
            k[temp]=new Node(c);
        }
        insert(k[temp],word,index+1);
    }
    public boolean search(Node root,String word,int index){
        if(index==word.length()){
            return root.isEnd();
        }
        Node[] k=root.getChildren();
        char c=word.charAt(index);
        int temp=c-'a';
        if(k[temp]==null){
            return false;
        }
        return search(k[temp],word,index+1);
    }
    public boolean isPrefix(Node root,String word,int index){
        if(index==word.length()){
            return true;
        }
        Node[] k=root.getChildren();
        char c=word.charAt(index);
        int temp=c-'a';
        if(k[temp]==null){
            return false;
        }
        return isPrefix(k[temp],word,index+1);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
