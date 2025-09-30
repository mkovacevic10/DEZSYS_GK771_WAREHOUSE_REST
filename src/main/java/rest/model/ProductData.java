package rest.model;

public class ProductData {
    private String productID;
    private String productName;
    private String productCategory;
    private int productQuantity;
    private String productUnit;

    public ProductData(String productID, String productName, String productCategory, int productQuantity, String productUnit) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
}
