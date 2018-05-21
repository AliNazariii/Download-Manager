import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class SettingFrame extends JFrame
{
    private JTabbedPane tabbedPane;

    private JPanel maxSimultaneouslyDownloadPanel;
    private JSpinner spinnerDownloads;

    private JPanel pathPanel;
    private JFileChooser fileChooser;
    private JToggleButton fileChooserButton;
    private JTextField pathField;

//    private JPanel lookAndFeelPanel;
//    private JComboBox lookAndFeelCombo;


    public SettingFrame()
    {
        super("Setting");
        setLayout(new BorderLayout());
        setSize(600, 75);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(SettingFrame.HIDE_ON_CLOSE);

        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        setMaxSimultaneouslyDownload();
        tabbedPane.add("Connection", maxSimultaneouslyDownloadPanel);

        setPathPanel();
        tabbedPane.add("Path", pathPanel);

        //setLookAndFeelPanel();
        //tabbedPane.add("Look and Feel", lookAndFeelPanel);

        add(tabbedPane);

        showFrame();
    }

    public void setMaxSimultaneouslyDownload()
    {
        maxSimultaneouslyDownloadPanel = new JPanel(new BorderLayout());

        JLabel maxSimultaneouslyDownloadLabel = new JLabel("        Maximum of Simultaneously Download");
        maxSimultaneouslyDownloadPanel.add(maxSimultaneouslyDownloadLabel, BorderLayout.CENTER);

        SpinnerModel value = new SpinnerNumberModel(5, 1, 100, 1);
        spinnerDownloads = new JSpinner(value);

        maxSimultaneouslyDownloadPanel.add(spinnerDownloads, BorderLayout.EAST);
    }

    public void setPathPanel()
    {
        pathPanel = new JPanel(new BorderLayout());

        pathField = new JTextField("  C:\\Users\\Ali_Z\\Desktop                                                          ");
        pathField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pathField.setForeground(new Color(89, 89, 89));
        pathPanel.add(pathField, BorderLayout.CENTER);

        Icon fileChooserIcon = new ImageIcon(getClass().getResource("/Icons/fileChooserIcon.png"));
        fileChooserButton = new JToggleButton(fileChooserIcon);
        fileChooserButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        fileChooserButton.setContentAreaFilled(false);
        fileChooserButton.setOpaque(false);
        fileChooserButton.setFocusable(false);
        fileChooserButton.addMouseListener(new SettingMouseHandler());
        pathPanel.add(fileChooserButton, BorderLayout.EAST);
    }

    public void setFileChooser()
    {
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Browse For Folder");
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
        }
    }

    public class SettingMouseHandler extends MouseAdapter
    {//mousePressed
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if (e.getSource().equals(fileChooserButton))
            {
                System.out.println("fileChooserButton");
                setFileChooser();
            }
            else
            {
                System.out.println("H");
            }

        }
    }

    public void showFrame()
    {
        //pack();
        validate();
        repaint();
        setVisible(true);
    }
}
