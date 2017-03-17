import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MISKA {
    public static void main(String args []) throws IOException,MimeTypeParseException{
        URL url = new URL("http://lib.ru");
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        String ct = conn.getHeaderField("Content-Type");
        MimeType mt = new MimeType(ct);
        String  cs= mt.getParameter("charset");
        try (InputStream is = conn.getInputStream()){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while (true){
                int c =is.read();
                if (c<0)
                    break;
                bos.write(c);
            }
            System.out.println(bos.toString(cs));
        }
        conn.disconnect();

    }

}
