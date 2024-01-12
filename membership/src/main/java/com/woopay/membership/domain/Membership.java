package com.woopay.membership.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Membership {

    private final MembershipId membershipId;

    private final MembershipName name;

    private final MembershipEmail email;

    private final MembershipAddress address;

    private final MembershipIsValid isValid;

    private final MembershipIsCorp isCorp;

    public static Membership generateMembership(MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid, MembershipIsCorp membershipIsCorp) {
        return new Membership(membershipId, membershipName, membershipEmail, membershipAddress, membershipIsValid, membershipIsCorp);
    }

    public record MembershipId(String membershipId) {}
    public record MembershipName(String membershipName) {}
    public record MembershipEmail(String membershipEmail) {}
    public record MembershipAddress(String membershipAddress) {}
    public record MembershipIsValid(boolean membershipIsValid) {}
    public record MembershipIsCorp(boolean membershipIsCorp) {}
}
