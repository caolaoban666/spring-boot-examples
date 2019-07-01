import java.util.concurrent.CountDownLatch;

/**
 * @author cyf
 * @description
 * @create 2019-04-28 9:35
 **/
public class CountDownLatchTest {


    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);
        long start = System.currentTimeMillis();

        CountDownLatchDemo latchDemo = new CountDownLatchDemo(latch);
        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
        }
        long end = System.currentTimeMillis();

        System.out.println("耗时: " + (end - start));
    }


}

class CountDownLatchDemo implements Runnable {

    private CountDownLatch countDownLatch;

    public CountDownLatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }

    }
}
