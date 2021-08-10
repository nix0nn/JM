import java.io.IOException;
import java.io.InputStream;
public class Is {
    public static void main(String[] args) {

    }

    public static int sumOfStream(InputStream inputStream) throws IOException {
        int data = inputStream.read();
        int sumElements = 0;
        while (data != -1) {
            sumElements += (byte)data;
            data = inputStream.read();
        }
        return sumElements;
    }
}
