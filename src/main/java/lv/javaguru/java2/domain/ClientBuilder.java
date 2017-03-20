package lv.javaguru.java2.domain;

/**
 * Created by ingsaf on 20/03/17.
 */

public class ClientBuilder {

    private String firstName;
    private String lastName;

    private ClientBuilder() { }

    public static ClientBuilder createClient() {
        return new ClientBuilder();
    }

    public Client build() {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return client;
    }

    public ClientBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
