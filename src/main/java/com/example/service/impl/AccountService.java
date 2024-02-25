package com.example.service.impl;

import com.example.dao.impl.AccountDAO;
import com.example.model.AccountModel;
import com.example.service.IAccountService;

public class AccountService implements IAccountService {
    private AccountDAO accountDAO = new AccountDAO();
    public AccountService() {
    }

    @Override
    public boolean Login(String username, String password) {
        AccountModel accountModel = accountDAO.findOneByUsernameAndPassword(username, password);
        if (accountModel != null) return true;
        return false;
    }
}