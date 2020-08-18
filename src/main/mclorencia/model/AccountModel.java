package main.mclorencia.model;

import com.mclorencia.serverhandle.UserDBO;
import main.mclorencia.config.ConfigUtil;
import main.mclorencia.entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AccountModel {
    Connection conn;
    Properties properties;
    String accountTable;

    public AccountModel() {
        this.conn = new ConnectionHelper().getConn();
        properties = new ConfigUtil().getProperties();
        accountTable = properties.getProperty("AccountTable");
    }

    public int createAccount(Account account){
        String SqlQuery = "INSERT INTO " + accountTable + "(username, password) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return 0;
    }

    public List<Account> getAllAccount(){
        String SqlQuery = "SELECT * FROM " + accountTable;
        List<Account> listAccount = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SqlQuery);
            Account account;
            while (rs.next()){
                account = new Account();
                account.setAccountId(rs.getInt("accountId"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                listAccount.add(account);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return listAccount;
    }
}
