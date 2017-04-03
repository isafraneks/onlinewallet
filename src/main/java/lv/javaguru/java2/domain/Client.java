package lv.javaguru.java2.domain;

/**
 * Created by ingsaf on 20/03/17.
 */
public class Client {
    private long idClient;
    private String firstName;
    private String lastName;
    private String sts;


    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSts() { return sts; }

    public void setSts(String sts) {
        this.sts = sts;
    }
}
