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

    @Override
    public Account create(Long clientId) {
        Optional<Client> clientOpt = clientDAO.getById(clientId);
        if (!clientOpt.isPresent()) {
            throw new IllegalArgumentException("Client not found by id = " + clientId);
        }

        Account account = createAccount().withAccountNumber("ZZZ").build();

        return account;
    }
}
