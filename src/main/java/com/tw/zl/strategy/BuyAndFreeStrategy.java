package com.tw.zl.strategy;

import com.tw.zl.shoppingcart.ShoppingCart;

import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 买二赠一优惠策略
 */
public class BuyAndFreeStrategy implements Strategy{


    public ShoppingCart getShoppingCartAfterStrategy(ShoppingCart shoppingCart) {


        return shoppingCart;
    }

    public void setStrategyInfoList(List strategyInfoList) {

    }
}
