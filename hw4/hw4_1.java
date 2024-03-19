import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		String str1= new String();
		System.out.println("這是可以陪你聊程式!你可以問我一些問題");
		while(true){
		    System.out.print("你說:");
    		str1= sc.nextLine();
    		if(str1.equals("0")) {
    			System.out.println("離開聊天程式");
    			break;
    		}else{
    		    //System.out.print("我說:我會寫"+str1.substring(str1.indexOf("寫")+1,str1.indexOf("嗎")));
    		    str1=str1.replace("嗎?","!");
    		    str1=str1.replace("你會","我會");
    		    str1=str1.replace("能不能","能");
    		    str1=str1.replace("你能","我能");
    		    str1=str1.replace("會不會","會");
    		    str1=str1.replace("你","我");
    		    System.out.println("我說:"+str1);
    		    
    		}
		}
    }
}
