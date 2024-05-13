package com.woopay.banking.adapter.out.persistence;

import com.woopay.banking.domain.FirmbankingRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Entity
@Table(name = "request_firmbanking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmbankingRequestJpaEntity {
    @Id
    @GeneratedValue
    private Long requestFirmbankingId;

    private String fromBankName;

    private  String fromBankAccountNumber;

    private  String toBankName;

    private  String toBankAccountNumber;

    private int moneyAmount; // only won

    private int firmbankingStatus; // 0: 요청, 1: 완료, 2: 실패

    private String uuid;

    public FirmbankingRequestJpaEntity(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount, int firmbankingStatus, UUID uuid) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.firmbankingStatus = firmbankingStatus;
        this.uuid = uuid.toString();
    }

    public FirmbankingRequest toDomain(UUID uuid) {
        return FirmbankingRequest.generateFirmbankingRequest(
                new FirmbankingRequest.FirmbankingRequestId(requestFirmbankingId + ""),
                new FirmbankingRequest.FromBankName(fromBankName),
                new FirmbankingRequest.FromBankAccountNumber(fromBankAccountNumber),
                new FirmbankingRequest.ToBankName(toBankName),
                new FirmbankingRequest.ToBankAccountNumber(toBankAccountNumber),
                new FirmbankingRequest.MoneyAmount(moneyAmount),
                new FirmbankingRequest.FirmbankingStatus(firmbankingStatus),
                uuid
        );
    }

    @Override
    public String toString() {
        return "RequestFirmbankingJpaEntity{" +
                "requestFirmbankingId=" + requestFirmbankingId +
                ", fromBankName='" + fromBankName + '\'' +
                ", fromBankAccountNumber='" + fromBankAccountNumber + '\'' +
                ", toBankName='" + toBankName + '\'' +
                ", toBankAccountNumber='" + toBankAccountNumber + '\'' +
                ", moneyAmount=" + moneyAmount +
                ", firmbankingStatus=" + firmbankingStatus +
                '}';
    }
}
