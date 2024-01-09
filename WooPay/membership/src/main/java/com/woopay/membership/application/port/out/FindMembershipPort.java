package com.woopay.membership.application.port.out;

import com.woopay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.woopay.membership.domain.Membership;

public interface FindMembershipPort {
    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );
}
