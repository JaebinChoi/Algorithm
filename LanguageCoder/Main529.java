package jungol;

import java.util.Scanner;

public class Main529 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int height = s.nextInt();
		int weight = s.nextInt();
		
		int result = weight + 100 - height;
		
		System.out.println(result);
		
		if(result > 0)
			System.out.println("Obesity");

	}

}
