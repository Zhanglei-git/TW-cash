package com.tw.zl;

import com.tw.zl.strategy.DiscountStrategy;
import com.tw.zl.strategy.Strategy;

/**
 * Created by zl on 16-7-20.
 */
public class StrategyFactory {
    public Strategy creatStrategy(StrategyType strategyType){
        switch(strategyType){
            case BUY_TWO_GET_ONE_FREE:
                return new DiscountStrategy();
            case PRICE_95_PERCENT:
                return new DiscountStrategy();
            default:
                break;
        }
        return null;
    }
}
