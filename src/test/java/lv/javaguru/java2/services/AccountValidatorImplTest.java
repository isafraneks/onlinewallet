package lv.javaguru.java2.services;

import lv.javaguru.java2.services.account.AccountValidatorImpl;
import lv.javaguru.java2.services.account.AccountValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by ingsaf on 04/04/17.
 */
public class AccountValidatorImplTest {

    private AccountValidator validator = new AccountValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenClientIdNotExists() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Client id not exists!");
        validator.validate("A", new Long(999),"A");
    }

    @Test
    public void shouldThrowExceptionWhenStsWrong() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Sts is wrong!");
        validator.validate("A", new Long(1), "Z");
    }

    @Test
    public void shouldThrowExceptionWhenAccountNumberEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Account number must be not empty!");
        validator.validate("A", new Long(1), "Z");
    }


    // write more tests
}
