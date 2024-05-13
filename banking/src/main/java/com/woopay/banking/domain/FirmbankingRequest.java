package com.woopay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmbankingRequest {
    @Getter private final String firmbankingRequestId;

    @Getter private final String fromBankName;

    @Getter private final String fromBankAccountNumber;

    @Getter private final String toBankName;

    @Getter private final String toBankAccountNumber;

    @Getter private final int moneyAmount; // only won

    @Getter private final int firmbankingStatus; // 0: 요청, 1: 완료, 2: 실패

    @Getter private final UUID uuid;

    public static FirmbankingRequest generateFirmbankingRequest (
            FirmbankingRequestId firmbankingRequestId,
            FromBankName fromBankName,
            FromBankAccountNumber fromBankAccountNumber,
            ToBankName toBankName,
            ToBankAccountNumber toBankAccountNumber,
            MoneyAmount moneyAmount,
            FirmbankingStatus firmbankingStatus,
            UUID uuid
    ){
        return new FirmbankingRequest(
                firmbankingRequestId.firmbankingRequestId(),
                fromBankName.fromBankName(),
                fromBankAccountNumber.fromBankAccountNumber(),
                toBankName.toBankName(),
                toBankAccountNumber.toBankAccountNumber(),
                moneyAmount.moneyAmount(),
                firmbankingStatus.firmbankingStatus(),
                uuid
        );
    }

    public record FirmbankingRequestId(String firmbankingRequestId) {}
    public record FromBankName(String fromBankName) {}
    public record FromBankAccountNumber(String fromBankAccountNumber) {}
    public record ToBankName(String toBankName) {}
    public record ToBankAccountNumber(String toBankAccountNumber) {}
    public record MoneyAmount(int moneyAmount) {}
    public record FirmbankingStatus(int firmbankingStatus) {}
}
