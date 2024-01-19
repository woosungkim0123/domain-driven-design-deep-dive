package com.woopay.membership.adapter.in.web;

import com.woopay.membership.domain.Membership;

public record FindMemberResponse (
        String membershipId,
        String name,
        String email,
        String address,
        boolean isCorp
) {
    public static FindMemberResponse from(Membership membership) {
        return new FindMemberResponse(
                membership.getMembershipId().membershipId(),
                membership.getName().membershipName(),
                membership.getEmail().membershipEmail(),
                membership.getAddress().membershipAddress(),
                membership.getIsCorp().membershipIsCorp()
        );
    }
}
