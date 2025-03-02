package org.example.Model;

public class ProductInfo {
    private String productId;
    private String productName;

    public ProductInfo(String productName, String productId) {
        this.productName = productName;
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
