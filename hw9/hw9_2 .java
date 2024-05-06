import java.util.Scanner;
import java.util.*;
import java.util.HashSet;
import java.util.Set;
public class hw9_2{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int sum = 0;
        String line;
        boolean isLoop=true;
        Set<String> set =new HashSet<>();
        
        while(isLoop) {
            line = input("請輸入手機號碼,如果結束操作請輸入0:");
            if (line.equals("0")) isLoop=false;
            else {
                set.add(line);
            }
        }
        System.out.println("您輸入的手機號碼數量有:"+set.size()); 
        System.out.println(set);
	}
    static String input(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }
}
