import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class IsOsCharacter {

    public static void main(String[] args) throws IOException {
        Charset charset = Charset.defaultCharset();
        byte[] arr = new byte[]{48, 49, 50, 51};

        InputStream inputStream = new ByteArrayInputStream(arr);

        System.out.println(readAsString(inputStream, charset));

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int data = reader.read();
        StringBuilder result = new StringBuilder();

        while (data != -1) {
            result.append((char)data);
            data = reader.read();
        }

        return String.valueOf(result);
    }
}
