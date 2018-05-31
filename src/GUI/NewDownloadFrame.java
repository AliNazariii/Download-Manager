package GUI;

import Files.DownloadListFile;
import Models.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class NewDownloadFrame extends JFrame
{
    private JPanel frame;

    private JPanel centerPanel;

    private JPanel URLPanel;
    private JLabel URLLabel;
    private JTextField URLField;

    private JPanel pathPanel;
    private JLabel pathLabel;
    private JTextField pathField;

    private JButton fileChooserButton;
    private JFileChooser fileChooser;

    private JPanel queuePanel;
    private JLabel queueOrNotLabel;
    private JCheckBox checkBox;

    private JPanel downPanel;
    private JButton confirmButton;
    private JButton cancelButton;

    private DownloadManager downloadManager;

    public NewDownloadFrame(DownloadManager downloadManager)
    {

        super("New Download");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(NewDownloadFrame.HIDE_ON_CLOSE);

        this.downloadManager = downloadManager;

        frame = new JPanel(new BorderLayout(10, 10));
        frame.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setBackground(Color.decode("#dff8d0"));
        getContentPane().add(frame);

        centerPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        centerPanel.setOpaque(false);
        setURL();
        setPath();
        setQueueOrNot();
        frame.add(centerPanel, BorderLayout.CENTER);

        setDownPanel();
        frame.add(downPanel, BorderLayout.SOUTH);

        getRootPane().setDefaultButton(confirmButton);
        showFrame();
    }

    public void setURL()
    {
        URLPanel = new JPanel(new BorderLayout(23, 5));
        URLPanel.setOpaque(false);

        URLLabel = new JLabel("URL: ");
        URLPanel.add(URLLabel, BorderLayout.WEST);
        URLField = new JTextField();
        URLPanel.add(URLField, BorderLayout.CENTER);

        centerPanel.add(URLPanel);
    }

    public void setPath()
    {
        pathPanel = new JPanel(new BorderLayout(5, 5));
        pathPanel.setOpaque(false);

        pathLabel = new JLabel("Save to: ");
        pathPanel.add(pathLabel, BorderLayout.WEST);
        pathField = new JTextField("C:\\Users\\Ali_Z\\Desktop");
        pathField.setForeground(new Color(89, 89, 89));
        pathPanel.add(pathField, BorderLayout.CENTER);

        Icon fileChooserIcon = new ImageIcon(getClass().getResource("/Icons/fileChooserIcon.png"));
        fileChooserButton = new JButton("Browse", fileChooserIcon);
        fileChooserButton.setForeground(Color.decode("#32363f"));
        fileChooserButton.setFont(new Font("Titillium Web", 4, 20));
        fileChooserButton.addActionListener(new NewDownloadActionListener());
        pathPanel.add(fileChooserButton, BorderLayout.EAST);

        centerPanel.add(pathPanel);
    }

    public void setFileChooserHttp()
    {
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Browse For Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
            pathField.setText(selectedFile.getAbsolutePath());
        }
    }

    public void setQueueOrNot()
    {
        queuePanel = new JPanel(new BorderLayout(5, 5));
        queuePanel.setOpaque(false);

        queueOrNotLabel = new JLabel("add to Queue: ");
        queueOrNotLabel.setOpaque(false);
        queuePanel.add(queueOrNotLabel, BorderLayout.WEST);

        checkBox = new JCheckBox("Yes");
        checkBox.setOpaque(false);
        checkBox.addActionListener(new NewDownloadActionListener());
        queuePanel.add(checkBox, BorderLayout.CENTER);
        centerPanel.add(queuePanel);
    }

    public void setDownPanel()
    {
        downPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        downPanel.setOpaque(false);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new NewDownloadActionListener());
        cancelButton.setForeground(Color.decode("#32363f"));
        cancelButton.setFont(new Font("Titillium Web", 4, 20));
        downPanel.add(cancelButton);
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new NewDownloadActionListener());
        confirmButton.setForeground(Color.decode("#32363f"));
        confirmButton.setFont(new Font("Titillium Web", 4, 20));
        downPanel.add(confirmButton);
    }

    /**
     * I handle the actions here
     */
    public void showFrame()
    {
        //pack();
        repaint();
        setVisible(true);
    }

    private class NewDownloadActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource().equals(fileChooserButton))
            {
                System.out.println("fileChooserButton");
                setFileChooserHttp();
            }
            if (e.getSource().equals(confirmButton))
            {
                System.out.println("confirmButton");
                Download temp = new Download(URLField.getText());
                System.out.println(downloadManager.getDownloadListFile().getDownloadVector().size());
                if (!checkBox.isSelected())
                {
                    downloadManager.getDownloadListFile().getDownloadVector().add(temp);
                    downloadManager.panelGenerator(temp);
                }
                else
                {
                    System.out.println("No Queue");
                }
                //setVisible(false); //you can't see me!
                //DownloadManager.showFrame();
                dispose(); //Destroy the JFrame object
            }
            else if (e.getSource().equals(cancelButton))
            {
                System.out.println("cancelButton");
                //setVisible(false); //you can't see me!
                dispose(); //Destroy the JFrame object
            }
            if (checkBox.isSelected())
            {
                System.out.println("checkBox is Selected");
            }
            else
            {
                System.out.println("Extra Buttons");
            }
        }

    }
}
