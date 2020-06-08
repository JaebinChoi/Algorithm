import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static int R, C, result;
	static char[][] map;
	static Set<Character> set = new HashSet<>();
	static int[][] dir = {{-1, 0}, {1, 0}, {0 ,-1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		set.add(map[0][0]);
		dfs(0, 0, 1);
		
		System.out.println(result);
	}

	private static void dfs(int r, int c, int cnt) {
		result = result > cnt ? result : cnt;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(!isIn(nr, nc) || set.contains(map[nr][nc]))
				continue;
			
			set.add(map[nr][nc]);
			dfs(nr, nc, cnt + 1);
			set.remove(map[nr][nc]);
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
}
