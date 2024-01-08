package com.woopay.membership.application.port.in;

import com.woopay.membership.domain.Membership;

public interface RegisterMembershipUseCase {
    Membership registerMembership(RegisterMembershipCommand command);
}
