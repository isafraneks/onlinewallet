package lv.javaguru.java2.services.clients;

import lv.javaguru.java2.domain.Client;

/**
 * Created by ingsaf on 31/03/17.
 */
public interface ClientFactory {
    Client create(String firstName, String lastName);
}
