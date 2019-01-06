package ch.sebooom.graphql.application.service.impl;

import ch.sebooom.graphql.application.service.DomainDataGeneratorService;
import ch.sebooom.graphql.domaine.Auteur;
import ch.sebooom.graphql.domaine.Commentaire;
import ch.sebooom.graphql.domaine.ISBN;
import ch.sebooom.graphql.domaine.Livre;
import ch.sebooom.graphql.domaine.builder.LivreBuilder;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@Service
public class FakerDomainDataGeneratorService implements DomainDataGeneratorService {

    Faker faker = new Faker();

    private ISBN generateRandomISBN(){

        long numero = ThreadLocalRandom.current().nextLong(1000000000000L, 9999999999999L);

        return new ISBN(numero);
    }

    @Override
    public Livre generateRandomLivreWithoutAuteur(){

        Book book = faker.book();
        ISBN isbn = generateRandomISBN();
        int nbrePage = new Random().nextInt(900) + 50;
        BigDecimal prix = generateRandomPrix();
        int stock = new Random().nextInt(15);

        return new LivreBuilder().onlyBook(book.title(),isbn,nbrePage,stock,prix).build();
    }

    @Override
    public Livre generateRandomLivreWithAuteur(){

        Book book = faker.book();
        ISBN isbn = generateRandomISBN();
        int nbrePage = new Random().nextInt(900) + 50;
        BigDecimal prix = generateRandomPrix();
        int stock = new Random().nextInt(15);


        return new LivreBuilder().onlyBook(book.title(),isbn,nbrePage,stock,prix).withAuteur(generateAuteur()).build();
    }

    @Override
    public Commentaire generateRandomCommentaireForLivre(Livre livre){

        String commentaire = faker.lorem().sentence(20);

        return new Commentaire(livre,commentaire);
    }
    @Override
    public Auteur generateAuteur(){
        Book book = faker.book();

        return new Auteur(book.author().split(" ")[0],book.author().split(" ")[1]);
    }

    private BigDecimal generateRandomPrix() {
        return new BigDecimal(
                new Random()
                        .doubles(5.00,99.99)
                        .findFirst()
                        .getAsDouble()
        );

    }


}
