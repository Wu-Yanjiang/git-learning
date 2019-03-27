package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeFactorDecompositionTest {

    @Test
    public void decomposition() {
        for (int i=2; i<=2000; i++){
            System.out.print(i + " = ");
            PrimeFactorDecomposition.decomposition(i);
            System.out.println();
        }
    }
}