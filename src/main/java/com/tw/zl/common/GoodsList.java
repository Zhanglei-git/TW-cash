package com.tw.zl.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 16-7-19.
 * @desc 现有商品信息列表
 */
public class GoodsList {
    private static List<Goods> goodsList = new ArrayList<Goods>();

    public static void addGoods(Goods goods){
        goodsList.add(goods);
    }
    public static void removeGoods(Goods good){
        goodsList.remove(good);
    }
    public static List<Goods> getGoodsList() {
        return goodsList;
    }

    public static void setGoodsList(List<Goods> goodsList) {
        GoodsList.goodsList = goodsList;
    }
}
