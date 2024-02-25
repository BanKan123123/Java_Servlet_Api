package com.example.dao.impl;

import com.example.dao.IAccount;
import com.example.model.AccountModel;
import com.example.model.BookModel;
import com.example.utils.ConfigDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AccountDAO implements IAccount {

    public AccountDAO(){}

    @Override
    public AccountModel findOneByUsernameAndPassword(String username, String password) {
        AccountModel accountModel = new AccountModel();
        String sql = "Select * from account where account.username = '" + username + "' and password = '" + password + "'";
        try (Connection conn = ConfigDB.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                accountModel = this.setFieldAccount(resultSet);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return accountModel;
    }

    public AccountModel setFieldAccount (ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        int role = resultSet.getInt("role");
        Date createdAt = resultSet.getDate("created_at");
        Date updatedAt = resultSet.getDate("updated_at");
        return new AccountModel(id, username, password, email, role, createdAt, updatedAt);
    }
}
