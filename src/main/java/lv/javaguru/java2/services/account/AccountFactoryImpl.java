package lv.javaguru.java2.services.account;

import lv.javaguru.java2.database.jdbc.ClientDAOImpl;
import lv.javaguru.java2.domain.Account;
import lv.javaguru.java2.domain.Client;

import java.util.Optional;

import static lv.javaguru.java2.domain.AccountBuilder.createAccount;

/**
 * Created by ingsaf on 03/04/17.
 */
public class AccountFactoryImpl implements AccountFactory {
    private ClientDAOImpl clientDAO = new ClientDAOImpl();
    private AccountValidatorImpl accountValidator = new AccountValidatorImpl();

    @Override
    public Account create(Long clientId) {
        Optional<Client> clientOpt = clientDAO.getById(clientId);
        if (!clientOpt.isPresent()) {
            throw new IllegalArgumentException("Client not found by id = " + clientId);
        }

        accountValidator.validate("ZZZ", clientId, "N");

        Account account = createAccount().withAccountNumber("ZZZ").withSts("N").withIdClient(clientId).build();

        return account;
    }
}
