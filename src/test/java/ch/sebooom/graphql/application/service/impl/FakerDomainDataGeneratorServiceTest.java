package ch.sebooom.graphql.application.service.impl;

import ch.sebooom.graphql.domaine.Auteur;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class FakerDomainDataGeneratorServiceTest {

    @Test
    public void whenCreateRandomAuteur(){

        Auteur auteur = new FakerDomainDataGeneratorService().generateAuteur();

        System.out.println(auteur);
    }

}