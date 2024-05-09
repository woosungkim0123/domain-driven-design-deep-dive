package com.woopay.membership.adapter.out.persistence;

import com.woopay.membership.domain.Membership;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "membership")
@Entity
public class MembershipJpaEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String address;

    private boolean isValid;

    private boolean isCorp;

    public MembershipJpaEntity(String name, String email, String address, boolean isValid, boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }

    public Membership toDomain() {
        return Membership.generateMembership(
                new Membership.MembershipId(id.toString()),
                new Membership.MembershipName(name),
                new Membership.MembershipEmail(email),
                new Membership.MembershipAddress(address),
                new Membership.MembershipIsValid(isValid),
                new Membership.MembershipIsCorp(isCorp)
        );
    }

    public MembershipJpaEntity changeMembership(String name, String email, String address, boolean isValid, boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
        return this;
    }
}
