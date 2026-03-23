package constants;

public enum EndPoint {
    STORE("store/"),
    ACCOUNT("account/"),
    CART("cart");
    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
