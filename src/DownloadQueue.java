import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DownloadQueue extends JPanel
{
    private ArrayList<Download> downloadQueue;

    public DownloadQueue()
    {
        super(new GridLayout(100, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        downloadQueue = new ArrayList<>();

    }

    public void showDownloads()
    {
        for (Download x : downloadQueue)
        {
            add(x);
        }
    }
}
