package com.woopay.membership.adapter.in.web;

import com.woopay.membership.domain.Membership;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindMemberResponse {

    private String membershipId;
    private String name;
    private String email;
    private String address;
    private boolean isCorp;

    public static FindMemberResponse from(Membership membership) {
        return FindMemberResponse.builder()
                .membershipId(membership.getMembershipId())
                .name(membership.getName())
                .email(membership.getEmail())
                .address(membership.getAddress())
                .isCorp(membership.isCorp())
                .build();
    }
}
