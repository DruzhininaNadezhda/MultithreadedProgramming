package ReaderWriter;
import java.util.Random;
public class Writer implements Runnable {
    private DataBaseAction dataBaseAction;
    public Writer(DataBaseAction dataBase){
        dataBaseAction=dataBase;
    }
    public synchronized void write() throws InterruptedException {
        if(dataBaseAction.isLockedWrite()){
        dataBaseAction.write();
            Thread.currentThread().sleep(new Random().nextInt(700, 1000));
            }else{
        System.out.println(Thread.currentThread().getId()+" писатель ждёт");
        try {
            Thread.currentThread().sleep(new Random().nextInt(700, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }
    }
    @Override
    public void run() {
        while(true) {
            try {
                write();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
