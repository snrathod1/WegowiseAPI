package com.joulebug.wegowise.WegoHome;

/**
 * Created by shraddharathod on 6/30/15.
 */
/**
{
        "account_number": "123456789",
        "utility_company_id": 231,
        "username": "jane_smith",
        "password": "pasword123",
        "data_type": "Gas"
        }
 */
public class CreateAMeter {
    private String account_number;
    private String utility_company;
    private String username;
    private String password;
    private String data_type;

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

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }


}
