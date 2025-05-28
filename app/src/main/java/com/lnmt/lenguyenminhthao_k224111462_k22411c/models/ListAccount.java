package com.lnmt.lenguyenminhthao_k224111462_k22411c.models;

import java.util.ArrayList;

public class ListAccount {
    private ArrayList<Account> accounts;

    public ListAccount() {
        accounts = new ArrayList<>();
        generateSampleData();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    private void generateSampleData() {
        accounts.add(new Account(101, "thao", "123"));
        accounts.add(new Account(102, "usr2", "pwd2"));
        accounts.add(new Account(103, "usr3", "pwd3"));
        accounts.add(new Account(104, "usr4", "pwd4"));
        accounts.add(new Account(105, "usr5", "pwd5"));
        accounts.add(new Account(106, "usr6", "pwd6"));
        accounts.add(new Account(107, "usr7", "pwd7"));
        accounts.add(new Account(108, "usr8", "pwd8"));
        accounts.add(new Account(109, "usr9", "pwd9"));
        accounts.add(new Account(110, "usr10", "pwd10"));
    }
}
