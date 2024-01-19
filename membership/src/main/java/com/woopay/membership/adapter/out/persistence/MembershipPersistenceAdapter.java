package com.woopay.membership.adapter.out.persistence;

import com.woopay.membership.application.port.out.FindMembershipPort;
import com.woopay.membership.application.port.out.RegisterMembershipPort;
import com.woopay.membership.common.PersistenceAdapter;
import com.woopay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final MembershipJpaRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
                new MembershipJpaEntity(
                        membershipName.membershipName(),
                        membershipEmail.membershipEmail(),
                        membershipAddress.membershipAddress(),
                        membershipIsValid.membershipIsValid(),
                        membershipIsCorp.membershipIsCorp()
                )
        );
    }

    @Override
    public Optional<MembershipJpaEntity> findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.findById(Long.parseLong(membershipId.membershipId()));
    }
}
