package ch.sebooom.graphql.application.web.api.rest;

import ch.sebooom.graphql.domaine.Auteur;
import ch.sebooom.graphql.infrastructure.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@RestController
public class AuteursQueryController {

    private AuteurRepository auteurRepository;

    @Autowired
    public AuteursQueryController(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    @GetMapping(value = "/auteurs")
    public List<Auteur> getAll(){

        List<Auteur> auteurs = new ArrayList<>();
        auteurRepository.findAll().forEach(auteurs::add);
        return auteurs;

    }

    @GetMapping(value = "/auteurs/{id}")
    public Auteur getById(@PathVariable("id")String id){

        return auteurRepository.findById(Long.valueOf(id)).get();

    }

}
