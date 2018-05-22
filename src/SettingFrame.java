import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class SettingFrame extends JFrame
{
    private JPanel superPanel;

    private JPanel centerPanel;

    private JPanel maxPanel;
    private JLabel maxSimultaneouslyDownloadLabel;
    private JSpinner spinnerDownloads;

    private JPanel pathPanel;
    private JLabel pathLabel;
    private JTextField pathField;
    private JFileChooser fileChooser;
    private JButton fileChooserButton;

    private JPanel downPanel;
    private JButton cancelButton;
    private JButton confirmButton;

    private JPanel lookAndFeelPanel;
    private JLabel lookAndFeelLabel;
    private JSpinner lookAndFeelSpinner;


    public SettingFrame()
    {
        super("Setting");
        setSize(700, 230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(SettingFrame.HIDE_ON_CLOSE);

        superPanel = new JPanel(new BorderLayout(10, 10));
        superPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        superPanel.setBackground(Color.decode("#dff8d0"));

        centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        centerPanel.setOpaque(false);
        setMaxSimultaneouslyDownload();
        setPathPanel();

        lookAndFeelPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        lookAndFeelPanel.setOpaque(false);
        lookAndFeel();
        centerPanel.add(lookAndFeelPanel);

        superPanel.add(centerPanel, BorderLayout.CENTER);

        downPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        downPanel.setOpaque(false);
        buttons();
        superPanel.add(downPanel, BorderLayout.SOUTH);

        getContentPane().add(superPanel);
        showFrame();
    }

    public void setMaxSimultaneouslyDownload()
    {
        maxPanel = new JPanel(new BorderLayout());
        maxPanel.setOpaque(false);
        maxSimultaneouslyDownloadLabel = new JLabel("Maximum of Simultaneously Download: ");
        maxPanel.add(maxSimultaneouslyDownloadLabel, BorderLayout.CENTER);

        SpinnerModel numberModel = new SpinnerNumberModel(5, 1, 100, 1);
        spinnerDownloads = new JSpinner(numberModel);
        maxPanel.add(spinnerDownloads, BorderLayout.EAST);

        centerPanel.add(maxPanel);
    }

    public void setPathPanel()
    {
        pathPanel = new JPanel(new BorderLayout(10, 10));
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
        fileChooserButton.addActionListener(new SettingActionListener());
        pathPanel.add(fileChooserButton, BorderLayout.EAST);

        centerPanel.add(pathPanel);
    }

    public void lookAndFeel()
    {
        lookAndFeelLabel = new JLabel("Look and Feel: ");
        lookAndFeelPanel.add(lookAndFeelLabel, BorderLayout.CENTER);

        String[] LFs = {"Metal", "Nimbus", "CDE/Motif", "Windows", "Windows Classic"};
        SpinnerModel nameModel = new SpinnerListModel(LFs);
        spinnerDownloads = new JSpinner(nameModel);
        lookAndFeelPanel.add(spinnerDownloads, BorderLayout.EAST);
    }

    public void buttons()
    {
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new SettingActionListener());
        cancelButton.setForeground(Color.decode("#32363f"));
        cancelButton.setFont(new Font("Titillium Web", 4, 20));
        downPanel.add(cancelButton);
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new SettingActionListener());
        confirmButton.setForeground(Color.decode("#32363f"));
        confirmButton.setFont(new Font("Titillium Web", 4, 20));
        downPanel.add(confirmButton);
    }
    public void setFileChooser()
    {
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Browse For Folder ");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
            pathField.setText(selectedFile.getAbsolutePath());
        }
    }

    public class SettingActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource().equals(fileChooserButton))
            {
                System.out.println("fileChooserButton");
                setFileChooser();
            }
            else if (e.getSource().equals(confirmButton))
            {
                System.out.println("confirmButton");
            }
            else if (e.getSource().equals(cancelButton))
            {
                System.out.println("cancelButton");
                setVisible(false); //you can't see me!
                dispose(); //Destroy the JFrame object
            }
            /*else if (e.getSource().equals(metalLF))
            {
                System.out.println("Metal Look&Feel");
                try
                {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(DownloadManagerFrame);
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                catch (InstantiationException e1)
                {
                    e1.printStackTrace();
                }
                catch (IllegalAccessException e1)
                {
                    e1.printStackTrace();
                }
                catch (UnsupportedLookAndFeelException e1)
                {
                    e1.printStackTrace();
                }
                showFrame();
            }
            //Listener of the Nimbus
            else if (e.getSource().equals(nimbusLF))
            {
                System.out.println("Nimbus Motif");
                try
                {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    setUI();
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                catch (InstantiationException e1)
                {
                    e1.printStackTrace();
                }
                catch (IllegalAccessException e1)
                {
                    e1.printStackTrace();
                }
                catch (UnsupportedLookAndFeelException e1)
                {
                    e1.printStackTrace();
                }
                showFrame();
            }
            //Listener of the Motif
            else if (e.getSource().equals(CdeLF))
            {
                System.out.println("Motif Look&Feel");
                try
                {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    setUI();
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                catch (InstantiationException e1)
                {
                    e1.printStackTrace();
                }
                catch (IllegalAccessException e1)
                {
                    e1.printStackTrace();
                }
                catch (UnsupportedLookAndFeelException e1)
                {
                    e1.printStackTrace();
                }
                showFrame();
            }
            //Listener of the Windows
            else if (e.getSource().equals(windowsLF))
            {
                System.out.println("Windows Look&Feel");
                try
                {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    setUI();
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                catch (InstantiationException e1)
                {
                    e1.printStackTrace();
                }
                catch (IllegalAccessException e1)
                {
                    e1.printStackTrace();
                }
                catch (UnsupportedLookAndFeelException e1)
                {
                    e1.printStackTrace();
                }
                showFrame();
            }
            //Listener of the Windows Classic
            else if (e.getSource().equals(windowsClassicLF))
            {
                System.out.println("windows Classic Look&Feel");
                try
                {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    setUI();
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                catch (InstantiationException e1)
                {
                    e1.printStackTrace();
                }
                catch (IllegalAccessException e1)
                {
                    e1.printStackTrace();
                }
                catch (UnsupportedLookAndFeelException e1)
                {
                    e1.printStackTrace();
                }
                showFrame();
            else
            {
                System.out.println("H");
            }*/
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
