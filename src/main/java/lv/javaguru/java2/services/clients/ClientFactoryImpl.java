package lv.javaguru.java2.services.clients;

import lv.javaguru.java2.database.jdbc.ClientDAOImpl;
import lv.javaguru.java2.domain.Client;

import static lv.javaguru.java2.domain.ClientBuilder.createClient;

/**
 * Created by ingsaf on 01/04/17.
 */
public class ClientFactoryImpl implements ClientFactory {
    private ClientDAOImpl clientDAO = new ClientDAOImpl();

    @Override
    public Client create(String firstName, String lastName) {


        Client client = createClient().withFirstName(firstName).withLastName(lastName).build();

        return clientDAO.save(client);
    }
}
