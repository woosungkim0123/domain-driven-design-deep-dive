package com.woopay.membership.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Membership {

    @Getter private final String membershipId;

    @Getter private final String name;

    @Getter private final String email;

    @Getter private final String address;

    @Getter private final boolean isValid;

    @Getter private final boolean isCorp;

    public static Membership generateMembership(MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid, MembershipIsCorp membershipIsCorp) {
        return new Membership(membershipId.membershipId, membershipName.membershipName, membershipEmail.membershipEmail, membershipAddress.membershipAddress, membershipIsValid.membershipIsValid, membershipIsCorp.membershipIsCorp);
    }

    public record MembershipId(String membershipId) {}
    public record MembershipName(String membershipName) {}
    public record MembershipEmail(String membershipEmail) {}
    public record MembershipAddress(String membershipAddress) {}
    public record MembershipIsValid(boolean membershipIsValid) {}
    public record MembershipIsCorp(boolean membershipIsCorp) {}
}
