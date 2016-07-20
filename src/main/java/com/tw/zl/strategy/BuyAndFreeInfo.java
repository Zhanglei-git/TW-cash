package com.tw.zl.strategy;

/**
 * Created by zl on 16-7-20.
 * @desc 买赠商品信息
 */
public class BuyAndFreeInfo {
    private String barcode;
    private int buyCount;//买几
    private int freeCount;//送几

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public int getFreeCount() {
        return freeCount;
    }

    public void setFreeCount(int freeCount) {
        this.freeCount = freeCount;
    }
}
