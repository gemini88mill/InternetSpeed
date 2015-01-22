import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * gets on the internet and downloads the necessary files
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
            byte[] buff = new byte[1024];
            int n = -1;

            OutputStream out = new FileOutputStream( fileName );
            while ((n = in.read(buff)) != -1){
                out.write(buff, 0, n);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("done");


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
