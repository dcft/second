package com.qf.Account;

import java.util.List;

public interface AccountApi {
    Account findAccount(String username,String password);
    List showAllAccount();
}
