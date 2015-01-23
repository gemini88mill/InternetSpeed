import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * gets on the preset web page and downloads the necessary files
 *
 * Created by raphael on 1/22/15.
 */
public class DownloadFile {

    private String url;
    private String fileName = "file.txt";


    public void getwebPage(){
        String downloadURL = getUrl();


        try {
            URL link = new URL(downloadURL);
            URLConnection conn = link.openConnection();

            InputStream in = conn.getInputStream();
            byte[] buff = new byte[4096];
            int n = -1;

            OutputStream out = new FileOutputStream( fileName );
            while ((n = in.read(buff)) != -1){
                out.write(buff, 0, n);
            }

            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       // System.out.println("done");


    }




    //------------Constructor, Getters and Setters------------------


    public DownloadFile(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
