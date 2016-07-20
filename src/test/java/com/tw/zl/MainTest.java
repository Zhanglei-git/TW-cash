package com.tw.zl;

import com.tw.zl.strategy.DiscountStrategy;
import com.tw.zl.strategy.Strategy;
import com.tw.zl.strategy.StrategyItem;
import com.tw.zl.strategy.StrategyList;
import org.junit.Assert;
import org.junit.Test;

import static com.tw.zl.Main.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple Main.
 */
public class MainTest
{
    @Test
    public void test_staff_set_DiscountStrategy() throws Exception {
        setStrategy(StrategyType.PRICE_95_PERCENT,8,1,true);
        assertTrue(StrategyList.getStrategyList().get(0).getStrategy() instanceof DiscountStrategy);
        assertEquals(8,StrategyList.getStrategyList().get(0).getPriority());
        assertEquals(1,StrategyList.getStrategyList().get(0).getConflictFlag());
        assertTrue(StrategyList.getStrategyList().get(0).isOnlyMe());
    }
}
