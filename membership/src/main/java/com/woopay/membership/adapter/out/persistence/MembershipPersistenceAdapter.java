package com.woopay.membership.adapter.out.persistence;

import com.woopay.membership.application.port.out.FindMembershipPort;
import com.woopay.membership.application.port.out.ModifyMembershipPort;
import com.woopay.membership.application.port.out.RegisterMembershipPort;
import com.woopay.membership.common.PersistenceAdapter;
import com.woopay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {

        MembershipJpaEntity entity = membershipRepository.findById(Long.parseLong(membershipId.membershipId()))
                .orElseThrow(() -> new IllegalArgumentException("Membership not found"));

        entity = entity.changeMembership(
                membershipName.membershipName(),
                membershipEmail.membershipEmail(),
                membershipAddress.membershipAddress(),
                membershipIsValid.membershipIsValid(),
                membershipIsCorp.membershipIsCorp()
        );

        return membershipRepository.save(entity);
    }
}
