package com.tw.zl.shoppingcart;

import com.tw.zl.common.Goods;

/**
 * Created by zl on 16-7-19.
 * @desc 购物车中商品项目信息
 */
public class GoodsItem {
    private Goods goods;
    private double number;
    private double discount;
    private double subPriceAfterDiscount;

    public GoodsItem(Goods goods, double number) {
        this.goods = goods;
        this.number = number;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubPriceAfterDiscount() {
        return subPriceAfterDiscount;
    }

    public void setSubPriceAfterDiscount(double subPriceAfterDiscount) {
        this.subPriceAfterDiscount = subPriceAfterDiscount;
    }
}
