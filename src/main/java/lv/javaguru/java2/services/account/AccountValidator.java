package lv.javaguru.java2.services.account;

/**
 * Created by ingsaf on 04/04/17.
 */
public interface AccountValidator {
    void validate(String AccountNumber, Long idClient, String Sts);
}
