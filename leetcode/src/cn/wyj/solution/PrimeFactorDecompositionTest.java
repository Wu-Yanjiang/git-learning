package cn.wyj.solution;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class PrimeFactorDecompositionTest {

    @Test
    public void decomposition() {
//        Scanner s = new Scanner(System.in);
//        System.out.print("Please input a num:");
//        while (s.hasNext()){
//            System.out.println("Input num is :" + s.nextInt());
//        }
//        s.close();

        int bound = 2000;

        PrimeFactorDecomposition.decomposition(bound);
//        for (int i=2; i<=bound; i++){
//            System.out.print(i + " = ");
//            PrimeFactorDecomposition.decomposition(i);
//            System.out.println();
//        }
    }

    @Test
    public void prime(){
        int n = 20000;
        for (int i=n-19000; i<=n; i++)
            PrimeFactorDecomposition.Analyse(i);
    }
}