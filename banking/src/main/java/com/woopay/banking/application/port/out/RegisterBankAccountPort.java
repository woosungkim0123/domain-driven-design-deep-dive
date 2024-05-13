package com.woopay.banking.application.port.out;

import com.woopay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.woopay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {
    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
