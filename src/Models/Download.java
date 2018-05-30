package Models;

import Files.*;
import java.io.Serializable;
import java.util.*;

public class Download implements Serializable
{
    private String name;
    //public JProgressBar progressBar;
    private String size;
    //private String speed;
    private String URL;
    private String path;
    private Date startLabel;

    public Download(String URL)
    {
        this.URL = URL;

        DownloadListFile.addDownload(this);
    }

    public String getName()
    {
        return name;
    }
    public String getSize()
    {
        return size;
    }
    public String getPath()
    {
        return path;
    }
    public String getURL()
    {
        return URL;
    }
}
