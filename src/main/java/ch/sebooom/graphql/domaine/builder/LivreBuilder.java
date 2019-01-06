package ch.sebooom.graphql.domaine.builder;

import ch.sebooom.graphql.domaine.Auteur;
import ch.sebooom.graphql.domaine.ISBN;
import ch.sebooom.graphql.domaine.Livre;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class LivreBuilder {


    private String titre;
    private ISBN isbn;
    private int nbrePages;
    private BigDecimal prix;
    private Auteur auteur;
    private int enStock;

    public LivreBuilder onlyBook(String titre, ISBN isbn, int nbrePages, int enStock, BigDecimal prix){
        this.titre = titre;
        this.isbn = isbn;
        this.nbrePages = nbrePages;
        this.prix = prix;
        this.prix.setScale(2, RoundingMode.CEILING);
        this.enStock = enStock;

        return this;
    }


    public LivreBuilder withAuteur(Auteur auteur){
       this.auteur = auteur;

       return this;
    }




    public Livre build(){

        return new Livre(titre,isbn,nbrePages,prix,enStock,auteur);

    }




}
