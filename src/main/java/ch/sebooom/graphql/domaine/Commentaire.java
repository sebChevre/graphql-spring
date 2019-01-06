package ch.sebooom.graphql.domaine;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@Entity
@Getter
@Setter
public class Commentaire {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "livre_id",
            nullable = false, updatable = false)
    private Livre livre;

    public Commentaire (Livre livre, String commentaire){
        this.livre = livre;
        this.commentaire = commentaire;
    }
}
