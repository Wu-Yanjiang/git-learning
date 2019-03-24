package cn.wyj.solution;

import java.util.Random;

public class StudentsSort {
    public static class Student {
        int num;
        int age;
        int height;
    }

    public static void sort(Student[] a) {
        Student tmp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (!compare(a[j], a[j + 1])) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
//                if (a[j].num > a[j + 1].num) {
//                    tmp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = tmp;
//                } else if (a[j].age > a[j + 1].age) {
//                    tmp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = tmp;
//                } else if (a[j].height > a[j + 1].height) {
//                    tmp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = tmp;
//                }
            }
        }
    }

    public static void main(String[] args) {
        int length = 20;
        int bound = 10;
        Student[] a = new Student[length];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            Student tmp = new Student();
            tmp.num = r.nextInt(bound);
            tmp.age = r.nextInt(bound);
            tmp.height = r.nextInt(bound);
            a[i] = tmp;
        }
        for (Student i : a) {
            System.out.println(" num:" + i.num + " age:" + i.age + " height:" + i.height);
        }
        System.out.println("------------------------------");
        sort(a);
        for (Student i : a) {
            System.out.println(" num:" + i.num + " age:" + i.age + " height:" + i.height);
        }
    }

    /**
     * 判断a是否应该排在b的前面
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean compare(Student a, Student b) {
        if (a.num < b.num)
            return true;
        else if (a.num > b.num)
            return false;
        else if (a.age < b.age)
            return true;
        else if (a.age > b.age)
            return false;
        else if (a.height < b.height)
            return true;
        else if (a.height > b.height)
            return false;
        else
            return true;
    }

/*

public void swap(Student a, Student b){
Student tmp;
tmp = a;
a = b;
b = tmp;
}
*/

}

