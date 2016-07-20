package com.tw.zl.strategy;

import com.tw.zl.shoppingcart.ShoppingCart;
import com.tw.zl.shoppingcart.ShoppingItem;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 实现Strategy接口的打折类方法
 */
public class DiscountStrategy implements Strategy {
    private List<DiscountInfo> disInfoList;

    public void setStrategyInfoList(List strategyInfoList) {
        this.disInfoList =(List<DiscountInfo>) strategyInfoList;
    }

    public ShoppingCart getShoppingCartAfterStrategy(ShoppingCart shoppingCart) {
        for(int i=0;i<shoppingCart.size();i++){
            ShoppingItem si = (ShoppingItem)shoppingCart.get(i);
            if(queryDiscount(si.getGoods().getBarcode())!=1.0){
                si = calculate(si);
                shoppingCart.set(i, si);
                shoppingCart.setSumPrice(shoppingCart.getSumPrice()+si.getSubPriceAfterDiscount());
            }
        }
        return shoppingCart;
    }
    private ShoppingItem calculate(ShoppingItem si){
        double discount = queryDiscount(si.getGoods().getBarcode());
        si.setSubPriceAfterDiscount(si.getGoods().getPrice()*si.getNumber()*discount);
        si.setDiscount(discount);
        return si;
    }
    //查询是否有折扣
    private double queryDiscount(String barcode){
        boolean isFind = false;
        double discount = 1.0;
        if(!"".equals(barcode)&&barcode!=null){
            Iterator it = this.disInfoList.iterator();
            while(it.hasNext()&&(!isFind)){
                DiscountInfo di = (DiscountInfo)it.next();
                if(barcode.equals(di.getBarcode())){
                    isFind = true;
                    discount = di.getDiscount();
                }
            }
        }
        return discount;
    }
}
