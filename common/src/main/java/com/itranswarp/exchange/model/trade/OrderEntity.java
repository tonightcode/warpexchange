package com.itranswarp.exchange.model.trade;

import java.math.BigDecimal;

import com.itranswarp.exchange.enums.Direction;
import com.itranswarp.exchange.enums.OrderStatus;

public class OrderEntity {
    // 订单ID 定序ID 用户ID
    public Long id;
    public Long sequenceId;
    public Long userId;

    // 价格 方向 状态
    public BigDecimal price;
    public Direction direction;
    public OrderStatus status;

    //订单数量 未成交数量
    public BigDecimal quantity;
    public BigDecimal unfilledQuantity;

    //创建和更新时间
    public Long createdAt;
    public Long updatedAt;
}
