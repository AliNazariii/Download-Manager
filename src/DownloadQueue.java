import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DownloadQueue extends JPanel
{
    private ArrayList<Download> downloadQueue;

    public DownloadQueue()
    {
        super(new GridLayout(10, 1));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        downloadQueue = new ArrayList<>();
    }

    public ArrayList<Download> getDownloadQueue()
    {
        return downloadQueue;
    }

    public void showDownloads()
    {
        for (Download x : downloadQueue)
        {
            add(x);
        }
    }
}
