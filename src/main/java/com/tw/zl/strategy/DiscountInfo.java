package com.tw.zl.strategy;

/**
 * Created by zl on 16-7-20.
 */
public class DiscountInfo {
    private String barcode;
    private double discount;

    public DiscountInfo(String barcode, double discount) {
        this.barcode = barcode;
        this.discount = discount;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
