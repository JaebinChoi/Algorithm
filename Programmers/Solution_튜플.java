package complete;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution_튜플 {
    public int[] solution(String s) {
    	ArrayList<int[]> list = new ArrayList<>();
    	
    	// 문자열 처리
        s = s.replaceAll("\\{", "").replaceAll("}", "");
        String[] number = s.split(",");
        Arrays.sort(number);
        
        int cnt = 0;
        String pre = number[0];
        for(String num : number) {
        	if(num.equals(pre)) cnt++; // 같은 숫자
        	else { // 다른 숫자
        		list.add(new int[] {Integer.parseInt(pre), cnt});
        		cnt = 1;
        		pre = num;
        	}
        }
        list.add(new int[] {Integer.parseInt(pre), cnt}); // 마지막 원소 처리
        
        // 정렬
        Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return -Integer.compare(o1[1], o2[1]);
			}
		});
        
        int[] answer = new int[list.size()];
        for(int i = 0, size = list.size(); i < size; i++)
        	answer[i] = list.get(i)[0];
        
        return answer;
    }
    public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
		new Solution_튜플().solution(s);
	}
}