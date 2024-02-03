package ProviderConsumer;
import java.util.Random;
public class ProviderAction extends Thread {
    private Stock stock;
    private Provider provider;
    public ProviderAction(Stock stock) {
        this.stock = stock;
    }
    public void shipment() throws InterruptedException {
        int product = new Random().nextInt(1, 100);
            System.out.println(" \n Продавец " + Thread.currentThread().getId() + " привёз " + product + " единиц товара");
            System.out.println("На складе стало " + stock.getProductStock() + "+" + product + "="+ (stock.getProductStock() + product) + " единиц товара");
            stock.replenishment(product);
            System.out.println("Продавец " + Thread.currentThread().getId() + " поехал за новым товаром");
            providerSleep(new Random().nextInt(1000, 2000));
    }
    private void providerSleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                shipment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
