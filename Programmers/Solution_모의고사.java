package complete;
import java.util.Arrays;

public class Solution_모의고사 {
	public class Person implements Comparable<Person> {
		int index;
		int answer;
		int cnt;
		int[] pattern;
		
		public Person() {}

		public Person(int index, int[] pattern) {
			this.index = index;
			this.pattern = pattern;
		}

		@Override
		public int compareTo(Person o) {
			return o.cnt - this.cnt;
		}

		@Override
		public String toString() {
			return "Person [index=" + index + ", cnt=" + cnt + "]";
		}
	}
	
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        Person[] persons = {new Person(1, new int[] { 1, 2, 3, 4, 5 }),
        					new Person(2, new int[] { 1, 3, 4, 5 }),
        					new Person(3, new int[] { 3, 1, 2, 4, 5 })};
		persons[1].answer = 2;
		
        for(int i = 0, size = answers.length; i < size; i++) {
        	// 수포자 1
        	persons[0].answer = persons[0].pattern[i % 5]; // 1, 2, 3, 4, 5
        	if(persons[0].answer == answers[i]) persons[0].cnt++;
        	
        	// 수포자 2
        	if(i % 2 == 0) persons[1].answer = 2;
    		else persons[1].answer = persons[1].pattern[(i - 1) / 2 % 4]; // 1, 3, 4, 5
        	if(persons[1].answer == answers[i]) persons[1].cnt++;
        	
        	// 수포자 3
        	if(i % 2 == 0) persons[2].answer = persons[2].pattern[i / 2 % 5]; // 3, 1, 2, 4, 5
        	if(persons[2].answer == answers[i]) persons[2].cnt++;
        }
        
        Arrays.sort(persons);
        
        int idx = 1;
        for(int i = 1, size = persons.length; i < size; i++)
        	if(persons[0].cnt == persons[i].cnt) idx++;
        
        answer = new int[idx];
        for(int i = 0; i < idx; i++) {
        	answer[i] = persons[i].index;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(new Solution_모의고사().solution(answers)));
	}
}
