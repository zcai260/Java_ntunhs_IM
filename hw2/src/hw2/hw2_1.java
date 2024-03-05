package hw2;

import java.util.Scanner;

public class hw2_1 {
	static String a1;//發燒
	static String a2;//咳嗽
	static String a3;//疲倦
	static String a4;//血壓升高
	static String a5;//口乾
	static String a6;//盜汗
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("歡迎使用醫療診斷系統,請依序輸入問題\n==========================");
		System.out.print("請問您最近是否發燒?(y/n):");
		a1=sc.nextLine();
		if(a1.equals("y")) {
			System.out.print("起問您最近是否咳嗽?(y/n):");
			a2=sc.nextLine();
			if(a2.equals("y")) {
				System.out.print("請問您最近是否感覺疲倦?(y/n):");
				a3=sc.nextLine();
				if(a3.equals("y")) {
					System.out.println("先生/小姐您可能得感冒!");
				}else {
					System.out.println("先生/小姐您可能得其他疾病!");
				}
			}else {
				System.out.print("請問您最近是否血壓升高?(y/n):");
				a4=sc.nextLine();
				if(a4.equals("y")) {
					System.out.print("請問您最近是否口乾?(y/n):");
					a5=sc.nextLine();
					if(a5.equals("y")) {
						System.out.println("先生/小姐您可能得肝病!");
					}else {
						System.out.println("先生/小姐您可能得其他疾病!");
					}
				}else {
					System.out.print("請問您最近是否盜汗?(y/n):");
					a6=sc.nextLine();
					if(a6.equals("y")) {
						System.out.println("先生/小姐您可能得肺病!");
					}else {
						System.out.println("先生/小姐您可能得其他疾病!");
					}
				}
			}
		}
		else{
			System.out.println("先生/小姐您可能很健康!");
		}
	}
}
