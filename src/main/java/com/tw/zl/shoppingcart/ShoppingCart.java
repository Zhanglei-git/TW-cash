package com.tw.zl.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 16-7-19.
 */
public class ShoppingCart {
    private List<ShoppingItem> list = new ArrayList<ShoppingItem>();
    private double sumPrice;

    public void addShoppingItem(ShoppingItem shoppingItem){
        list.add(shoppingItem);
    }
    public void removeShoppingItem(ShoppingItem shoppingItem){
        list.remove(shoppingItem);
    }

    public List<ShoppingItem> getList() {
        return list;
    }

    public void setList(List<ShoppingItem> list) {
        this.list = list;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }
}
