package com.woopay.banking.adapter.out.persistence;


import com.woopay.banking.application.port.out.RequestFirmbankingPort;
import com.woopay.banking.domain.FirmbankingRequest;
import com.woopay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;


    @Override
    public FirmbankingRequestJpaEntity createFirmbankingRequest(FirmbankingRequest.FromBankName fromBankName, FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmbankingRequest.ToBankName toBankName, FirmbankingRequest.ToBankAccountNumber toBankAccountNumber, FirmbankingRequest.MoneyAmount moneyAmount, FirmbankingRequest.FirmbankingStatus firmbankingStatus) {
        return firmbankingRequestRepository.save(new FirmbankingRequestJpaEntity(
                        fromBankName.fromBankName(),
                        fromBankAccountNumber.fromBankAccountNumber(),
                        toBankName.toBankName(),
                        toBankAccountNumber.toBankAccountNumber(),
                        moneyAmount.moneyAmount(),
                        firmbankingStatus.firmbankingStatus(),
                        UUID.randomUUID()
                )
        );
    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity) {
        return firmbankingRequestRepository.save(entity);
    }
}
