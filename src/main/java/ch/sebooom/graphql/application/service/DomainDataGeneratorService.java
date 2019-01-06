package ch.sebooom.graphql.application.service;

import ch.sebooom.graphql.domaine.Auteur;
import ch.sebooom.graphql.domaine.Commentaire;
import ch.sebooom.graphql.domaine.Livre;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface DomainDataGeneratorService {
    Livre generateRandomLivreWithoutAuteur();

    Livre generateRandomLivreWithAuteur();

    Commentaire generateRandomCommentaireForLivre(Livre livre);

    Auteur generateAuteur();
}
