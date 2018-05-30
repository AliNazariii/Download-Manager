package Models;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DownloadList
{
    private JPanel panel;
    private JScrollPane scrollPane;
    private ArrayList<Download> downloadArrayList;

    public DownloadList()
    {
        panel = new JPanel(new GridLayout(20, 1));
        scrollPane = new JScrollPane(panel);
        downloadArrayList = new ArrayList<>();
    }

    public ArrayList<Download> getDownloadArrayList()
    {
        return downloadArrayList;
    }

    public void showDownloads()
    {
        for (Download x : downloadArrayList)
        {
            panel.add(x);
        }
    }

    public JScrollPane getPanel()
    {
        return scrollPane;
    }
}
