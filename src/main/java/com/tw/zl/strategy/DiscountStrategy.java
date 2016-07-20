package com.tw.zl.strategy;

import com.tw.zl.shoppingcart.ShoppingCart;

import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 实现Strategy接口的打折类方法
 */
public class DiscountStrategy implements Strategy {
    private List<DiscountInfo> disInfoList;

    public void setStrategyInfoList(List strategyInfoList) {
        this.disInfoList =(List<DiscountInfo>) strategyInfoList;
    }

    public ShoppingCart getShoppingCartAfterDiscount(ShoppingCart shoppingCart) {
        return shoppingCart;
    }
}
