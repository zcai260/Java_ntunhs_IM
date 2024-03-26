package hw5;
import java.util.Scanner;
public class hw5 {

	public static void main(String[] args) {
		int money;
		var scanner= new Scanner(System.in);
		var card1 = new StoreValueCard("ntunhs",1000,0);
		boolean ab=true;
		while(ab) {
			System.out.print("請輸入以下指令:1.儲值 2.扣款 3.兌換紅利 4.查看明細 0.離開程式:");
			int option = scanner.nextInt();
			if(option==1) {
				System.out.print("請輸入儲值金額:");
				money = scanner.nextInt();
				card1.addValue(money);
			}else if(option==2) {
				System.out.print("請輸入扣款金額:");
				money = scanner.nextInt();
				card1.charge(money);
			}else if(option==3) {
				System.out.print("請輸入兌換紅利值:");
				money = scanner.nextInt();
				card1.exchangeBonus(money);
			}else if(option==4) {
				card1.printDetails();
			}else if(option==0) {
				System.out.println("離開系統");
				break;
			}else {
				System.out.println("輸入錯誤");
			}
			
		}
	}
}	
class StoreValueCard{
	private String cardId;
	private int balance;
	private int bonus;
    static int totalCardNum;
    StoreValueCard(){
    }
    StoreValueCard(String str,int a,int b){
    	cardId=str;
    	balance=a;
    	bonus=b;
    }
    void addValue(int money) {
    	if(money>0) {
    		balance+=money;
    		printDetails();
    		if(money>=1000) {
    			bonus+=1;
    		}
    	}else {
    		System.out.println("請確認儲值金額不可為零或負數");
    	}
    }
    void charge(int money) {
    	if(money>0) {
    		if(money<=balance) {
    			balance-=money;
    			printDetails();
    		}else {
    			System.out.println("餘額不足");
    		}
    	}else {
    		System.out.println("請確認儲值金額不可為零或負數");
    	}
    }
    void exchangeBonus(int a) {
    	if(a>0) {
    		if(a<=bonus) {
    			bonus-=a;
    			printDetails();
    		}else {
    			System.out.println("紅利不足");
    		}
    	}else {
    		System.out.println("請確認兌換紅利不可為零或負數");
    	}    	
    }
    void printDetails() {
    	System.out.printf("(%s,%d,%d)%n",cardId,balance,bonus);
    }
    int getbalance() {
    	return balance;
    }
    int getbonus() {
    	return bonus;
    }
    String getcardId() {
    	return cardId;
    }
}


