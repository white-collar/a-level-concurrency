package thread.and.runnable;

public class ThreadSleepExample {
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        String[] messages = {"While the devil's horns",
                "Minced our tender meat",
                "And so cried the Witcher",
                "He can't be bleat",
                "Toss a coin to your Witcher",
                "Oh, valley of plenty",
                "Oh, valley of plenty, oh",
                "Toss a coin to your Witcher",
                "Oh, valley of plenty};"};

        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());

            for (String message : messages) {
                System.out.println(message);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();
    }

}
