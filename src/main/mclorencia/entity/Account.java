package main.mclorencia.entity;

public class Account {
    private String AccountId;
    private String Username;
    private String Password;

    public Account(String accountId, String username, String password) {
        AccountId = accountId;
        Username = username;
        Password = password;
    }

    public Account() {
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
