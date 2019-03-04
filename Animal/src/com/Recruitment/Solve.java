package com.Recruitment;

public class Solve {
    public static void main(String[] args) {
//        show(new DeleteK(19));
//        show(new FindMajorityNums());
//        show(new LostNumber());
//        show(new MoveOtoTail());
//        show(new SingleNumber());

        show(new SearchMatrix(3));

    }

    private static void show(Question q){
        System.out.println("QUESTION------------------------------------------------------");
        System.out.println(q.description());
        System.out.println("INPUT---------------------------------------------------------");
        q.input();
        System.out.println("\nOUTPUT--------------------------------------------------------");
        q.resolve();
        System.out.println("\n--------------------------------------------------------------");
    }
}
