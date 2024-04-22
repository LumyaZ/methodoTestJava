package org.example.productTest;


import org.example.model.Produit;
import org.example.service.ProduitService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

@DisplayName("Test de la classe ProduitService")
public class ProduitTest {

    private ProduitService produitService;

    @BeforeEach
    void init() {
        produitService = new ProduitService();
    }

    @Test
    @DisplayName("Creation de produit et incrementation")
    void testCreateProduitAndIncr() {
        Produit produit = produitService.ajouterProduit("chaise", 23);
        Produit produit1 = produitService.ajouterProduit("Table", 89);

        Assertions.assertAll("Vérification des propriétes des produist",
                () -> Assertions.assertEquals("chaise", produit.getName(), "Le nom de la chaise doit être correct"),
                () -> Assertions.assertEquals(23, produit.getPrice(), "le prix doit etre correct"),
                () -> Assertions.assertEquals(1, produit.getId(), "Id est egal 1"),
                () -> Assertions.assertEquals(2, produit1.getId(), "Id est egal 2"),
                () -> Assertions.assertTrue(produit.getId() > 0, "le produit doit avoir un id"),
                () -> Assertions.assertTrue(produit.getId() < produit1.getId()));
    }

    @Test
    @DisplayName("Creation de produit et incrementation")
    void testDeleteProduut() {
        Produit produit = produitService.ajouterProduit("Scooter", 2548.0);
        produitService.supprimeUnProduitParId(produit.getId());
        Assertions.assertThrows(ClassNotFoundException.class,
                ()-> produitService.trouverUnProduitParId(produit.getId()));

    }


    @Test
    @DisplayName("Trouver un produit par son id")
    void testTourverProduitParId(){
        Produit produit = produitService.ajouterProduit("Iphone",1458);
        Produit produit1 = produitService.ajouterProduit("IPad",1700);

        Assertions.assertAll("Varification de la recupéaration par Id",
                () -> Assertions.assertEquals(produit, produitService.trouverUnProduitParId(produit.getId()),"Je dois avoir un produit"),
                () -> Assertions.assertEquals(produit1, produitService.trouverUnProduitParId(produit1.getId()),"Je dois avoir un produit"),
                () -> Assertions.assertThrows(NoSuchElementException.class, ()-> produitService.trouverUnProduitParId(5L),""));
    }


    @Test
    @DisplayName("Trouver la liste des produits")
    void testTrouverListeProduits() {
    	Produit produit = produitService.ajouterProduit("Iphone",1458);
    	Produit produit1 = produitService.ajouterProduit("IPad",1700);
    	Produit produit2 = produitService.ajouterProduit("Samsung",800);
    	Produit produit3 = produitService.ajouterProduit("Huawei",1200);

    	List<Produit> listeProduits = produitService.listeProduits();
    	
    	Assertions.assertFalse(listeProduits.isEmpty(), "La liste des produits ne doit pas être vide");

	    for (Produit p : listeProduits) {
	    	Assertions.assertTrue(listeProduits.contains(p), "La liste des produits doit contenir " + p);
	    }
    }
    
    @Test
    @DisplayName("Vérification de l'update")
    void testUpdateProduit() {
    	Produit produit1 = produitService.ajouterProduit("Iphone",1458);
        Produit produit2 = new Produit("Huawei",500d);


        Assertions.assertAll("Update des produits",
                () -> Assertions.assertThrows(NoSuchElementException.class,
                () -> produitService.mettreAJourProduit(2L,"Huawei",500),"Produit mis à jour"),
                () -> Assertions.assertEquals(produit2, produitService.mettreAJourProduit(1L,"Huawei",500d))
                );
    }

}
