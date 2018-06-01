package Models;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static jdk.nashorn.internal.objects.NativeError.getFileName;

public class Downloader extends Thread
{
    private URL url;
    private String path;

    public Downloader(Download input)
    {
        try
        {
            this.url = new URL(input.getURL());
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        path = input.getPath();
        setFileName(input);
        start();
    }

    public void setFileName(Download input)
    {
        String fileName = url.getFile();
        input.setName(fileName.substring(fileName.lastIndexOf('/') + 1));
    }

    public String getFileName(URL url)
    {
        String fileName = url.getFile();
        return fileName.substring(fileName.lastIndexOf('/') + 1);
    }

    @Override
    public void run()
    {
        HttpURLConnection connection;
        try
        {
            if ("http".equals(url.getProtocol()))
            {
                connection = (HttpURLConnection) url.openConnection();
            }
            else if ("https".equals(url.getProtocol()))
            {
                connection = (HttpsURLConnection) url.openConnection();
            }
            else
            {
                System.err.println("UnSupported Protocol!");
                return;
            }
            connection.connect();

            //make sure response code is in the 200 range
            if (connection.getResponseCode() / 100 != 2)
            {
                throw new IOException(connection.getResponseCode() + "");
            }
        }
        catch (IOException ex)
        {
            System.err.println("Failed To Open Connection!" + ex);
            return;
        }

        File file = new File(path + "/" + getFileName(url));
        long contentLength = connection.getContentLength();
        System.out.println("Content Length = " + contentLength);

        try (InputStream in = connection.getInputStream(); FileOutputStream out = new FileOutputStream(file))
        {
            int totalRead = 0;
            byte[] buffer = new byte[10_000];
            while (totalRead < contentLength)
            {
                int read = in.read(buffer);
                if (read == -1)
                {
                    break;
                }
                out.write(buffer, 0, read);
                totalRead += read;
            }
            System.out.println("Download Finished.");
        }
        catch (IOException ex)
        {
            System.err.println("Download Destroyed!");
        }
    }
}
