package jungol;

import java.util.Scanner;

public class Main533 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String a = s.next();
		int age = s.nextInt();
		
		if(a.equals("M") && age >= 18)
			System.out.println("MAN");
		else if(a.equals("M") && age < 18)
			System.out.println("BOY");
		else if(a.equals("F") && age >= 18)
			System.out.println("WOMAN");
		else
			System.out.println("GIRL");
		

	}

}
