import javax.swing.*;
import java.awt.*;

/**
 * This is the Main Frame of the download manager that will be shown...
 */
public class DownloadManagerFrame extends JFrame
{
    private JMenuBar menuBar;
    private JMenu helpMenu;

    private JMenu downloadMenu;
    private JMenuItem newDownloadMenuItem;
    private JMenuItem pauseMenuItem;
    private JMenuItem resumeMenuItem;
    private JMenuItem cancelMenuItem;
    private JMenuItem deleteMenuItem;
    private JMenuItem settingMenuItem;

    private CompletedDownloads completedDownloads;
    private DownloadQueue downloadQueue;

    private JButton newDownloadButton;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton cancelButton;
    private JButton deleteButton;
    private JButton settingButton;



    public DownloadManagerFrame(String name)
    {
        super(name);

        //this is the size of the Main Frame
        setSize(750, 600);

        //if the client click on the exit, the program will go to the system tray
        setDefaultCloseOperation(DownloadManagerFrame.EXIT_ON_CLOSE);

        //put the main frame to the center of the screen
        setLocationRelativeTo(null);

        //set the Layout Manager
        setLayout(new BorderLayout(3, 3));




        Icon newDownloadIcon = new ImageIcon(getClass().getResource("NewDownloadButton.png"));
        newDownloadButton = new JButton("New Download", newDownloadIcon);
        newDownloadButton.setSize(20, 20);
        add(newDownloadButton);
    }

    /**
     * This method will make the Main frame visible to show on the screens.
     */
    public void showFrame()
    {
        setVisible(true);
    }


}
