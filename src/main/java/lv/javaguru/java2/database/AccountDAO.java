package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Account;

import java.util.List;
import java.util.Optional;

/**
 * Created by ingsaf on 20/03/17.
 */
public interface AccountDAO {
    Account save(Account account);

    Optional<Account> getById(Long id);

    void delete(Long id);

    void update(Account account);

    List<Account> getAll();
}
