package ch.sebooom.graphql.domaine;

import javax.persistence.*;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String titre;

    private String isbn;

    private int nbrePages;

    @ManyToOne
    @JoinColumn(name = "auteur_id",
            nullable = false, updatable = false)
    private Auteur auteur;

    public Livre() {
    }

    public Livre(String titre, String isbn, int nbrePages, Auteur auteur) {
        this.titre = titre;
        this.isbn = isbn;
        this.nbrePages = nbrePages;
        this.auteur = auteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNbrePages() {
        return nbrePages;
    }

    public void setNbrePages(int nbrePages) {
        this.nbrePages = nbrePages;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

}
