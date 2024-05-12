package com.woopay.banking.application.service;


import com.woopay.banking.adapter.out.external.bank.BankAccount;
import com.woopay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.woopay.banking.application.port.in.RegisterBankAccountCommand;
import com.woopay.banking.application.port.in.RegisterBankAccountUseCase;
import com.woopay.banking.application.port.out.RegisterBankAccountPort;
import com.woopay.banking.application.port.out.RequestBankAccountInfoPort;
import com.woopay.banking.domain.RegisteredBankAccount;
import com.woopay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {
        // 실제 외부의 은행계좌 정보를 Get
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid =  accountInfo.isValid();

        // 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록가능하지 않은 계좌라면. 에러를 리턴
        if (!accountIsValid) {
            throw new IllegalArgumentException("Invalid Bank Account");
        }

        return registerBankAccountPort.createRegisteredBankAccount(
                new RegisteredBankAccount.MembershipId(command.getMembershipId()+""),
                new RegisteredBankAccount.BankName(command.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
        ).toDomain();
    }
}
