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
    public void removeShoppingItem(ShoppingItem shoppingItem) {
        list.remove(shoppingItem);
    }
    public int size(){
        return list.size();
    }
    public  ShoppingItem get(int index){
        return list.get(index);
    }
    public void set(int index,ShoppingItem element){
        list.set(index,element);
    }
    public List<ShoppingItem> getList() {
        return list;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }
}
