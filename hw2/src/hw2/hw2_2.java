package hw2;

import java.util.Scanner;
import java.util.Random;

public class hw2_2 {

	public static void main(String[] args) {
		Random rand= new Random();
		int ans=rand.nextInt(100);
		int guess=0;
		int min=0;
		int max=100;
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("請輸入一個數字("+min+"~"+max+"):");
			guess=sc.nextInt();
			if(guess>ans) {
				max=guess;
			}else if(guess<ans) {
				min=guess;
			}else{
				System.out.println("你猜對了");
				break;
			}
		}
	}

}
