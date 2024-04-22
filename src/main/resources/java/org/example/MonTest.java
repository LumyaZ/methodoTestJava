package org.example;

import org.junit.jupiter.api.*;

public class MonTest {


    @BeforeAll
   static void initAll(){
        System.out.println("beforAll");
    }

    @BeforeEach
    void init(){
        System.out.println("beforeEach");
    }

    @AfterEach
    void end(){
        System.out.println("afterEach");
    }

    @AfterAll
   static void endAll(){
        System.out.println("afterAll");
    }

    @Test
    @DisplayName("Simple test 1")
    void simpleTest(){
        System.out.println("Simple test");
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Simple test 2")
    void simpleTest2(){
        System.out.println("Simple test 2");
        Assertions.assertTrue(true, "toujours true");
    }



}
