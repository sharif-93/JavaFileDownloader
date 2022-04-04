import java.util.Scanner;

public class FileDownloaderMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter url: ");
        String url = scanner.nextLine();
        System.out.println("Enter filename: ");
        String filename = scanner.nextLine();
        FileDownloader downloader = new FileDownloader(url, filename);
        Timer timer = new Timer();
        downloader.start();
        timer.start();
        try {
            downloader.join();
            timer.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
