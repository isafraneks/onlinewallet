package lv.javaguru.java2.services.account;

import lv.javaguru.java2.domain.Account;

/**
 * Created by ingsaf on 03/04/17.
 */
public interface AccountFactory {
    Account create(Long clientId);
}
