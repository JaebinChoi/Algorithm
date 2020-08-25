import java.util.Stack;

class Solution_크레인인형뽑기게임 {
	static int N;
	static int cnt;
	static Stack<Integer>[] cols;
	static Stack<Integer> picks;
	
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        N = board.length;
        cnt = 0;
        
        picks = new Stack<>();
        cols = new Stack[N];
        for(int i = 0; i < N; i++)
        	cols[i] = new Stack<>();
        
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 0)
					cols[j].push(board[i][j]);
			}
		}
        pick(moves);

        answer = cnt;
        return answer;
    }
    
    private void pick(int[] moves) {
    	for(int idx : moves) {
    		// 뽑을 인형이 없을 경우
    		if(cols[idx - 1].empty()) continue;
    		
    		int	doll = cols[idx - 1].pop();
    		
    		// 바구니에 인형이 없을 경우
    		if(picks.empty()) picks.push(doll);
    		
    		// 바구니에 인형이 연속으로 같을 때
    		else if(picks.peek() == doll) {
    			picks.pop();
    			cnt += 2;
    		}
    		// 인형이 다를 때
    		else picks.add(doll);
    	}
	}

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},
						 {0,0,1,0,3},
						 {0,2,5,0,1},
						 {4,2,4,4,2},
						 {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(new Solution_크레인인형뽑기게임().solution(board, moves));
	}
}