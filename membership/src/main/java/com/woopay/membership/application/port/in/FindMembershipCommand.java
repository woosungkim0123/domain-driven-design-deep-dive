package com.woopay.membership.application.port.in;

import com.woopay.membership.common.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {
    @NotNull
    @NotBlank
    private final String membershipId;

    @Builder
    public FindMembershipCommand(String membershipId) {
        this.membershipId = membershipId;

        this.validateSelf();
    }
}
