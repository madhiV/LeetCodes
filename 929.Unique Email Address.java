import java.util.*;
class Solution {
    public int numUniqueEmails(String[] emails) {
        int domainStart;
        char ch;
        boolean plusReached;
        StringBuilder sb;
        Set<String> set=new HashSet<>();
        for(int i=0;i<emails.length;i++){
            plusReached=false;
            domainStart=0;
            sb=new StringBuilder("");
            for(int j=0;j<emails[i].length();j++){
                ch=emails[i].charAt(j);
                if(ch=='@'){
                    domainStart=j;
                    break;
                }
                if(ch=='+'){
                    plusReached=true;
                }
                if(!plusReached && ch!='.'){
                    sb.append(ch);
                }
            }
            sb.append(emails[i].substring(domainStart,emails[i].length()));
            set.add(sb.toString());
        }
        return set.size();
    }
}
