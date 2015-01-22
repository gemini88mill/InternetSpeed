/**
 * Created by raphael on 1/22/15.
 */
public class ProgramRun {

    public static void main(String[] args){
        //start program
        String url = "http://speedtest.reliableservers.com/10MBtest.bin";

        int MBS = 10;
        double Mbits = MBS * 8;

        DownloadFile downloadFile = new DownloadFile(url);

        long start = System.currentTimeMillis();
        downloadFile.getwebPage();
        double elapsedTime = System.currentTimeMillis() - start;

        double secsToDownload = elapsedTime / 1000;

        System.out.println(Mbits / secsToDownload );

    }
}
