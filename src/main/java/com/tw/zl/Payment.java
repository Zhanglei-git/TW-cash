package com.tw.zl;

import com.tw.zl.shoppingcart.ShoppingCart;
import com.tw.zl.strategy.Strategy;
import com.tw.zl.strategy.StrategyItem;
import com.tw.zl.strategy.StrategyList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 计算所有策略过滤之后的价钱
 */
public class Payment {
    private ShoppingCart shoppingCart;
    private List conflictFlagList = new ArrayList();
    public Payment(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public ShoppingCart calculateAfterAllStrategy(){
        Iterator iterator = StrategyList.iterator();
        while(iterator.hasNext()){
            StrategyItem strategyItem = (StrategyItem) iterator.next();
            caculate(strategyItem);
        }
        return shoppingCart;
    }
    private void caculate(StrategyItem strategyItem){
        if(!conflictFlagList.contains(strategyItem.getConflictFlag())){
            shoppingCart = strategyItem.getStrategy().getShoppingCartAfterStrategy(shoppingCart);
            if (strategyItem.isOnlyMe()){
                conflictFlagList.add(strategyItem.getConflictFlag());
            }
        }
    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
