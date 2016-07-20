package com.tw.zl;

import com.tw.zl.common.Goods;
import com.tw.zl.common.GoodsList;
import com.tw.zl.print.OrdinaryPrint;
import com.tw.zl.print.Print;
import com.tw.zl.shoppingcart.ShoppingCart;
import com.tw.zl.shoppingcart.ShoppingItem;
import com.tw.zl.strategy.DiscountStrategy;
import com.tw.zl.strategy.Strategy;
import com.tw.zl.strategy.StrategyItem;
import com.tw.zl.strategy.StrategyList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.tw.zl.Main.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple Main.
 */
public class MainTest
{
//    @Test
//    public void test_initGoodsList() throws Exception {
//        assertEquals(0, GoodsList.size());
//        initGoodsList();
//        assertEquals(6,GoodsList.size());
//
//    }
//
//    @Test
//    public void test_initShoppingCart() throws Exception {
//        ShoppingCart sc = new ShoppingCart();
//        assertEquals(0,sc.size());
//        sc = initShoppingCart();
//        assertEquals(3,sc.size());
//    }
//
//    @Test
//    public void test_staff_set_DiscountStrategy() throws Exception {
//        setStrategy(StrategyType.PRICE_95_PERCENT,8,1,true);
//        assertTrue(StrategyList.get(0).getStrategy() instanceof DiscountStrategy);
//        assertEquals(8,StrategyList.get(0).getPriority());
//        assertEquals(1,StrategyList.get(0).getConflictFlag());
//        assertTrue(StrategyList.get(0).isOnlyMe());
//    }
    ShoppingCart shoppingCart;
    Print print;
    @Before
    public void setUp() throws Exception {
        //初始化总商品
        Goods g1 = new Goods("ITEM000000","雪碧","瓶","食品","碳酸饮料",3.00);
        Goods g2 = new Goods("ITEM000001","羽毛球","个","体育用品","球类",1.00);
        Goods g3 = new Goods("ITEM000002","荔枝","斤","食品","水果",15.00);
        Goods g4 = new Goods("ITEM000003","苹果","斤","食品","水果",5.50);
        Goods g5 = new Goods("ITEM000004","电池","个","生活用品","电器类",2.00);
        Goods g6 = new Goods("ITEM000005","可口可乐","瓶","食品","碳酸饮料",3.00);
        GoodsList.addGoods(g1);
        GoodsList.addGoods(g2);
        GoodsList.addGoods(g3);
        GoodsList.addGoods(g4);
        GoodsList.addGoods(g5);
        GoodsList.addGoods(g6);

        //初始化购物车
        shoppingCart = new ShoppingCart();
        ShoppingItem si1 = new ShoppingItem(g2,5);
        ShoppingItem si2 = new ShoppingItem(g4,2);
        ShoppingItem si3 = new ShoppingItem(g6,3);
        shoppingCart.addShoppingItem(si1);
        shoppingCart.addShoppingItem(si2);
        shoppingCart.addShoppingItem(si3);

        print = new OrdinaryPrint();
    }

    @Test
    public void test_just_buy_PRICE_95_PERCENT() throws Exception {
        StrategyList.clear();
        setStrategy(StrategyType.PRICE_95_PERCENT,8,1,true);
        Payment payment = new Payment(shoppingCart);
        shoppingCart = payment.calculateAfterAllStrategy();
        assertEquals(24.45,shoppingCart.getSumPrice(),0);
        print.print(shoppingCart);
    }

    @Test
    public void test_just_BUY_TWO_GET_ONE_FREE() throws Exception {
        StrategyList.clear();
        setStrategy(StrategyType.BUY_TWO_GET_ONE_FREE,9,1,true);
        Payment payment = new Payment(shoppingCart);
        shoppingCart = payment.calculateAfterAllStrategy();
        assertEquals(21,shoppingCart.getSumPrice(),0);
        print.print(shoppingCart);
    }

    @Test
    public void test_just_general_no_Strategy() throws Exception {
        StrategyList.clear();
        Payment payment = new Payment(shoppingCart);
        shoppingCart = payment.calculateAfterAllStrategy();
        assertEquals(25,shoppingCart.getSumPrice(),0);
        print.print(shoppingCart);
    }

    @Test
    public void test_BUY_TWO_GET_ONE_FREE_and_PRICE_95_PERCENT() throws Exception {
        StrategyList.clear();
        setStrategy(StrategyType.BUY_TWO_GET_ONE_FREE,9,1,true);
        setStrategy(StrategyType.PRICE_95_PERCENT,8,1,true);
        Payment payment = new Payment(shoppingCart);
        shoppingCart = payment.calculateAfterAllStrategy();
        assertEquals(20.45,shoppingCart.getSumPrice(),0);
        print.print(shoppingCart);
    }

}
