package com.vihara.ecommerce_app;

public class HorizontalItemScrollModel {

    private int itemImage;
    private String itemTitle;
    private String itemDescription;
    private String itemPrice;

    public HorizontalItemScrollModel(int itemImage, String itemTitle, String itemDescription, String itemPrice) {
        this.itemImage = itemImage;
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
