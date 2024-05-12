package com.woopay.banking.application.port.in;

import com.woopay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {
    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
