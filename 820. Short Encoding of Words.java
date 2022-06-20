import java.util.Map;
import java.util.HashMap;
class TrieNode{
    private Map<Character,TrieNode> nodeForChar;
    public TrieNode(){
        nodeForChar=new HashMap<>();
    }
    public Map<Character,TrieNode> getNodeForChar(){
        return nodeForChar;
    }
}
class Solution {
    private int wordCount,lengthSum;
    public int minimumLengthEncoding(String[] words) {
        TrieNode rootNode=new TrieNode();
        for(String word:words){
            insertInReverse(rootNode,word,word.length()-1);
        }
        computeWordCountAndLengthSum(rootNode,0);
        return wordCount+lengthSum;
    }
    private void insertInReverse(TrieNode root,String word,int index){
        if(index==-1){
            return;
        }
        Map<Character,TrieNode> nodeForChar=root.getNodeForChar();
        if(!nodeForChar.containsKey(word.charAt(index))){
            nodeForChar.put(word.charAt(index),new TrieNode());
        }
        TrieNode nextNode=nodeForChar.get(word.charAt(index));
        insertInReverse(nextNode,word,index-1);
    }
    private void computeWordCountAndLengthSum(TrieNode root,int wordLength){
        Map<Character,TrieNode> nodeForChar=root.getNodeForChar();
        if(nodeForChar.size()==0){
            wordCount++;
            lengthSum+=wordLength;
            return;
        }
        for(TrieNode nextNode:nodeForChar.values()){
            computeWordCountAndLengthSum(nextNode,wordLength+1);
        }
    }
}
