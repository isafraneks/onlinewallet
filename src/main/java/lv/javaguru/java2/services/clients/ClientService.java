package lv.javaguru.java2.services.clients;

/**
 * Created by ingsaf on 01/04/17.
 */
public interface ClientService {
    void edit(Long id, String firstName, String lastName);
    void activate(Long id);
    void deactivate(Long id);
}
