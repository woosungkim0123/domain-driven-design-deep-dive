package com.woopay.banking.application.port.out;


import com.woopay.banking.adapter.out.external.bank.BankAccount;
import com.woopay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request) ;
}
