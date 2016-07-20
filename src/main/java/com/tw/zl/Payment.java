package com.tw.zl;

import com.tw.zl.shoppingcart.ShoppingCart;
import com.tw.zl.strategy.StrategyList;

/**
 * Created by zl on 16-7-20.
 * @desc 计算所有策略过滤之后的价钱
 */
public class Payment {
    private ShoppingCart shoppingCart;

    public Payment(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public ShoppingCart calculateAfterAllStrategy(){
        //// TODO: 16-7-20 实现按照策略过滤打折
        return null;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
