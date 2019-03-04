import java.util.Scanner;
public class Main {

    static void run(){
        System.out.println("请输入若干单词，以空格作为分隔");
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNext("#"))
        {
            System.out.println("键盘输入的内容是："

                    + sc.next());
        }
        System.out.println("执行吗");
    }

    public static void main(String[] args) {
//        run();

        Scanner scan = new Scanner(System.in);
        int[] num = new int[10];

        while (!scan.hasNext("#")){
            int index = Integer.parseInt(scan.next());
            if(0<=index && index<=9)
                num[index]++;
        }

        for(int i=1; i<10; i++){
            while (num[i]>0){
                System.out.print(i);
                num[i]--;
            }
        }
        while (0 != num[0]) {
            System.out.print(0);
            num[0]--;
        }

    }
}
