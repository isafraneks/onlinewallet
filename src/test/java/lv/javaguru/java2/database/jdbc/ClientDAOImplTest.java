package lv.javaguru.java2.database.jdbc;

import org.junit.Test;

/**
 * Created by ingsaf on 23/03/17.
 */
public class ClientDAOImplTest extends DBUnitTestCase {

   // private ClientDAO clientDAO = new ClientDAOImpl();

    @Override
    protected String getDatabaseFile() {
        return "dbscripts/ClientDAOImplTest.xml";
    }

    @Test
    public void testCreate() throws Exception {
        /*
        System.out.print("zzz");

        Client client = createClient()
                .withFirstName("Vasja")
                .withLastName("Pupkin").build();

        clientDAO.save(client);
        */
/*
        Optional<Client> userFromDB = clientDAO.getById(client.getIdClient());
        assertTrue(userFromDB.isPresent());
        assertEquals(client.getIdClient(), userFromDB.get().getIdClient());
        assertEquals(client.getFirstName(), userFromDB.get().getFirstName());
        assertEquals(client.getLastName(), userFromDB.get().getLastName());
        */
    }

}
