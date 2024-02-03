package ReaderWriter;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class DataBaseAction {
    private boolean readerInSystem;
    private boolean writerInSystem;
    public DataBaseAction(boolean readerInSystem, boolean writerInSystem) {
        this.readerInSystem = readerInSystem;
        this.writerInSystem = writerInSystem;
    }

    public boolean isReaderInSystem() {
        return readerInSystem;
    }

    public void setReaderInSystem(boolean readerInSystem) {
        this.readerInSystem = readerInSystem;
    }
    public boolean isWriterInSystem() {
        return writerInSystem;
    }

    public void setWriterInSystem(boolean writerInSystem) {
        this.writerInSystem = writerInSystem;
    }
    private BlockingQueue<Thread> queue = new ArrayBlockingQueue<Thread>(10);
    public String padesh(int s) {
        String padesh = null;
        if (s == 1) {
            padesh = " читатель в системе";
        } else if (s > 1 && queue.size() <= 4) {
            padesh = " читателя в системе";
        } else {
            padesh =" читателей в системе";
        }
        return padesh;
    }
    public void read() {
        writerInSystem=false;
        readerInSystem=true;
        try {
            queue.add(Thread.currentThread());
            System.out.println(Thread.currentThread().getId() + " читатель читает");
            System.out.println(queue.size() + padesh(queue.size()) + "\n");
            try {
                Thread.currentThread().sleep( new Random().nextInt(1000, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println("Читатель " + Thread.currentThread().getId() + " закончил читать");
            queue.remove(Thread.currentThread());
            writerInSystem = queue.size()==0?true:false;
            System.out.println(queue.size() + padesh(queue.size()) + "\n");
            try {
                Thread.currentThread().sleep(new Random().nextInt(3000, 4000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
        public synchronized void write() {
        readerInSystem = false;
            try {
                System.out.println(Thread.currentThread().getId() + " писатель пишет");
                System.out.println("В системе 1 писатель и " + queue.size() + " читателей \n");
                writerInSystem=false;
                try {
                    Thread.currentThread().sleep(new Random().nextInt(300, 700));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                writerInSystem = true;
                readerInSystem= true;
                System.out.println("Писатель " + Thread.currentThread().getId() + " закончил писать \n");
            }
        }
    public boolean isLockedRead(){
        return readerInSystem;
    }
    public boolean isLockedWrite(){
        return writerInSystem;
    }
}
