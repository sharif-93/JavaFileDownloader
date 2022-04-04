import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileDownloader extends Thread {
    private String url;
    private String filename;

    public FileDownloader(String url, String filename) {
        this.url = url;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            URL fileUrl = new URL(url);
            URLConnection connection = fileUrl.openConnection();
            InputStream inputStream = connection.getInputStream();
            File file = new File(filename);
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            inputStream.close();
        } catch (IOException ex) {
            System.err.println("Failed to download file: " + ex.getMessage());
        }
    }

}
