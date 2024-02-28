package com.example.dao;

import com.example.model.AccountModel;
import java.util.List;

public interface IAccount {
    AccountModel findOneByUsernameAndPassword(String username, String password);


public interface IAccount {

    List<AccountModel> findAllAccount();

    AccountModel findOneAccount(String username);

    AccountModel signInAccount(String username, String password);

    void registerAccount(AccountModel account);

}
