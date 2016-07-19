package com.tw.zl.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zl on 16-7-19.
 * @desc 测试现有商品信息类
 */
public class TestGoodsList {

    @Before
    public void setUp() throws Exception {
        Goods g1 = new Goods("ITEM000001","可口可乐","瓶","食品","碳酸饮料",3.00);
        Goods g2 = new Goods("ITEM000002","雪碧","瓶","食品","碳酸饮料",3.00);
        Goods g3 = new Goods("ITEM000003","七喜","瓶","食品","碳酸饮料",3.00);
        GoodsList.addGoods(g1);
        GoodsList.addGoods(g2);
        GoodsList.addGoods(g3);

    }

    @Test
    public void testAddGoods() throws Exception {
        assertEquals(3,GoodsList.getGoodsList().size());
    }
}
