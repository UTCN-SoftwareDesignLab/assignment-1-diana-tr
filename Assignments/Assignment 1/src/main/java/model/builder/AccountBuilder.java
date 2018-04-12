package model.builder;

import model.Account;
import org.joda.time.DateTime;

public class AccountBuilder {
    private Account account;

    public AccountBuilder() {
        account = new Account();
    }

    public AccountBuilder setType(String type) {
        account.setType(type);
        return this;
    }

    public AccountBuilder setAmount(Long amount) {
        account.setAmountOfMoney(amount);
        return this;
    }

    public AccountBuilder setDateOfCreation(DateTime dateOfCreation) {
        account.setDateOfCreation(dateOfCreation);
        return this;
    }

    public AccountBuilder setClientId(Long clientId) {
        account.setClientId(clientId);
        return this;
    }

    public Account build() {
        return account;
    }
}
