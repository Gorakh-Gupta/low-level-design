package com.gorakh.lldrunner.digitalwallet;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private final String name;
    private final String password;
    private List<Account> accounts;

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }


}
