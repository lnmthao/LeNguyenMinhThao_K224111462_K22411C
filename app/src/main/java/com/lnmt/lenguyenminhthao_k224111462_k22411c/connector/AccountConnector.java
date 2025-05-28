package com.lnmt.lenguyenminhthao_k224111462_k22411c.connector;

import com.lnmt.lenguyenminhthao_k224111462_k22411c.models.Account;
import com.lnmt.lenguyenminhthao_k224111462_k22411c.models.ListAccount;

public class AccountConnector {
    private ListAccount listAccount;

    public AccountConnector() {
        listAccount = new ListAccount();
    }

    public Account login(String usr, String pwd) {
        for (Account account : listAccount.getAccounts()) {
            if (account.getUsr().equalsIgnoreCase(usr) && account.getPwd().equalsIgnoreCase(pwd)) {
                return account;
            }
        }
        return null;
    }
}