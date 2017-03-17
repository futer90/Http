import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Somin {
public  static void  main(String args []) throws IOException{
    CloseableHttpClient client = HttpClients.createDefault();
    HttpGet get = new HttpGet("http://lib.ru");
    try (CloseableHttpResponse resp = client.execute(get)){
        String html= EntityUtils.toString(resp.getEntity());
        Pattern p = Pattern.compile("http://\\S+");
        Matcher m = p.matcher(html);
        while (m.find()){
            System.out.println(m.group());
        }
    }
    client.close();

}
}
