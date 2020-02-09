package jungol;

import java.util.Scanner;

public class Main121 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		
		if(num == 0)
			System.out.println("zero");
		else if(num > 0)
			System.out.println("plus");
		else
			System.out.println("minus");
		

	}

}
