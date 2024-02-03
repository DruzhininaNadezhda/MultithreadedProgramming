package ProviderConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class ConsumerAction extends Thread {
    private Consumer consumer;
    List <String> random = Arrays.asList(" куда-то уехал и не заплатил"," заплатил и куда-то уехал");
    String payment = random.get(new Random().nextInt(random.size()));
    private Stock stock;
    public ConsumerAction( Stock stock) {
        this.stock = stock;
    }
    public void shipment() {
        int product = new Random().nextInt(1, 100);
        System.out.println("\n Покупатель " + Thread.currentThread().getId() + " хочет забрать " + product + " единиц товара");
        if (stock.getProductStock() > product) {
            System.out.println("На складе осталось " + stock.getProductStock() + "-" + product + "="+ (stock.getProductStock() - product) + " единиц товара");
            stock.replenishment2(product);
            System.out.println("Покупатель " + Thread.currentThread().getId() + payment);
            consumerSleep(new Random().nextInt(3000, 5000));
        } else {
            System.out.println("Покупатель " + Thread.currentThread().getId() + " ожидает пополнение склада");
            consumerSleep(new Random().nextInt(3000, 5000));
        }
    }
    private void consumerSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        while (true) {
                shipment();
        }
    }
}
