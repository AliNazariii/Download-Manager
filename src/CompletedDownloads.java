import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CompletedDownloads extends JPanel
{
    private ArrayList<Download> completedDownloads;

    public CompletedDownloads()
    {
        super(new GridLayout(10, 1));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        completedDownloads = new ArrayList<>();
    }

    public ArrayList<Download> getCompletedDownloads()
    {
        return completedDownloads;
    }

    public void showDownloads()
    {
        for (Download x : completedDownloads)
        {
            add(x);
        }
    }
}
