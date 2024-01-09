package com.woopay.membership.application.service;

import com.woopay.membership.application.port.in.FindMembershipCommand;
import com.woopay.membership.application.port.in.FindMembershipUseCase;
import com.woopay.membership.application.port.out.FindMembershipPort;
import com.woopay.membership.common.UseCase;
import com.woopay.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Transactional
@UseCase
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        return findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId())).toDomain();
    }
}
