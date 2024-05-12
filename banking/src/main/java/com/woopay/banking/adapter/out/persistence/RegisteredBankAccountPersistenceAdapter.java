package com.woopay.banking.adapter.out.persistence;

import com.woopay.banking.application.port.out.RegisterBankAccountPort;
import com.woopay.banking.domain.RegisteredBankAccount;
import com.woopay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankAccount.MembershipId membershipId, RegisteredBankAccount.BankName bankName, RegisteredBankAccount.BankAccountNumber bankAccountNumber, RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return bankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                        membershipId.membershipId(),
                        bankName.bankName(),
                        bankAccountNumber.bankAccountNumber(),
                        linkedStatusIsValid.linkedStatusIsValid()
                )
        );
    }
}
