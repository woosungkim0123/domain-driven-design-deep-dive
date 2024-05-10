package com.woopay.membership.application.port.in;

import com.woopay.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;


@Getter
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

    @NotNull
    private final String membershipId;

    @NotNull
    @NotBlank
    private final String name;

    @NotNull
    private final String email;

    @NotNull
    @NotBlank
    private final String address;

    @AssertTrue // TODO. 일단 무조건 true로 받도록
    private final boolean isValid;

    @NotNull
    private final boolean isCorp;

    @Builder
    public ModifyMembershipCommand(String membershipId, String name, String email, String address, boolean isValid, boolean isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;

        this.validateSelf();
    }
}
