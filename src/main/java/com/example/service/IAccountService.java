package com.example.service;

import com.example.model.AccountModel;

public interface IAccountService {
    AccountModel Login (String username, String password);
}
