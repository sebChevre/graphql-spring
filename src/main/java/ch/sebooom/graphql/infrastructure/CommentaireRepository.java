package ch.sebooom.graphql.infrastructure;

import ch.sebooom.graphql.domaine.Commentaire;
import org.springframework.data.repository.CrudRepository;

public interface CommentaireRepository extends CrudRepository<Commentaire, Long> {
}
