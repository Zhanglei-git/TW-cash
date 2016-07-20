package com.tw.zl;

import com.tw.zl.strategy.BuyAndFreeStrategy;
import com.tw.zl.strategy.DiscountStrategy;
import com.tw.zl.strategy.Strategy;

import java.util.List;

/**
 * Created by zl on 16-7-20.
 */
public class StrategyFactory {
    public static Strategy creatStrategy(StrategyType strategyType){
        switch(strategyType){
            case BUY_TWO_GET_ONE_FREE:
                return new BuyAndFreeStrategy();
            case PRICE_95_PERCENT:
                return new DiscountStrategy();
            default:
                break;
        }
        return null;
    }
}
