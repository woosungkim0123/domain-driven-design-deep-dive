package com.woopay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {
    @Getter private final String memberMoneyId;
    @Getter private final String membershipId;
    @Getter private final int balance;  // 잔액
    // @Getter private final int linkedBankAccount;

    public static MemberMoney generateMemberMoney (
            MemberMoneyId memberMoneyId,
            MembershipId membershipId,
            MoneyBalance moneyBalance
    ){
        return new MemberMoney(
                memberMoneyId.memberMoneyId,
                membershipId.membershipId,
                moneyBalance.moneyBalance
        );
    }
    public record MemberMoneyId(String memberMoneyId) {}
    public record MembershipId(String membershipId) {}
    public record MoneyBalance(int moneyBalance) {}
}
