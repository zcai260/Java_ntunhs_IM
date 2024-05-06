import java.util.*;

public class hw9_1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int sum = 0, line=0;
        boolean isLoop=true;
        List<Integer> list =new ArrayList<>();
        while(isLoop) {
            line = input("請輸入數字,如果結束操作請輸入-1:");
            if (line==-1) isLoop=false;
            else {
                list.add(line);
            }
        }
        Collections.sort(list);
        for(int n:list) sum+=n;
        
        System.out.println("min: "+list.get(0)+" max:" 
        +list.get(list.size()-1)+" avg: "+sum/list.size());
    }
    static int input(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        return line;
    }
}