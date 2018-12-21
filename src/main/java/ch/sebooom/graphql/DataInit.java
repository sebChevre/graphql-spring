package ch.sebooom.graphql;

import ch.sebooom.graphql.domaine.Auteur;
import ch.sebooom.graphql.domaine.Livre;
import ch.sebooom.graphql.infrastructure.AuteurRepository;
import ch.sebooom.graphql.infrastructure.LivreRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DataInit {

    private final AuteurRepository auteurRepository;
    private final LivreRepository livreRepository;



    public DataInit(AuteurRepository auteurRepository, LivreRepository livreRepository){
        this.livreRepository = livreRepository;
        this.auteurRepository = auteurRepository;
    }

    @PostConstruct
    public void initData(){

        Auteur un = new Auteur("Sébastien", "Chèvre");

        auteurRepository.save(un);

        un = new Auteur("Sébastien2", "Chèvre 2");

        auteurRepository.save(un);

        Livre deux = new Livre();
        deux.setNbrePages(100);
        deux.setIsbn("asdasdfsar ");
        deux.setAuteur(un);
        deux.setTitre("Quasimodo");

        livreRepository.save(deux);

    }
}
