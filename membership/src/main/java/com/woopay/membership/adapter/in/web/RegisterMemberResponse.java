package com.woopay.membership.adapter.in.web;

import com.woopay.membership.domain.Membership;

public record RegisterMemberResponse (
        String name,
        String email
) {
    public static RegisterMemberResponse from(Membership membership) {
        return new RegisterMemberResponse(
                membership.getName().membershipName(),
                membership.getEmail().membershipEmail()
        );
    }
}
