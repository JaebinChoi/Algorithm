package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전교환 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/동전교환.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int coin = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int[] coins = new int[coin];
		int coinCnt = 0;

		for (int i = 0; i < coin; i++)
			coins[i] = Integer.parseInt(br.readLine());

		for (int i = coins.length - 1; i >= 0; i--) {
			coinCnt += money / coins[i];
			money %= coins[i];
		}
		
		System.out.println(coinCnt);

	}

}
