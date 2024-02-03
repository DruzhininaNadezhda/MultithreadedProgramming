package ProviderConsumer;

import ReaderWriter.DataBaseAction;
import ReaderWriter.Reader;
import ReaderWriter.Writer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Открыт новый магазин");
        Stock stock = new Stock(200);
        for (int iа = 0; iа < 10; iа++) {
            ConsumerAction consumerAction = new ConsumerAction(stock);
            consumerAction.start();
            consumerAction.join(700);
        }
        for (int y = 0; y < 2; y++) {
            ProviderAction providerAction = new ProviderAction(stock);
            providerAction.start();
            providerAction.join(500);
        }
    }

    }


