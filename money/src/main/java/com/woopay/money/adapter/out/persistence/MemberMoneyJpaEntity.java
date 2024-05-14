package com.woopay.money.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "member_money")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberMoneyJpaEntity {
    @Id
    @GeneratedValue
    private Long memberMoneyId;

    private Long membershipId;

    private int balance;

    public MemberMoneyJpaEntity(Long membershipId, int balance) {
        this.membershipId = membershipId;
        this.balance = balance;
    }
}
