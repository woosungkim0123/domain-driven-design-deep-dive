package domain.driven.design.order.domain;

import lombok.Getter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (! (obj instanceof Receiver)) return false;
        Receiver receiver = (Receiver) obj;

        return this.name.equals(receiver.name) && this.phoneNumber.equals(receiver.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
