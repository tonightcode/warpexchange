package com.itranswarp.exchange.assets;

import java.math.BigDecimal;

/**
 * 资产
 */
public class Asset {
    // 可用余额:
    BigDecimal available;
    // 冻结余额:
    BigDecimal frozen;

    public Asset() {
        this(BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public Asset(BigDecimal available, BigDecimal frozen) {
        this.available = available;
        this.frozen = frozen;
    }
}
