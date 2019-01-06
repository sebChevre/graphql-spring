package ch.sebooom.graphql.domaine;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titre;


    @AttributeOverride(name="numero",
            column=@Column(name="isbn"))
    @Embedded
    private ISBN isbn;

    private int nbrePages;

    private int enStock;

    private BigDecimal prix;

    @ManyToOne
    @JoinColumn(name = "auteur_id",
            nullable = false, updatable = false)
    private Auteur auteur;

    public Livre() {
    }

    public Livre(Long id) {
        this.id = id;
    }

    public BigDecimal getPrix() {
        return prix;
    }


    public Livre(String titre, ISBN isbn, int nbrePages, BigDecimal prix, int enStock, Auteur auteur) {
        this.titre = titre;
        this.isbn = isbn;
        this.nbrePages = nbrePages;
        this.auteur = auteur;
        this.prix = prix;
        this.enStock = enStock;
    }

    public Long getId() {
        return id;
    }


    public String getTitre() {
        return titre;
    }


    public ISBN getIsbn() {
        return isbn;
    }


    public int getNbrePages() {
        return nbrePages;
    }


    public Auteur getAuteur() {
        return auteur;
    }


    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
}
