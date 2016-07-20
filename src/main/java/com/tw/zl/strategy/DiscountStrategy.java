package com.tw.zl.strategy;

import com.tw.zl.shoppingcart.ShoppingCart;

import java.util.List;

/**
 * Created by zl on 16-7-20.
 */
public class DiscountStrategy implements Strategy {
    private List<DiscountInfo> disInfoList;

    public DiscountStrategy(List<Object> strategyInfoList) {
        //// TODO: 16-7-20 对外面穿进来的list做强制转换 
    }

    public ShoppingCart getShoppingCartAfterDiscount(ShoppingCart shoppingCart) {
        return shoppingCart;
    }
}
