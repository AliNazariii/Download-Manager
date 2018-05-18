import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CompletedDownloads extends JPanel
{
    private ArrayList<Download> completedDownloads;

    public CompletedDownloads()
    {
        super(new GridLayout(100, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        completedDownloads = new ArrayList<>();
    }

    public void showDownloads()
    {
        for (Download x : completedDownloads)
        {
            add(x);
        }
    }
}
