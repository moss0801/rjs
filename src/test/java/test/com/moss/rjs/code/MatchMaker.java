package test.com.moss.rjs.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchMaker {
   
    public class Member implements Comparable<Member> {
        public String name;
        public String gender;
        public String mate;
        public String[] answer;
        public int sf = 0;
        
        @Override
        public int compareTo(Member o) {
            if (this.sf > o.sf) {
                return -1;
            }
            else if (this.sf == o.sf) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    
    
  
    public String[] getBestMatches(String[] members, String currentUser, int sf) {
        int currentUserIndex = 0;
        int qCount = 0;
        List<Member> memberList = new ArrayList<Member>();
        for (String member : members) {
            String[] parts = member.split(" ");
            qCount = parts.length - 3;
            Member item = new Member();
            item.name = parts[0];
            
            if (currentUser.equals(item.name)) {
                currentUserIndex = memberList.size();
            }
            
            item.gender = parts[1];
            item.mate = parts[2];
            item.answer = new String[qCount];
            for (int i = 0; i < qCount; i++) {
                item.answer[i] = parts[parts.length - qCount + i];
            }
            memberList.add(item);
        }
        
        List<Member> result = new ArrayList<Member>();
        Member currentMember = memberList.get(currentUserIndex); 
        for (int i = 0; i < memberList.size(); i++) {
            if (i == currentUserIndex) {
                continue;
            }
            
            Member other = memberList.get(i);
            
            if (!currentMember.mate.equals(other.gender)
                    || !currentMember.gender.equals(other.mate)) {
                continue;
            }
            
            for (int j = 0; j < currentMember.answer.length; j++) {
                if (currentMember.answer[j].equals(other.answer[j])) {
                    other.sf++;
                }
            }
            
            if (other.sf >= sf) {
                result.add(other);
            }
        }
        
        Collections.sort(result);
        
        String[] fResult = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            fResult[i] = result.get(i).name;
        }
        return fResult;
    }
}
