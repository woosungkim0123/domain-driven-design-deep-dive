package com.woopay.banking.application.port.out;

import com.woopay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.woopay.banking.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
    FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
