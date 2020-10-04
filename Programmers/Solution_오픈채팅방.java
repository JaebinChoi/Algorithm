import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution_오픈채팅방 {
	static LinkedList<Record> records = new LinkedList<>();
	static Map<String, String> user = new HashMap<String, String>();

	public class User {
		String id;
		String nickname;

		public User(String id, String nickname) {
			this.id = id;
			this.nickname = nickname;
		}
	}

	public class Record {
		String id;
		String state;

		public Record(String id, String state) {
			this.id = id;
			this.state = state;
		}
	}

	public String[] solution(String[] record) {
		for (String rec : record) {
			String[] tmp = rec.split(" ");
			String state = tmp[0];
			String id = tmp[1];
			String nickname = state.equals("Leave") ? null : tmp[2];

			if (state.equals("Enter")) {
				user.put(id, nickname);
				records.offer(new Record(id, state));
			} else if (state.equals("Change")) user.put(id, nickname);
			else records.offer(new Record(id, state));
		}

		String[] answer = new String[records.size()];
		int idx = 0;
		
		// 메시지 출력
		for(Record r : records) {
			String str = "";
			
			if(r.state.equals("Enter")) str += user.get(r.id) + "님이 들어왔습니다.";
			else str += user.get(r.id) + "님이 나갔습니다.";
			
			answer[idx++] = str;
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		new Solution_오픈채팅방().solution(record);
	}
}