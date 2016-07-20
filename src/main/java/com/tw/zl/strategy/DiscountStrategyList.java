package com.tw.zl.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 打折策略列表
 */
public class DiscountStrategyList {
    private static List<DiscountStrategy> discountStrategyList = new ArrayList<DiscountStrategy>();
    public static void add(DiscountStrategy discountStrategy){
        discountStrategyList.add(discountStrategy);
    }
    public static void remove(DiscountStrategy discountStrategy){
        discountStrategyList.remove(discountStrategy);
    }
    public static void clear(){
        discountStrategyList.clear();
    }

    public static List<DiscountStrategy> getDiscountStrategyList() {
        return discountStrategyList;
    }

    public static void setDiscountStrategyList(List<DiscountStrategy> discountStrategyList) {
        DiscountStrategyList.discountStrategyList = discountStrategyList;
    }
}
