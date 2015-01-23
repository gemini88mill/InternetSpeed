/**
 *  Java Project - InternetSpeed.
 *  This project is used to gauge the average internet speed over
 *  a period of time
 *
 *  Chrono of this program:
 *  Starts program, sends to class DownloadFile()
 *
 * Created by raphael on 1/22/15.
 */
public class ProgramRun {

    /**
     * Starts main program
     * @param args
     */
    public static void main(String[] args){
        //start program
        String url = "http://speedtest.reliableservers.com/10MBtest.bin";

        int MBS = 10;
        double Mbits = MBS * 8;
        double mbitsPerSec = 0;
        double avg = 0;

        DownloadFile downloadFile = new DownloadFile(url);


        for (int x = 0; x < 10; x++) {
            long start = System.currentTimeMillis();
            downloadFile.getwebPage();
            double elapsedTime = System.currentTimeMillis() - start;

            double secsToDownload = elapsedTime / 1000;
            mbitsPerSec = Mbits / secsToDownload;

            System.out.println("Test: "+ (x + 1)  + " " + Mbits / secsToDownload);

            avg = avg + mbitsPerSec;
        }
        System.out.println("Average Connection Speed: " + avg / MBS);
    }
}
