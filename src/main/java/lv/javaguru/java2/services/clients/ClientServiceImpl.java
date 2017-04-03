package lv.javaguru.java2.services.clients;

import lv.javaguru.java2.database.jdbc.ClientDAOImpl;
import lv.javaguru.java2.domain.Client;

import java.util.Optional;

/**
 * Created by ingsaf on 01/04/17.
 */
public class ClientServiceImpl implements ClientService {
    private ClientDAOImpl clientDAO = new ClientDAOImpl();

    @Override
    public void edit(Long id, String firstName, String lastName) {
        Optional<Client> clientOpt = clientDAO.getById(id);
        if (!clientOpt.isPresent()) {
            throw new IllegalArgumentException("Client not found by id = " + id);
        }

        Client client = clientOpt.get();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setSts("C");
        clientDAO.update(client);
    }

    @Override
    public void activate(Long id) {
        Optional<Client> clientOpt = clientDAO.getById(id);
        if (!clientOpt.isPresent()) {
            throw new IllegalArgumentException("Client not found by id = " + id);
        }

        Client client = clientOpt.get();
        client.setSts("A");
        clientDAO.update(client);
    }

    @Override
    public void deactivate(Long id) {
        Optional<Client> clientOpt = clientDAO.getById(id);
        if (!clientOpt.isPresent()) {
            throw new IllegalArgumentException("Client not found by id = " + id);
        }

        Client client = clientOpt.get();
        client.setSts("C");
        clientDAO.update(client);
    }
}
