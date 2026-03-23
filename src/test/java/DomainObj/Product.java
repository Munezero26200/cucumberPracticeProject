package DomainObj;

public class Product {

    private String productName;

    public Product(String name) {
        this.productName = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
