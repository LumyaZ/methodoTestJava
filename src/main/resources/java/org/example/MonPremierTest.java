package org.example;

import org.example.model.Utilisateur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MonPremierTest {

    @Test
    @DisplayName("test sur l'egalite")
    void testEgalite(){
        assertEquals(4,2+2,"2 + 2 doit egal 4");
    }

    @Test
    @DisplayName("test sur la non egalite")
    void testNonEgalite(){
        assertNotEquals(4,2+3,"2 + 3 ne doit pas être egal 4");
    }

    @Test
    @DisplayName("test est ce vrai")
    void testVrai(){
        assertTrue(2+3==5,"2 + 3 doit être egal 5");
    }

    @Test
    @DisplayName("test est ce faux")
    void testFaux(){

        assertFalse(2+2==5,"2 + 2 ne doit pas être egal 5");
    }

    @Test
    void testNull(){
        Object o = null;
        assertNull(o,"object doit être null");
    }
    @Test
    void testNotNull(){
        Object o = new Object();
        assertNotNull(o,"object ne doit pas être null");
    }

    @Test
    void testException(){
        assertThrows(IllegalArgumentException.class,()-> {
            throw new IllegalArgumentException();
        }, "Une IllegalArgumentException doit être levée"
        );
    }

    @Test
    void testMultiple(){
        assertAll("plusieurs test",
                () -> assertEquals(4, 2+2, "2 + 2 doit egal 4"),
                () -> assertTrue(3+3==6, "3 + 3 doit être egal à 6")

                );
    }



}
