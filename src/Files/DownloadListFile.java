package Files;

import Models.*;

import java.io.Serializable;
import java.util.Vector;

public class DownloadListFile implements Serializable
{
    private static Vector<Download> downloadVector;

    public DownloadListFile()
    {
        downloadVector = new Vector<>();
    }

    public Vector<Download> getDownloadVector()
    {
        return downloadVector;
    }

    public static void setDownloadVector(Vector<Download> downloadVector)
    {
        DownloadListFile.downloadVector = downloadVector;
    }
}
