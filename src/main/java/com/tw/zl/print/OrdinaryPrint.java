package com.tw.zl.print;

import com.tw.zl.shoppingcart.ShoppingCart;
import com.tw.zl.shoppingcart.ShoppingItem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 16-7-20.
 */
public class OrdinaryPrint implements Print {
    private boolean hasDiscount = false;
    private double orderPrice = 0.0;
    private List<ShoppingItem> list = new ArrayList<ShoppingItem>();
    private DecimalFormat df = new DecimalFormat( "0.00");
    public void print(ShoppingCart shoppingCart) {
        //打印明细
        System.out.println("*<没钱赚商店>购物清单*");
        for(int i=0;i<shoppingCart.size();i++){
            ShoppingItem gi = (ShoppingItem)shoppingCart.get(i);
            if((gi.getSubPriceAfterDiscount()-gi.getGoods().getPrice()*gi.getNumber())==0 || gi.getSubPriceAfterDiscount()%gi.getGoods().getPrice()==0){
                System.out.println("名称："+gi.getGoods().getName()+" 数量："+gi.getNumber()+" 单价："+gi.getGoods().getPrice()+"(元) 小计："+df.format(gi.getSubPriceAfterDiscount()));
                if(gi.getSubPriceAfterDiscount()%gi.getGoods().getPrice()==0&&gi.getSubPriceAfterDiscount()!=gi.getGoods().getPrice()*gi.getNumber()){

                    ShoppingItem si =new ShoppingItem(gi.getGoods(),((gi.getGoods().getPrice()*gi.getNumber()-gi.getSubPriceAfterDiscount())/gi.getGoods().getPrice()));
                    list.add(si);
                }
            }else
            {
                System.out.println("名称："+gi.getGoods().getName()+" 数量："+gi.getNumber()+" 单价："+gi.getGoods().getPrice()+"(元) 小计："+df.format(gi.getSubPriceAfterDiscount())+" 节省："+df.format((gi.getGoods().getPrice()*gi.getNumber()-gi.getSubPriceAfterDiscount())));
            }
            orderPrice+=gi.getGoods().getPrice()*gi.getNumber();
        }
        if(list.size()!=0){
            System.out.println("-----------------------");
            System.out.println("买二赠一商品");
            for(int i=0;i<list.size();i++){
                ShoppingItem si = (ShoppingItem) list.get(i);
                System.out.println("名称："+si.getGoods().getName()+" 数量："+si.getNumber());
            }
        }
        System.out.println("-----------------------");
        System.out.println("总计："+shoppingCart.getSumPrice()+"元");
        if(orderPrice-shoppingCart.getSumPrice()!=0){
            System.out.println("节省："+df.format((orderPrice-shoppingCart.getSumPrice()))+"元");
        }
        System.out.println("************************");
    }
}
