package repository.account;

import model.Account;
import model.Client;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();

    Account findByClientId(Long clientId);

    boolean save(Account account, Client client);

    void removeAll();
}
