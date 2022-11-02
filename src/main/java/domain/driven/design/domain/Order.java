package domain.driven.design.domain;

import java.util.List;

public class Order {

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
    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.orderLines = orderLines;
        this.shippingInfo = shippingInfo;
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        validateOrderChangeability();
        setShippingInfo(newShippingInfo);
    }

    public void cancel() {
        validateOrderChangeability();
        this.state = OrderState.CANCELED;
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
        int totalSum = orderLines.stream().mapToInt(OrderLine::getAmounts).sum();
        this.totalAmounts = new Money(totalSum);
    }
}
