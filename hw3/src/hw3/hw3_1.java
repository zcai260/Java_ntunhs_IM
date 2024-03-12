package hw3;
import java.util.Scanner;
public class hw3_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int idx=0;
        System.out.print("請輸入陣列大小:");

        int num= sc.nextInt();
        int arr[]= new int[num];
    
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        idx=num-1;
        while (idx>=0) {
            System.out.printf("arr[%d]:%d\n",idx,arr[idx]);
            idx--;
        }
	}
}
