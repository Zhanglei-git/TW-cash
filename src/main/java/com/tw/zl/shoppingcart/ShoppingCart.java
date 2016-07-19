package com.tw.zl.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 16-7-19.
 */
public class ShoppingCart {
    private List<GoodsItem> list = new ArrayList<GoodsItem>();
    private double sumPrice;

    public void addGoods(GoodsItem goodsItem){
        list.add(goodsItem);
    }
    public void removeGoods(GoodsItem goodsItem){
        list.remove(goodsItem);
    }

    public List<GoodsItem> getList() {
        return list;
    }

    public void setList(List<GoodsItem> list) {
        this.list = list;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }
}
