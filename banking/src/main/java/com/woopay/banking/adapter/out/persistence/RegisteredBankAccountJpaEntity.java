package com.woopay.banking.adapter.out.persistence;

import com.woopay.banking.domain.RegisteredBankAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "registered_bank_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredBankAccountJpaEntity {
    @Id
    @GeneratedValue
    private Long registeredBankAccountId;

    private String membershipId;

    private String bankName;

    private String bankAccountNumber;

    private boolean linkedStatusIsValid;

    public RegisteredBankAccountJpaEntity(String membershipId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }

    public RegisteredBankAccount toDomain() {
        return RegisteredBankAccount.generateRegisteredBankAccount(
                new RegisteredBankAccount.RegisteredBankAccountId(registeredBankAccountId + ""),
                new RegisteredBankAccount.MembershipId(membershipId),
                new RegisteredBankAccount.BankName(bankName),
                new RegisteredBankAccount.BankAccountNumber(bankAccountNumber),
                new RegisteredBankAccount.LinkedStatusIsValid(linkedStatusIsValid)
        );
    }

    @Override
    public String toString() {
        return "RegisteredBankAccountJpaEntity{" +
                "registeredBankAccountId=" + registeredBankAccountId +
                ", membershipId='" + membershipId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", linkedStatusIsValid=" + linkedStatusIsValid +
                '}';
    }
}
