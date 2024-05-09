package com.woopay.membership.application.port.in;

import com.woopay.membership.domain.Membership;

public interface ModifyMembershipUseCase {
    Membership modifyMembership(ModifyMembershipCommand command);
}
