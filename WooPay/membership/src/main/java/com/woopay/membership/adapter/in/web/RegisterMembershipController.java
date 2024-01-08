package com.woopay.membership.adapter.in.web;

import com.woopay.membership.application.port.in.RegisterMembershipCommand;
import com.woopay.membership.application.port.in.RegisterMembershipUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Adapter
@RequiredArgsConstructor
@RestController
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    void registerMembership(@RequestBody RegisterMemberShipRequest request) {

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        registerMembershipUseCase.registerMembership(command); // TODO 응답 처리 해야함
    }
}
