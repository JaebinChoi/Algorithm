class Solution_스킬트리 {
	static int prev, next;
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        for(String skillTree : skill_trees) {
        	// 첫번째 글자가 포함된 위치 index
        	prev = skillTree.indexOf(skill.charAt(0));

        	for(int i = 1, size = skill.length(); i < size; i++) {
        		// 다음 글자가 포함된 위치 index
        		next = skillTree.indexOf(skill.charAt(i));
        		
        		// 다음 글자가 있고, 순서가 다를 경우 또는 이전 글자가 없는데 다음 글자가 있는 경우
        		if(prev > next && next > -1 || (prev == -1 && next > -1)) {
        			answer--;
        			break;
        		}
        		prev = next;
        	}
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	String skill = "CBD";
    	String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
    	System.out.println(new Solution_스킬트리().solution(skill, skill_trees));
	}
}