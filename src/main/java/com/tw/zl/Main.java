package com.tw.zl;

import com.tw.zl.common.Goods;
import com.tw.zl.common.GoodsList;
import com.tw.zl.shoppingcart.ShoppingCart;
import com.tw.zl.shoppingcart.ShoppingItem;
import com.tw.zl.strategy.DiscountInfo;
import com.tw.zl.strategy.Strategy;
import com.tw.zl.strategy.StrategyItem;
import com.tw.zl.strategy.StrategyList;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc 收银机
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        ShoppingCart shoppingCart = new ShoppingCart();

        initGoodsList();
        setStrategy(StrategyType.BUY_TWO_GET_ONE_FREE,9,1,true);
        setStrategy(StrategyType.PRICE_95_PERCENT,8,1,true);
        shoppingCart = initShoppingCart();
        Payment payment = new Payment(shoppingCart);
        shoppingCart = payment.calculateAfterAllStrategy();
    }

    /**
     * @desc 模拟总商品清单
     */
    public static void initGoodsList(){
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
    }

    /**
     * @desc 模拟售货员设置优惠策略以及优惠优先级等
     */
    public static void setStrategy(StrategyType strategyType,int priority, int conflictFlag, boolean onlyMe){
        Strategy strategy = StrategyFactory.creatStrategy(strategyType);
        strategy.setStrategyInfoList(getStrategyInfoList(strategyType));
        StrategyItem strategyItem = new StrategyItem(strategy,priority,conflictFlag,onlyMe);
        StrategyList.add(strategyItem);
    }
    public static List getStrategyInfoList(StrategyType strategyType){
        switch(strategyType){
            case BUY_TWO_GET_ONE_FREE:return null;
            case PRICE_95_PERCENT:return getDiscountInfoList();
        }
        return null;
    }
    public static List getDiscountInfoList(){
        DiscountInfo di1 = new DiscountInfo("ITEM000000",9.5);
        DiscountInfo di2 = new DiscountInfo("ITEM000003",9.5);
        List strategyInfoList = new ArrayList();
        strategyInfoList.add(di1);
        strategyInfoList.add(di2);
        return strategyInfoList;
    }

    /**
     *@desc 模拟购物车商品
     * @return ShoppingCart
     */
    public static ShoppingCart initShoppingCart(){
        Goods g1 = new Goods("ITEM000001","羽毛球","个","体育用品","球类",1.00);
        Goods g2 = new Goods("ITEM000003","苹果","斤","食品","水果",5.50);
        Goods g3 = new Goods("ITEM000005","可口可乐","瓶","食品","碳酸饮料",3.00);

        ShoppingCart sc = new ShoppingCart();
        ShoppingItem si1 = new ShoppingItem(g1,5);
        ShoppingItem si2 = new ShoppingItem(g2,2);
        ShoppingItem si3 = new ShoppingItem(g3,3);
        sc.addShoppingItem(si1);
        sc.addShoppingItem(si2);
        sc.addShoppingItem(si3);
        return sc;

    }

}
