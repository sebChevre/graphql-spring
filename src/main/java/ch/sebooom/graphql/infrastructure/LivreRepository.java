package ch.sebooom.graphql.infrastructure;

import ch.sebooom.graphql.domaine.Livre;
import org.springframework.data.repository.CrudRepository;

public interface LivreRepository extends CrudRepository<Livre, Long> {
}
