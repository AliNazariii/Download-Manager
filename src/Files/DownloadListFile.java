package Files;

import Models.*;

import java.io.Serializable;
import java.util.Vector;

public class DownloadListFile implements Serializable
{
    private static Vector<Download> downloadVector;

    public static void addDownload(Download input)
    {
        downloadVector.add(input);
    }

    public Vector<Download> getDownloadVector()
    {
        return downloadVector;
    }
}
