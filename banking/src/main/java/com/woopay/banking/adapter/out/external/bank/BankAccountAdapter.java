package com.woopay.banking.adapter.out.external.bank;

import com.woopay.banking.application.port.out.RequestBankAccountInfoPort;
import com.woopay.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        // 실제 은행에 http 요청해서 은행 계좌 정보를 가져온다.
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
