package ProviderConsumer;

public class Stock {
    private int productStock;
    public int getProductStock() {
        return productStock;
    }
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    public Stock(int productStock) {
        this.productStock = productStock;
    }
    public synchronized void replenishment (int product) {
        productStock+=product;
    }
    public synchronized int replenishment2 (int product) {
        productStock-=product;
        return productStock;
    }

}
