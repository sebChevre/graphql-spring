package ch.sebooom.graphql.infrastructure;

import ch.sebooom.graphql.domaine.Auteur;
import org.springframework.data.repository.CrudRepository;

public interface AuteurRepository extends CrudRepository<Auteur, Long> {
}
