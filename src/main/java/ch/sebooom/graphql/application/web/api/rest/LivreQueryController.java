package ch.sebooom.graphql.application.web.api.rest;

import ch.sebooom.graphql.domaine.Livre;
import ch.sebooom.graphql.infrastructure.AuteurRepository;
import ch.sebooom.graphql.infrastructure.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@RestController
public class LivreQueryController {

    private LivreRepository livreRepository;

    private AuteurRepository auteurRepository;

    @Autowired
    public LivreQueryController(LivreRepository livreRepository, AuteurRepository auteurRepository) {
        this.livreRepository = livreRepository;
        this.auteurRepository = auteurRepository;
    }

    @RequestMapping(value = "/livres")
    public List<Livre> getAll(){

        List<Livre> livres = new ArrayList<>();
        livreRepository.findAll().forEach(livres::add);
        return livres;

    }

    @RequestMapping(value = "/livres/{id}")
    public Livre getById(@PathVariable("id")String id){

        return livreRepository.findById(Long.valueOf(id)).get();

    }
}
