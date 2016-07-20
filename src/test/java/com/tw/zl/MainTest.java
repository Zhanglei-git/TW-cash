package com.tw.zl;

import com.tw.zl.common.Goods;
import com.tw.zl.common.GoodsList;
import com.tw.zl.shoppingcart.ShoppingCart;
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
    public void test_initGoodsList() throws Exception {
        assertEquals(0, GoodsList.size());
        initGoodsList();
        assertEquals(6,GoodsList.size());

    }

    @Test
    public void test_initShoppingCart() throws Exception {
        ShoppingCart sc = new ShoppingCart();
        assertEquals(0,sc.size());
        sc = initShoppingCart();
        assertEquals(3,sc.size());
    }

    @Test
    public void test_staff_set_DiscountStrategy() throws Exception {
        setStrategy(StrategyType.PRICE_95_PERCENT,8,1,true);
        assertTrue(StrategyList.get(0).getStrategy() instanceof DiscountStrategy);
        assertEquals(8,StrategyList.get(0).getPriority());
        assertEquals(1,StrategyList.get(0).getConflictFlag());
        assertTrue(StrategyList.get(0).isOnlyMe());
    }

    @Test
    public void test_just_buy_PRICE_95_PERCENT() throws Exception {
        GoodsList.clear();
        StrategyList.clear();
        ShoppingCart shoppingCart = new ShoppingCart();
        initGoodsList();
        setStrategy(StrategyType.PRICE_95_PERCENT,8,1,true);
        shoppingCart = initShoppingCart();
        Payment payment = new Payment(shoppingCart);
        shoppingCart = payment.calculateAfterAllStrategy();
        assertEquals(24.45,shoppingCart.getSumPrice(),0.0001);
    }
}
