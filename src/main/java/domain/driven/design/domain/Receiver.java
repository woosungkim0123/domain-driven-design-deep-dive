package domain.driven.design.domain;

import lombok.Getter;

/**
 * 밸류 타입
 */
@Getter
public class Receiver {
    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
