package Models;

import GUI.DownloadManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;


public class DownloadList
{
    private static Vector<Download> downloadListVector;
    private JPanel downloadPanel;

    public DownloadList()
    {
        downloadListVector = new Vector<>();
    }

    public Vector<Download> getDownloadVector()
    {
        return downloadListVector;
    }

    public void addDownload(Download input)
    {
        downloadListVector.add(input);
        vectorPanelGenerator(downloadListVector);
    }

    public static void setDownloadListVector(Vector<Download> downloadListVector)
    {
        DownloadList.downloadListVector = downloadListVector;
    }

    public void panelGenerator(Download x)
    {
        JPanel download = new JPanel(new BorderLayout());
        download.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 10));
        download.setBackground(Color.decode("#e7effb"));

        JPanel eagleGetLogo = new JPanel();
        ImageIcon eagleIcon = new ImageIcon(getClass().getResource("/Icons/eagleIcon.png"));
        JLabel eagle = new JLabel(eagleIcon);
        eagleGetLogo.add(eagle);
        eagleGetLogo.setOpaque(false);
        download.add(eagleGetLogo, BorderLayout.WEST);

        download.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                System.out.println("download panel clicked");
                /*for (Download x : downloadList.getDownloadVector())
                {
                    x.setBackground(Color.decode("#e7effb"));
                }*/
                download.setBackground(Color.decode("#ecbf7e"));
            }
            /*@Override
            public void mouseEntered(MouseEvent e)
            {
                System.out.println("enter download panel");
                setBackground(Color.decode("#c3c1be"));
            }
            @Override
            public void mouseExited(MouseEvent e)
            {
                System.out.println("exit download panel");
                setBackground(Color.decode("#e7effb"));
            }*/
        });


        JPanel centerOfPanel = new JPanel(new BorderLayout());
        centerOfPanel.setOpaque(false);

        JLabel nameOfFile = new JLabel(x.getName());
        nameOfFile.setFont(new Font("Titillium Web", 4, 12));
        nameOfFile.setOpaque(false);
        centerOfPanel.add(nameOfFile, BorderLayout.NORTH);

        JProgressBar progressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.decode("#018f99"));
        centerOfPanel.add(progressBar, BorderLayout.CENTER);

        /*JLabel sizeOfFile = new JLabel(x.getSize());
        sizeOfFile.setFont(new Font("Titillium Web", 4, 12));
        sizeOfFile.setOpaque(false);
        centerOfPanel.add(sizeOfFile, BorderLayout.SOUTH);*/

        download.add(centerOfPanel, BorderLayout.CENTER);

        downloadPanel.add(download);
    }

    public void vectorPanelGenerator(Vector<Download> downloadVector)
    {
        downloadPanel = new JPanel(new GridLayout(20, 1));
        for (Download x : downloadVector)
        {
            panelGenerator(x);
        }
        DownloadManager.setDownloadPanel(downloadPanel);
        DownloadManager.showFrame();
    }
}
