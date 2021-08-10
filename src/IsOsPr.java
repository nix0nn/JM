import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.*;

public class IsOsPr {
    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset());

    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int data = inputStream.read();
        while (data != -1) {
            if ((byte)data % 2 == 0) {
                outputStream.write(data);
            }
            data = inputStream.read();
        }
        outputStream.close();
    }
}
