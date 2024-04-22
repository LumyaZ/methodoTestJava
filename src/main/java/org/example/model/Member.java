package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    private String nom;

    private boolean cotisationPayee;

    private int livresLusCeMois;


    public Member(String nom) {
        this.nom = nom;
        this.cotisationPayee = false;
        this.livresLusCeMois = 0;
    }

    public void payerCottisation(){
        this.cotisationPayee = true;
    }

    public void ajouterLivreLu(){
        this.livresLusCeMois +=1;
    }

    public boolean aPayeCotisation(){
     return  this.cotisationPayee;
    }

    public boolean aAtteintLeQuotaLivres(int quota){
        return this.livresLusCeMois >= quota;
    }


}
