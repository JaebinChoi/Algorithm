import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2046_스탬프찍기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
			System.out.print("#");
	}
}
