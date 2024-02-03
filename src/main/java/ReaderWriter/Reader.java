package ReaderWriter;

import java.util.Random;

public class Reader implements Runnable{
    DataBaseAction dataBaseAction;
    public Reader(DataBaseAction rw){
        dataBaseAction=rw;
    }
    public void read() {
            if(dataBaseAction.isLockedRead()){
                dataBaseAction.read();
            }else{
                System.out.println(Thread.currentThread().getId()+" читатель ждёт");
                try {
                    Thread.currentThread().sleep(new Random().nextInt(700,1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    @Override
    public void run() {
        while(true){
            read();
    }
}
}

