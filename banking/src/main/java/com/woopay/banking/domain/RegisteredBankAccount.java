package com.woopay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankAccount {

    @Getter private final String registeredBankAccountId;
    @Getter private final String membershipId;
    @Getter private final String bankName;
    @Getter private final String bankAccountNumber;
    @Getter private final boolean linkedStatusIsValid;

    public static RegisteredBankAccount generateRegisteredBankAccount (
            RegisteredBankAccountId registeredBankAccountId,
            MembershipId membershipId,
            BankName bankName,
            BankAccountNumber bankAccountNumber,
            LinkedStatusIsValid linkedStatusIsValid
    ){
        return new RegisteredBankAccount(
            registeredBankAccountId.registeredBankAccountId,
            membershipId.membershipId,
            bankName.bankName,
            bankAccountNumber.bankAccountNumber,
            linkedStatusIsValid.linkedStatusIsValid
        );
    }

    public record RegisteredBankAccountId(String registeredBankAccountId) {}
    public record MembershipId(String membershipId) {}
    public record BankName(String bankName) {}
    public record BankAccountNumber(String bankAccountNumber) {}
    public record LinkedStatusIsValid(boolean linkedStatusIsValid) {}
}
