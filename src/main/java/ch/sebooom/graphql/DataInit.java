package ch.sebooom.graphql;

import ch.sebooom.graphql.application.service.DomainDataGeneratorService;
import ch.sebooom.graphql.domaine.Auteur;
import ch.sebooom.graphql.domaine.Livre;
import ch.sebooom.graphql.infrastructure.AuteurRepository;
import ch.sebooom.graphql.infrastructure.CommentaireRepository;
import ch.sebooom.graphql.infrastructure.LivreRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class DataInit {

    private final AuteurRepository auteurRepository;
    private final LivreRepository livreRepository;
    private final CommentaireRepository commentaireRepository;

    private final DomainDataGeneratorService domainDataGeneratorService;



    public DataInit(AuteurRepository auteurRepository,
                    LivreRepository livreRepository, CommentaireRepository commentaireRepository, DomainDataGeneratorService domainDataGeneratorService){
        this.livreRepository = livreRepository;
        this.auteurRepository = auteurRepository;
        this.commentaireRepository = commentaireRepository;
        this.domainDataGeneratorService = domainDataGeneratorService;
    }


    @PostConstruct
    public void initData(){

        List<Auteur> auteurs = initAuteursMap();

        IntStream.range(0,1000).forEach(livre -> {
            Livre newLivre = domainDataGeneratorService.generateRandomLivreWithoutAuteur();



            Auteur auteur = auteurs.get(new Random().nextInt(30));

            newLivre.setAuteur(auteur);

            livreRepository.save(newLivre);

            int randomCommentaires = new Random().nextInt(10);

            IntStream.range(0,randomCommentaires).forEach(compteur -> {
                commentaireRepository.save(
                        domainDataGeneratorService.generateRandomCommentaireForLivre(newLivre));
            });
        });



    }

    private List<Auteur> initAuteursMap() {

        return IntStream.range(0,30).asLongStream().mapToObj(compteur -> {
            return auteurRepository.save(domainDataGeneratorService.generateAuteur());
        }).collect(Collectors.toList());

    }


/**
    public static List<Livre> generateRandomLivre(int nbre){

        Faker faker = new Faker();

        if(nbre == 0){
            nbre = (int) (Math.random() * 10000);
        }

        IntStream.range(0,nbre).forEach((count) -> {

            Book fakeBook = faker.book();

            Livre livre = new Livre();
            livre.setNbrePages((int)(Math.random() * 1000));
            livre.setTitre(fakeBook.title());
            livre.setIsbn("1234567898765");
            livre.setAuteur(fakeBook.author());
            //livre.setIsbn();
        });


        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("fr-FR"), new RandomService());





        faker.book().title();
        return null;
    }

 */
}
