package org.example.service;

import org.example.model.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProduitService {

    private List<Produit> liste = new ArrayList<>();

    public Produit ajouterProduit(String nom, double prix){
        Produit produit = new Produit(nom, prix);
        liste.add(produit);
        return produit;
    }
    public Produit trouverUnProduitParId(Long id){

        return liste.stream()
                .filter(produit -> produit.getId() == id)
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Produit avec Id: " + id + "n'existe pas"));
    }
    
    public Produit mettreAJourProduit(Long id, String nom, double prix){
    	Produit produit = trouverUnProduitParId(id);

        produit.setName(nom);
        produit.setPrice(prix);

        return produit;
    }
    
    public void supprimeUnProduitParId(Long id){
        liste.removeIf(produit -> produit.getId() == id);
    }

    public List<Produit> listeProduits(){
        return liste;
    }


}
