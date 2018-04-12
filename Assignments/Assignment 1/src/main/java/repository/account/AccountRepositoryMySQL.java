package repository.account;

import model.Account;
import model.Client;
import model.builder.AccountBuilder;
import org.joda.time.DateTime;
import repository.security.RightsRolesRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static database.Constants.Tables.ACCOUNT;

public class AccountRepositoryMySQL implements AccountRepository {
    private final Connection connection;
    private final RightsRolesRepository rightsRolesRepository;


    public AccountRepositoryMySQL(Connection connection, RightsRolesRepository rightsRolesRepository) {
        this.connection = connection;
        this.rightsRolesRepository = rightsRolesRepository;
    }

    @Override
    public List<Account> findAll() {
        try {
            Statement statement = connection.createStatement();
            String findAllSql = "SELECT * FROM `" + ACCOUNT + "`";
            ResultSet accountResultSet = statement.executeQuery(findAllSql);
            List<Account> allAccounts = new ArrayList<>();
            while (accountResultSet.next()) {
                Account account = new AccountBuilder()
                        .setType(accountResultSet.getString("type"))
                        .setAmount(accountResultSet.getLong("amountOfMoney"))
                        .setDateOfCreation(new DateTime(accountResultSet.getDate("dateOfCreation")))
                        .setClientId(accountResultSet.getLong("clientId"))
                        .build();
                allAccounts.add(account);
            }
            return allAccounts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account findByClientId(Long clientId) {
        Account account = new AccountBuilder().build();
        try {
            Statement statement = connection.createStatement();
            String fetchAccountSql = "SELECT * from `" + ACCOUNT + "` where `clientId`=\'" + clientId + "\'";
            ResultSet accountResultSet = statement.executeQuery(fetchAccountSql);
            while (accountResultSet.next()) {
                account = new AccountBuilder()
                        .setType(accountResultSet.getString("type"))
                        .setAmount(accountResultSet.getLong("amountOfMoney"))
                        .setDateOfCreation(new DateTime(accountResultSet.getDate("dateOfCreation")))
                        .setClientId(accountResultSet.getLong("clientId"))
                        .build();
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Account account, Client client) {
        try {
            PreparedStatement saveAccountStatement = connection
                    .prepareStatement("INSERT INTO account VALUES (null,?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            saveAccountStatement.setString(1, account.getType());
            saveAccountStatement.setLong(2, account.getAmountOfMoney());
            saveAccountStatement.setLong(4, client.getId());
            saveAccountStatement.executeUpdate();

            ResultSet resultSet = saveAccountStatement.getGeneratedKeys();
            resultSet.next();
            Long accountId = resultSet.getLong("1");
            account.setId(accountId);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void removeAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE from account where id >= 0";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
