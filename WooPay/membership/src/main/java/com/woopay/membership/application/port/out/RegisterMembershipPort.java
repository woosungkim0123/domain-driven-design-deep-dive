package com.woopay.membership.application.port.out;

import com.woopay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.woopay.membership.domain.Membership;

public interface RegisterMembershipPort {
    MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    );
}
