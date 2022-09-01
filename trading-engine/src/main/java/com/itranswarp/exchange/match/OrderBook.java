package com.itranswarp.exchange.match;

import java.util.Comparator;
import java.util.TreeMap;

import com.itranswarp.exchange.enums.Direction;
import com.itranswarp.exchange.model.trade.OrderEntity;

public class OrderBook {

    public final Direction direction; //方向
    public final TreeMap<OrderKey,OrderEntity> book; //排序树

    //按照direction 排序取出
    public OrderBook(Direction direction) {
        this.direction = direction;
        this.book = new TreeMap<>(direction == Direction.BUY ? SORT_BUY : SORT_SELL);
    }

    //查找首元素
    public OrderEntity getFirst() {
        return this.book.isEmpty() ? null : this.book.firstEntry().getValue();
    }

    //删除首元素
    public boolean remove(OrderEntity order){
        return this.book.remove(new OrderKey(order.sequenceId, order.price)) !=null;
    }

    //添加首元素
    public boolean add(OrderEntity order){
        return this.book.put(new OrderKey(order.sequenceId, order.price), order) == null;
    }

    //覆写排序规则 在Java中比较两个BigDecimal的值只能使用compareTo()，不能使用equals()！
    private static final Comparator<OrderKey> SORT_SELL = new Comparator<>() {
        public int compare(OrderKey o1, OrderKey o2) {
            // 价格低在前:
            int cmp = o1.price().compareTo(o2.price());
            // 时间早在前:
            return cmp == 0 ? Long.compare(o1.sequenceId(), o2.sequenceId()) : cmp;
        }
    };

    //覆写排序规则
    private static final Comparator<OrderKey> SORT_BUY = new Comparator<>() {
        public int compare(OrderKey o1, OrderKey o2) {
            // 价格高在前:
            int cmp = o2.price().compareTo(o1.price());
            // 时间早在前:
            return cmp == 0 ? Long.compare(o1.sequenceId(), o2.sequenceId()) : cmp;
        }
    };
}
