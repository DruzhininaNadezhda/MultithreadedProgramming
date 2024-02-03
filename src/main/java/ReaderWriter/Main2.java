package ReaderWriter;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        DataBaseAction rw = new DataBaseAction(true,true);
       for (int i = 0; i < 7; i++) {
           Writer writer = new Writer(rw);
           Thread writ = new Thread(writer);
           writ.start();
              writ.join(500);

           }
         for (int k = 0; k < 7; k++) {
           Reader reader = new Reader(rw);
               Thread read = new Thread(reader);
              read.start();
             read.join(500);

            }
        }
    }

