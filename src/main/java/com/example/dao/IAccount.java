package com.example.dao;

import com.example.model.AccountModel;

public interface IAccount {
    AccountModel findOneByUsernameAndPassword(String username, String password);
}
