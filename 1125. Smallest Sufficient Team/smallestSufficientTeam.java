import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Hashtable<String,Integer> map = new Hashtable();
        for (int i = 0; i < req_skills.length; i++) map.put(req_skills[i], i);
        int[] peopleSkills = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            for (String skill: people.get(i)) {
                if (map.containsKey(skill)) {
                    peopleSkills[i] |= 1 << map.get(skill);
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList();
        Queue<boolean[]> peopleList = new LinkedList();
        boolean[] visited = new boolean[1 << req_skills.length];
        queue.add(0);
        visited[0] = true;
        peopleList.add(new boolean[people.size()]);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            boolean[] curPeople = peopleList.poll();
            for (int i = 0; i < peopleSkills.length; i++) {
                if (curPeople[i])   continue;
                int newState = cur | peopleSkills[i];
                boolean[] newPeople = new boolean[people.size()];
                for (int j = 0; j < people.size(); j++) newPeople[j] = curPeople[j];
                newPeople[i] = true;
                if (newState == (1 << req_skills.length) - 1) {
                    int count = 0;
                    for (int j = 0; j < people.size(); j++) 
                        if (newPeople[j])   count++;
                    int[] ans = new int[count];
                    count = 0;
                    for (int j = 0; j < people.size(); j++) 
                        if (newPeople[j]) ans[count++] = j;
                    return ans;
                }
                if (!visited[newState]) {
                    visited[newState] = true;
                    queue.add(newState);
                    peopleList.add(newPeople);
                }
            }
        }
        return new int[1];
    }
}
