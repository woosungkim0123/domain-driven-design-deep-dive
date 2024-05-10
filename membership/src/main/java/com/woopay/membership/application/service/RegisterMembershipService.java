package com.woopay.membership.application.service;

import com.woopay.common.UseCase;
import com.woopay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.woopay.membership.application.port.in.RegisterMembershipCommand;
import com.woopay.membership.application.port.in.RegisterMembershipUseCase;
import com.woopay.membership.application.port.out.RegisterMembershipPort;
import com.woopay.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Transactional
@UseCase
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        MembershipJpaEntity membershipJpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp()));

        return membershipJpaEntity.toDomain();
    }
}
