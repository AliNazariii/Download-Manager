import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class NewDownloadFrame extends JFrame
{
    private JPanel frame;

    private JPanel centerPanel;
    private JLabel URLLabel;
    private JTextField URLField;

    private JLabel pathLabel;
    private JTextField pathField;

    private JButton fileChooserButton;
    private JFileChooser fileChooser;

    private JPanel downPanel;
    private JButton confirmButton;
    private JButton cancelButton;

    public NewDownloadFrame()
    {
        super("New Download");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(NewDownloadFrame.HIDE_ON_CLOSE);

        frame = new JPanel(new BorderLayout(10, 10));
        frame.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setBackground(Color.decode("#dff8d0"));
        getContentPane().add(frame);

        setComponents();
        showFrame();
    }

    public void setComponents()
    {
        centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setOpaque(false);

        URLLabel = new JLabel("URL: ");
        centerPanel.add(URLLabel);
        URLField = new JTextField();
        centerPanel.add(URLField);

        pathLabel = new JLabel("Save to: ");
        centerPanel.add(pathLabel);
        pathField = new JTextField("C:\\Users\\Ali_Z\\Desktop");
        pathField.setForeground(new Color(89, 89, 89));
        centerPanel.add(pathField);

        Icon fileChooserIcon = new ImageIcon(getClass().getResource("/Icons/fileChooserIcon.png"));
        fileChooserButton = new JButton("Browse", fileChooserIcon);
        fileChooserButton.setForeground(Color.decode("#32363f"));
        fileChooserButton.setFont(new Font("Titillium Web", 4, 20));
        fileChooserButton.addActionListener(new NewDownloadActionListener());
        centerPanel.add(fileChooserButton);

        frame.add(centerPanel, BorderLayout.CENTER);

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

        frame.add(downPanel, BorderLayout.SOUTH);
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

    /**
     * I handle the actions here
    */
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
            else if (e.getSource().equals(confirmButton))
            {
                System.out.println("confirmButton");
                Download temp = new Download(URLField.getText());
                DownloadManagerFrame.downloadQueue.getDownloadQueue().add(temp);
                setVisible(false); //you can't see me!
                dispose(); //Destroy the JFrame object
            }
            else if (e.getSource().equals(cancelButton))
            {
                System.out.println("cancelButton");
                setVisible(false); //you can't see me!
                dispose(); //Destroy the JFrame object
            }
            else
            {
                System.out.println("Extra Buttons");
            }
        }
    }

    public void showFrame()
    {
        //pack();
        repaint();
        setVisible(true);
    }
}
