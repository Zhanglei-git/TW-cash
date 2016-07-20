package com.tw.zl.strategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 存储策略对应的详细优惠信息
 */
public class StrategyInfoList {
    private List strategyInfoList = new ArrayList();

    public void add(Object o) {
        strategyInfoList.add(o);
    }

    public void remove(Object o) {
        strategyInfoList.remove(o);
    }

    public void clear() {
        strategyInfoList.clear();
    }

}
