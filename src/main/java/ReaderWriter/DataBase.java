package ReaderWriter;

public class DataBase {
    private boolean connect;

    public synchronized boolean getConnect() {
        return connect;
    }

    public void setConnect(boolean connect) {
        this.connect = connect;
    }
}
