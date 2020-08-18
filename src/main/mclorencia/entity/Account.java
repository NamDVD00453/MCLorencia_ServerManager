package main.mclorencia.entity;

public class Account {
    private int AccountId;
    private String Username;
    private String Password;

    public Account(int accountId, String username, String password) {
        AccountId = accountId;
        Username = username;
        Password = password;
    }

    public Account() {
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
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
