package com.tw.zl.strategy;

import com.tw.zl.shoppingcart.ShoppingCart;
import com.tw.zl.shoppingcart.ShoppingItem;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zl on 16-7-20.
 * @desc 买二赠一优惠策略
 */
public class BuyAndFreeStrategy implements Strategy{
    List<BuyAndFreeInfo> strategyInfoList;

    public ShoppingCart getShoppingCartAfterStrategy(ShoppingCart shoppingCart) {
        for(int i=0;i<shoppingCart.size();i++) {
            ShoppingItem si = (ShoppingItem) shoppingCart.get(i);
            si = calculate(si);
            shoppingCart.set(i,si);
            shoppingCart.setSumPrice(shoppingCart.getSumPrice()+si.getSubPriceAfterDiscount());
        }
        return shoppingCart;
    }

    public void setStrategyInfoList(List strategyInfoList) {
        this.strategyInfoList = (List<BuyAndFreeInfo>) strategyInfoList;
    }
    private ShoppingItem calculate(ShoppingItem shoppingItem){
        BuyAndFreeInfo bfi;
        bfi = queryBuyAndFree(shoppingItem.getGoods().getBarcode());
        int count = 1;
        for(int i=1;i<=shoppingItem.getNumber();i++){
            shoppingItem.setSubPriceAfterDiscount(shoppingItem.getGoods().getPrice());
            if(count==bfi.getBuyCount()){
                i+=bfi.getFreeCount();
                count=1;
            }else{
                count++;
            }
        }
        return shoppingItem;
    }
    private BuyAndFreeInfo queryBuyAndFree(String barCode){
        BuyAndFreeInfo bfi;
        boolean isFind = false;
        if(!"".equals(barCode)&&barCode!=null){
            Iterator it = this.strategyInfoList.iterator();
            while(it.hasNext()&&(!isFind)){
                bfi = (BuyAndFreeInfo) it.next();
                if(barCode.equals(bfi.getBarcode())){
                    isFind = true;
                    return bfi;
                }
            }
        }
        return null;
    }


}
