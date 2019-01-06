package ch.sebooom.graphql.domaine;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@Embeddable
public class ISBN {

    private String numero;

    ISBN(){}

    public ISBN(long numero){

        checkCoherenceNumero(numero);

        this.numero = String.valueOf(numero);
    }

    private void checkCoherenceNumero(long no) {
        String numero = Long.toString(no);

        if(numero.length() != 13){
            throw new IllegalArgumentException("Max numer of digit is 13");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ISBN)) return false;

        ISBN isbn = (ISBN) o;

        return new EqualsBuilder()
                .append(numero, isbn.numero)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(numero)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ISBN{" +
                "numero='" + numero + '\'' +
                '}';
    }

    public String numero() {
        return numero;
    }
}
