package com.woopay.banking.adapter.in.web;

import com.woopay.banking.application.port.in.RegisterBankAccountCommand;
import com.woopay.banking.application.port.in.RegisterBankAccountUseCase;
import com.woopay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {
    private final RegisterBankAccountUseCase registeredBankAccountUseCase;

    @PostMapping(path = "/banking/account/register")
    RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        return registeredBankAccountUseCase.registerBankAccount(command);
    }
}
