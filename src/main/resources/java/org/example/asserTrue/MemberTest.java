package org.example.asserTrue;

import org.example.model.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    void testAPayeCotisation(){
        Member member = new Member("Mathys");
        member.payerCottisation();
        Assertions.assertTrue(member.aPayeCotisation(),"Le membre doit avoir apyé");
    }


    @Test
    void membreAtteintQuota(){
        Member member = new Member("bobby");
        for (int i=0;i<5; i++) {
            member.ajouterLivreLu();
        }
        Assertions.assertTrue(member.aAtteintLeQuotaLivres(5),"Le membre doit avoir atteint son quota du mois");
    }


}
