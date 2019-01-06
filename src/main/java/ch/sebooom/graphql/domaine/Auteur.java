package ch.sebooom.graphql.domaine;

import javax.persistence.*;

@Entity
@Table(name = "auteur")
public class Auteur {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String prenom;

    private String nom;

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    public Auteur() {
    }

    public Auteur(Long id) {
        this.id = id;
    }

    public Auteur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }


    public String getPrenom() {
        return prenom;
    }


    public String getNom() {
        return nom;
    }


}
