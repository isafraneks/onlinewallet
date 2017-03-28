package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.ClientDAO;
import lv.javaguru.java2.domain.Client;
import lv.javaguru.java2.domain.ClientBuilder;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by ingsaf on 23/03/17.
 */
public class ClientDAOImplTest extends DBUnitTestCase {

    private ClientDAO clientDAO = new ClientDAOImpl();

    @Override
    protected String getDatabaseFile() {
        return "dbscripts/ClientDAOImplTest.xml";
    }

    @Test
    public void testCreate() throws Exception {
        Client client = ClientBuilder.createClient()
                .withFirstName("Vasja")
                .withLastName("Pupkin").build();

        clientDAO.save(client);


        Optional<Client> clientFromDB = clientDAO.getById(client.getIdClient());
        assertTrue(clientFromDB.isPresent());
        assertEquals(client.getIdClient(), clientFromDB.get().getIdClient());
        assertEquals(client.getFirstName(), clientFromDB.get().getFirstName());
        assertEquals(client.getLastName(), clientFromDB.get().getLastName());

    }

}
