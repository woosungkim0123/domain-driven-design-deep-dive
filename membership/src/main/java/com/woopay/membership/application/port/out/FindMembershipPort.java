package com.woopay.membership.application.port.out;

import com.woopay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.woopay.membership.domain.Membership;

import java.util.Optional;

public interface FindMembershipPort {
    Optional<MembershipJpaEntity> findMembership(
            Membership.MembershipId membershipId
    );
}
