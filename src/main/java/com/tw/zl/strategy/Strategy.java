package com.tw.zl.strategy;

import com.tw.zl.shoppingcart.ShoppingCart;

import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 打折策略接口
 *
 */
public interface Strategy {
    /**
     * @desc 计算打折策略后的价钱
     * @param shoppingCart ShoppingCart
     * @return ShoppingCart
     */
    public ShoppingCart getShoppingCartAfterStrategy(ShoppingCart shoppingCart);
    public void setStrategyInfoList(List strategyInfoList);
}
