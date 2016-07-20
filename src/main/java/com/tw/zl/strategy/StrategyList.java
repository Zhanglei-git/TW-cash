package com.tw.zl.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 打折策略列表
 */
public class StrategyList {
    private static List<StrategyItem> strategyList = new ArrayList<StrategyItem>();
    public static void add(StrategyItem strategyItem){
        strategyList.add(strategyItem);
    }
    public static void remove(StrategyItem strategyItem){
        strategyList.remove(strategyItem);
    }
    public static void clear(){
        strategyList.clear();
    }
    public static StrategyItem get(int index){
        return strategyList.get(index);
    }
    public static int size(){
        return strategyList.size();
    }
    public static Iterator iterator(){
        return strategyList.iterator();
    }
    public static void setStrategyList(List<StrategyItem> strategyList) {
        StrategyList.strategyList = strategyList;
    }
}
