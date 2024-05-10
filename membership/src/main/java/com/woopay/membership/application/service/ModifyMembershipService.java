package com.woopay.membership.application.service;

import com.woopay.common.UseCase;
import com.woopay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.woopay.membership.application.port.in.ModifyMembershipCommand;
import com.woopay.membership.application.port.in.ModifyMembershipUseCase;
import com.woopay.membership.application.port.out.ModifyMembershipPort;
import com.woopay.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Transactional
@UseCase
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {

        MembershipJpaEntity membershipJpaEntity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp()));

        return membershipJpaEntity.toDomain();
    }
}
