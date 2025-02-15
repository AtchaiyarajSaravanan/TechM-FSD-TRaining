public class BasicThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
        BasicThreadExample thread = new BasicThreadExample();
        thread.start();
    }
}