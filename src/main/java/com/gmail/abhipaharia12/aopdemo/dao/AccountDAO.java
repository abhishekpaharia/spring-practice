package com.gmail.abhipaharia12.aopdemo.dao;

import java.util.List;

import com.gmail.abhipaharia12.aopdemo.Account;

public interface AccountDAO {

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
