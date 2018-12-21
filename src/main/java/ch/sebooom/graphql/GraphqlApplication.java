package ch.sebooom.graphql;

import ch.sebooom.graphql.application.MutationResolver;
import ch.sebooom.graphql.application.QueryResolver;
import ch.sebooom.graphql.infrastructure.AuteurRepository;
import ch.sebooom.graphql.infrastructure.LivreRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public QueryResolver authorResolver(AuteurRepository auteurRepository, LivreRepository livreRepository) {
		return new QueryResolver(auteurRepository,livreRepository);
	}

	@Bean
	public MutationResolver mutationResolver(AuteurRepository auteurRepository, LivreRepository livreRepository) {
		return new MutationResolver(auteurRepository, livreRepository);
	}
}

