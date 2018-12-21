package ch.sebooom.graphql.application;


import ch.sebooom.graphql.domaine.Auteur;
import ch.sebooom.graphql.infrastructure.AuteurRepository;
import ch.sebooom.graphql.domaine.Livre;
import ch.sebooom.graphql.infrastructure.LivreRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class MutationResolver implements GraphQLMutationResolver{

    private AuteurRepository auteurRepository;
    private LivreRepository livreRepository;

    @Autowired
    public MutationResolver(AuteurRepository auteurRepository, LivreRepository livreRepository){
        this.auteurRepository = auteurRepository;
        this.livreRepository = livreRepository;
    }

    public Auteur newAuteur(String prenom, String nom){
        Auteur auteur = new Auteur();
        auteur.setNom(nom);
        auteur.setPrenom(prenom);

        auteurRepository.save(auteur);

        return auteur;
    }

    public Livre newLivre(String titre, String isbn, Integer nbrePages, Long auteurId){
        Livre livre = new Livre();
        livre.setAuteur(new Auteur(auteurId));
        livre.setIsbn(isbn);
        livre.setNbrePages(nbrePages);

        livreRepository.save(livre);

        return livre;
    }

    public boolean deleteLivre(Long id) {
        livreRepository.deleteById(id);
        return true;
    }

    public Livre updateLivrePageCount(Integer pageCount, Long id) {
        Livre book = livreRepository.findById(id).get();
        book.setNbrePages(pageCount);

        livreRepository.save(book);

        return book;
    }

}
