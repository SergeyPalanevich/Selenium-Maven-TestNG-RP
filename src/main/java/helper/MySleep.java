package helper;

public class MySleep {
    public static void mySleep(int sec){
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // need refactoring
    }

}
