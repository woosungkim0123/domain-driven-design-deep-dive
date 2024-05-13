package com.woopay.banking.application.port.in;

import com.woopay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {
    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
