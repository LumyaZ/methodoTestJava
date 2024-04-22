package org.example.assertArrayEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExempleTest {

    @Test
    void testEgaliteTabEntier(){
        int[] tab1 = {1,5,7,9};
        int[] tab2 = {1,5,7,9};
        assertArrayEquals(tab1, tab2,"Les tableaux doivent être egaux");

    }

    @Test
    void testEgaliteTabDoubleAvecTolerance(){
        double[] tab1 = {1.0,2.1,7.9,9.9};
        double[] tab2 = {1.0,2.1,7.9,10};
        assertArrayEquals(tab1, tab2,0.1,"Les tableaux doivent être egaux");

    }



}
