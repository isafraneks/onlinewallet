package lv.javaguru.java2.domain;

/**
 * Created by ingsaf on 27/03/17.
 */
public class AccountBuilder {

    private String accountNumber;
    private long idClient;
    private String sts;

    private AccountBuilder() { }

    public static AccountBuilder createClient() {
        return new AccountBuilder();
    }

    public Account build() {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setIdClient(idClient);
        account.setSts(sts);
        account.setBalance(0.0);

        return account;
    }

    public AccountBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountBuilder withIdClient(long idClient) {
        this.idClient = idClient;
        return this;
    }

    public AccountBuilder withSts(String sts) {
        this.sts = sts;
        return this;
    }

}
