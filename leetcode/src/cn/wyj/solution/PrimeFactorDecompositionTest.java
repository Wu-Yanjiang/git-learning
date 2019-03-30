package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeFactorDecompositionTest {

    @Test
    public void decomposition() {
        int bound = 2000;
        for (int i=2; i<=bound; i++){
            System.out.print(i + " = ");
            PrimeFactorDecomposition.decomposition(i);
            System.out.println();
        }
    }
}