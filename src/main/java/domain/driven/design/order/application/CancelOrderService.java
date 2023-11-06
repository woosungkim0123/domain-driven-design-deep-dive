package domain.driven.design.order.application;

import domain.driven.design.order.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelOrderService {

    @Transactional
    public void cancelOrder(String orderId) {
        Order order = findOrderById(orderId);
        if (order == null) {
            throw new OrderNotFoundException(orderId);
        }
        order.cancel();
    }

    private Order findOrderById(String orderId) {
        return null;
    }
}
