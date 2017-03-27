package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Client;

import java.util.List;
import java.util.Optional;

/**
 * Created by ingsaf on 20/03/17.
 */
public interface ClientDAO {
    Client save(Client client);

    Optional<Client> getById(Long id);

    void delete(Long id);

    void update(Client client);

    List<Client> getAll();
}
