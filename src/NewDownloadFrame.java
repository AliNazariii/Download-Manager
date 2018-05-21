import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class NewDownloadFrame extends JFrame
{
    private JPanel 
    private JLabel URLLabel;
    private JTextField URLField;

    private JLabel pathLabel;
    private JTextField pathField;

    private JButton fileChooserButton;
    private JFileChooser fileChooser;

    private JButton confirmButton;
    private JButton cancelButton;

    public NewDownloadFrame()
    {
        super("New Download");
        setLayout(new BorderLayout(10, 10));
        setSize(500, 250);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(NewDownloadFrame.HIDE_ON_CLOSE);

        setComponents();
        showFrame();
    }

    public void setComponents()
    {
        URLField = new JTextField();
        URLField.setForeground(new Color(89, 89, 89));

        pathField = new JTextField("C:\\Users\\Ali_Z\\Desktop");
        pathField.setForeground(new Color(89, 89, 89));

        Icon fileChooserIcon = new ImageIcon(getClass().getResource("/Icons/fileChooserIcon.png"));
        fileChooserButton = new JButton(fileChooserIcon);
        fileChooserButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        fileChooserButton.setContentAreaFilled(false);
        fileChooserButton.setOpaque(false);
        fileChooserButton.setFocusable(false);
        fileChooserButton.addMouseListener(new NewDownloadMouseHandler());



    }

    public void setFileChooserHttp()
    {
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Browse For Folder");
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
        }
    }

    /**
     * I handle the actions that happen with Mouse here
    */
    public class NewDownloadMouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if (e.getSource().equals(fileChooserButton))
            {
                System.out.println("fileChooserButtonHttp");
                setFileChooserHttp();
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
