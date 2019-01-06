package ch.sebooom.graphql.application;

import ch.sebooom.graphql.domaine.Auteur;
import ch.sebooom.graphql.infrastructure.AuteurRepository;
import ch.sebooom.graphql.domaine.Livre;
import ch.sebooom.graphql.infrastructure.LivreRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class QueryResolver implements GraphQLQueryResolver {

    private AuteurRepository auteurRepository;
    private LivreRepository livreRepository;

    @Autowired
    public QueryResolver(AuteurRepository auteurRepository, LivreRepository livreRepository){
        this.auteurRepository = auteurRepository;
        this.livreRepository = livreRepository;
    }

    public List<Auteur> findAllAuteurs(String nom){

        List<Auteur> target = new ArrayList<>();
        auteurRepository.findAll().forEach(target::add);
        return target;
    }

    public Auteur auteur(Long id){


        return auteurRepository.findById(id).get();

    }

    public long countAuteurs(){
        return auteurRepository.count();
    }

    public List<Livre> findAllLivres(){

        List<Livre> target = new ArrayList<>();
        livreRepository.findAll().forEach(target::add);
        return target;
    }

    public long countLivres(){
        return livreRepository.count();
    }
}
