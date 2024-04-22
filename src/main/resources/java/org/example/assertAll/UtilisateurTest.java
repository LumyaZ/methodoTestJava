package org.example.assertAll;

import org.example.model.Utilisateur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class UtilisateurTest {



    @Test
    void testAttributUtilisateur(){
        Utilisateur utilisateur = new Utilisateur("Jean",45);

        Assertions.assertAll("verification attributs utilisateur ",
                () -> Assertions.assertEquals("Jean", utilisateur.getNom(),
                        "Le nom de l'utilisateur doit être Jean"),
                () -> Assertions.assertEquals(45,utilisateur.getAge(),
                        "L'age de Jean doit être de 45"),
                () -> Assertions.assertNotEquals("", utilisateur.getNom(),
                        "l'attribut nom nedoit pas être vide")
                );
    }



}
