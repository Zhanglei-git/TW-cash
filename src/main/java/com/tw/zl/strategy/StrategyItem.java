package com.tw.zl.strategy;

/**
 * Created by zl on 16-7-20.
 * @desc 策略的附加属性，包括策略优先级 冲突标志，冲突时是否独占
 */
public class StrategyItem {
    private Strategy strategy;
    private int priority;
    private int conflictFlag;
    private boolean onlyMe;

    public StrategyItem(Strategy strategy, int priority, int conflictFlag, boolean onlyMe) {
        this.strategy = strategy;
        this.priority = priority;
        this.conflictFlag = conflictFlag;
        this.onlyMe = onlyMe;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getConflictFlag() {
        return conflictFlag;
    }

    public void setConflictFlag(int conflictFlag) {
        this.conflictFlag = conflictFlag;
    }

    public boolean isOnlyMe() {
        return onlyMe;
    }

    public void setOnlyMe(boolean onlyMe) {
        this.onlyMe = onlyMe;
    }
}
