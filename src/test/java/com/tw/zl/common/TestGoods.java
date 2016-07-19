package com.tw.zl.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zl on 16-7-19.
 * @desc 商品信息基类测试类
 */
public class TestGoods {
    Goods goods;
    @Before
    public void setUp() throws Exception {
        goods = new Goods("ITEM000001","可口可乐","瓶","食品","碳酸饮料",3.00);

    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("可口可乐",goods.getName());
    }
}
