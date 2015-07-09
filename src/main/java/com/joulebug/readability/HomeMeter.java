package com.joulebug.readability;

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
{
  "account_number": 'ABCD123',
  "utility_company_id": 42
  "data_type": 'electric',
  "username": 'foo',
  "password": 'bar'
}
 */
public class HomeMeter {
    private String account_number;
    private String utility_company;
    private String data_type;
    private String username;
    private String password;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getUtility_company() {
        return utility_company;
    }

    public void setUtility_company(String utility_company) {
        this.utility_company = utility_company;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}




