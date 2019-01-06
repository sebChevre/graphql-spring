package ch.sebooom.graphql.domaine;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class ISBNTest {

    @Test
    public void whenCreateInstanceThenFieldNumeroIsSet(){
        long noIsbn = 1234567891234L;
        ISBN isbn = new ISBN(noIsbn);
        assertNotNull(isbn.numero());
        assertEquals(isbn.numero(),Long.toString(noIsbn));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInstanceCreatedFieldNumeroSizeIsotEqualTo13ElseIllegalArgumentExceptionIsThrown(){
        int noIsbn = 12345677;
        ISBN isbn = new ISBN(noIsbn);
    }

    @Test
    public void whenTowInstnceWithSameNumerbThenThyMusstBeEquals(){
        long noIsbn = 1234567891234L;
        ISBN isbn = new ISBN(noIsbn);
        ISBN isbn2 = new ISBN(noIsbn);

        assertEquals(isbn,isbn2);
    }

    @Test
    public void whenTowInstnceWithDifferentNumerbThenThyMusstBeDifferent(){
        long noIsbn = 1234567891234L;
        long noIsbn2 = 1234567811234L;
        ISBN isbn = new ISBN(noIsbn);
        ISBN isbn2 = new ISBN(noIsbn2);

        assertNotEquals(isbn,isbn2);
    }



}