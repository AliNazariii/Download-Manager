package Models;

import GUI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class DownloadList extends JPanel
{
    private static Vector<Download> downloadListVector;
    private Vector<JPanel> downloadListPanel;
    private static Vector<Download> deletedDownloadVector;
    private JScrollPane scrollPane;
    public static Download selectedDownload;
    public static JPanel selectedPanel;

    public DownloadList()
    {
        super(new GridLayout(20, 1));
        this.downloadListVector = new Vector<>();
        this.deletedDownloadVector = new Vector<>();
        downloadListPanel = new Vector<>();
        scrollPane = new JScrollPane(this);
        DownloadManager.getRightSide().add(scrollPane, BorderLayout.CENTER);
    }

    public Vector<Download> getDownloadVector()
    {
        return downloadListVector;
    }
    public Vector<Download> getDeletedDownloadVector()
    {
        return deletedDownloadVector;
    }
    public Vector<JPanel> getDownloadListPanel()
    {
        return downloadListPanel;
    }
    public JPanel getSelectedPanel()
    {
        return selectedPanel;
    }
    public Download getSelectedDownload()
    {
        return selectedDownload;
    }
    public void setSelectedDownload(Download input)
    {
        selectedDownload = input;
    }
    public void setSelectedPanel(JPanel input)
    {
        selectedPanel = input;
    }

    public void addDownload(Download input)
    {
        //new Downloader(input);
        downloadListVector.add(input);
        new DownloadPanel(input, this);
    }

    public static void setDownloadListVector(Vector<Download> downloadListVector)
    {
        DownloadList.downloadListVector = downloadListVector;
    }

    /*public void panelGenerator(Download x)
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

        *//*JLabel sizeOfFile = new JLabel(x.getSize());
        sizeOfFile.setFont(new Font("Titillium Web", 4, 12));
        sizeOfFile.setOpaque(false);
        centerOfPanel.add(sizeOfFile, BorderLayout.SOUTH);*//*

        download.add(centerOfPanel, BorderLayout.CENTER);

        download.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                System.out.println("download panel clicked");
                for (JPanel y : downloadListPanel)
                {
                    y.setBackground(Color.decode("#e7effb"));
                }
                download.setBackground(Color.decode("#C0C0C0"));
                selectedDownload = x;
                selectedPanel = download;
            }

            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == MouseEvent.BUTTON3)
                {
                    System.out.println("open download info by right click");
                    new DownloadInfo(DownloadManager.getFrame(), "Download", x);
                }
                else if (e.getClickCount() == 2)
                {
                    try
                    {
                        Desktop.getDesktop().open(new File(x.getPath() + "/" + x.getName()));
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                    System.out.println("Open file by double click");
                }
            }
        });

        downloadListPanel.add(download);
        updatePanel();
        DownloadManager.showFrame();
    }*/

    public void vectorPanelGenerator(Vector<Download> downloadVector)
    {
        for (Download x : downloadVector)
        {
            new DownloadPanel(x, this);
        }
        DownloadManager.showFrame();
    }

    public void actionOnDownload(int input)
    {
        switch (input)
        {
            case 0:
            {
                deletedDownloadVector.add(selectedDownload);
                downloadListVector.remove(selectedDownload);
                downloadListPanel.remove(selectedPanel);
                System.out.println("download deleted");
                updatePanel();
            }
            case 1:
            {
                System.out.println("haah");
            }
        }
    }

    public void updatePanel()
    {
        this.removeAll();
        for (JPanel x : downloadListPanel)
        {
            this.add(x);
        }
        DownloadManager.showFrame();
    }


}