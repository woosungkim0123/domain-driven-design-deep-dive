package domain.driven.design.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Order {
    private OrderNo number;

    private Orderer orderer;

    /**
     * 최소 하나 이상의 OrderLine이 있어야함
     */
    private List<OrderLine> orderLines;
    private Money totalAmounts;

    private OrderState state;
    private ShippingInfo shippingInfo;

    /**
     * 주문시 주문라인들과 배송지 정보를 지정해야한다.
     */
    public Order(Orderer orderer, List<OrderLine> orderLines, ShippingInfo shippingInfo, OrderState state) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        validateOrderChangeability();
        setShippingInfo(newShippingInfo);
    }

    public void cancel() {
        validateOrderChangeability();
        this.state = OrderState.CANCELED;
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) {
            throw new IllegalArgumentException("주문자 정보가 없음");
        }
        this.orderer = orderer;
    }

    private void validateOrderChangeability() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalArgumentException("배송지 변경 불가능 : " + state);
        }
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) { // 도메인 규칙 -> 배송지 정보 필수
            throw new IllegalArgumentException("배송지 정보가 없음");
        }
        this.shippingInfo = shippingInfo;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        validateOrderLineExist(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void validateOrderLineExist(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("주문에는 최소 하나의 주문라인이 있어야 함");
        }
    }

    private void calculateTotalAmounts() {
        int totalSum = orderLines.stream().mapToInt(orderLine -> orderLine.getAmounts().getValue()).sum();
        this.totalAmounts = new Money(totalSum);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Order.class) return false;
        Order order = (Order) obj;
        if (this.number == null) return false;
        return this.number.equals(order.number);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result * ((number == null) ? 0 : number.hashCode());
        return result;
    }
}
