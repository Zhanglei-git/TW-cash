package com.tw.zl.strategy;

import java.util.*;

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
    public static void sort(){
        Collections.sort(strategyList,comparator );
        for(int i=0;i<strategyList.size();i++){
            System.out.print(strategyList.get(i).getPriority()+"  ");
        }
    }
    public static void setStrategyList(List<StrategyItem> strategyList) {
        StrategyList.strategyList = strategyList;
    }

    private static Comparator<StrategyItem> comparator = new Comparator<StrategyItem>(){
        public int compare(StrategyItem s1, StrategyItem s2) {
            //先排优先级
            if(s1.getPriority()!=s2.getPriority()) {
                return s1.getPriority() - s2.getPriority();
            }
            return 0;
        }
    };

}
