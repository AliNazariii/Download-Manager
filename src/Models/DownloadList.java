package Models;

import GUI.DownloadInfo;
import GUI.DownloadManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;


public class DownloadList
{
    private static Vector<Download> downloadListVector;
    private static JPanel downloadPanel;
    private JScrollPane scrollPane;
    public static Download selectedDownload;

    public DownloadList()
    {
        downloadListVector = new Vector<>();
        downloadPanel = new JPanel(new GridLayout(20, 1));
        scrollPane = new JScrollPane(downloadPanel);
        /*downloadPanel.removeAll();
        downloadPanel.revalidate();
        downloadPanel.repaint();*/
        DownloadManager.getRightSide().add(scrollPane, BorderLayout.CENTER);
    }

    public Vector<Download> getDownloadVector()
    {
        return downloadListVector;
    }

    public void addDownload(Download input)
    {
        downloadListVector.add(input);
        panelGenerator(input);
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
                for (Component y : downloadPanel.getComponents())
                {
                    y.setBackground(Color.decode("#e7effb"));
                }
                download.setBackground(Color.decode("#C0C0C0"));
                selectedDownload = x;
            }

            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == MouseEvent.BUTTON3)
                {
                    System.out.println("open download info by right click");
                    new DownloadInfo(DownloadManager.getFrame(), "Download", x);
                } else if (e.getClickCount() == 2)
                {
                    System.out.println("Open file by double click");
                }
            }
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
        DownloadManager.showFrame();
    }

    public JPanel getDownloadPanel()
    {
        return downloadPanel;
    }

    public void vectorPanelGenerator(Vector<Download> downloadVector)
    {
        for (Download x : downloadVector)
        {
            panelGenerator(x);
        }
        DownloadManager.showFrame();
    }

    public void actionOnDownload(int input)
    {
        switch (input)
        {
            case 0:
            {
                /*System.out.println(downloadListVector.size());
                downloadListVector.remove(selectedDownload);
                downloadPanel = new JPanel(new GridLayout(20, 1));
                scrollPane = new JScrollPane(downloadPanel);
                vectorPanelGenerator(downloadListVector);
                System.out.println(downloadListVector.size());
                //downloadPanel.remove(downloadListVector.indexOf(selectedDownload));
                DownloadManager.showFrame();*/
                System.out.println("yes");
            }
            case 1:
            {
                System.out.println("haah");
            }
        }
    }


}