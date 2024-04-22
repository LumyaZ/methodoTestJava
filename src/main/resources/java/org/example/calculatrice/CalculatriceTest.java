package org.example.calculatrice;

import org.example.model.Calculatrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    private static Calculatrice calculatrice;

    @BeforeAll
    static void init(){
       calculatrice =new Calculatrice();
    }

    @Test
    void testAddition(){
        // Act
        double res = calculatrice.addition(10,15);
        //Assert
        Assertions.assertEquals(25,res);
    }

    @Test
    void testDivision(){
        // Act
        double res = calculatrice.division(30,2);
        //Assert
        Assertions.assertEquals(15,res);
    }


    @Test
    void testDivision1(){
        // Act + Assert
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            // Act
            calculatrice.division(10,0);
        });

    }


}
