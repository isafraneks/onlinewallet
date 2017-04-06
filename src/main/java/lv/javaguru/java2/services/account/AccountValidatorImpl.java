package lv.javaguru.java2.services.account;

import lv.javaguru.java2.database.jdbc.ClientDAOImpl;

/**
 * Created by ingsaf on 04/04/17.
 */
public class AccountValidatorImpl implements AccountValidator {
    private static ClientDAOImpl clientDAO = new ClientDAOImpl();

    @Override
    public void validate(String AccountNumber, Long idClient, String Sts) {
        validateAccountNumber(AccountNumber);
        validateIdClient(idClient);
        validateSts(Sts);
    }

    public void validateAccountNumber(String AccountNumber) {
        if (AccountNumber == null || AccountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account Number must be not empty!");
        }
    }

    public void validateIdClient(Long idClient) {
        if (!clientDAO.getById(idClient).isPresent()) {
            throw new IllegalArgumentException("Client with such Id does not exists!");
        }
    }

    public void validateSts(String sts) {
        if (sts != "A" && sts != "C") {
            throw new IllegalArgumentException("Wrong account sts!");
        }
    }
}
