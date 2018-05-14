import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    private JMenuItem RemoveMenuItem;
    private JMenuItem settingMenuItem;

    private CompletedDownloads completedDownloads;
    private DownloadQueue downloadQueue;

    private JButton newDownloadButton;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton cancelButton;
    private JButton removeButton;
    private JButton settingButton;

    private JPanel buttonPanel;

    private JPanel downloadManagerLogo;

    private JPanel leftSide;

    private JPanel rightSide;



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
        getContentPane().setLayout(new GridLayout(1, 2));


        /*
        This panel is for Logo and the tabs like (Queue and downloadList)
        the first row is for logo
        and the second row is for tabs
         */
        leftSide = new JPanel(new GridLayout(2, 1));



        /*
        This panel contains buttons and also list of the downloads
        the first row is the buttons.
        the second row is for the list and the other things
         */
        rightSide = new JPanel(new GridLayout(2, 1));


        //new the menu bar
        menuBar = new JMenuBar();
        //new the menus that will add to the menu bar and set the Mnemonics
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        downloadMenu = new JMenu("Download");
        downloadMenu.setMnemonic(KeyEvent.VK_D);
        //new the Items of the download menu and set the Mnemonics and tooltips
        newDownloadMenuItem = new JMenuItem("New Download", KeyEvent.VK_N);
        newDownloadMenuItem.setToolTipText("New Download");
        pauseMenuItem = new JMenuItem("Pause", KeyEvent.VK_P);
        pauseMenuItem.setToolTipText("Pause");
        resumeMenuItem = new JMenuItem("Resume", KeyEvent.VK_R);
        resumeMenuItem.setToolTipText("Resume");
        cancelMenuItem = new JMenuItem("Cancel", KeyEvent.VK_C);
        cancelMenuItem.setToolTipText("Cancel");
        RemoveMenuItem = new JMenuItem("Delete", KeyEvent.VK_D);
        RemoveMenuItem.setToolTipText("Delete");
        settingMenuItem = new JMenuItem("Setting", KeyEvent.VK_S);
        settingMenuItem.setToolTipText("Settings");
        //set the Accelerators
        /*helpMenu.setAccelerator();
        downloadMenu.setAccelerator();
        newDownloadMenuItem.setAccelerator();
        pauseMenuItem.setAccelerator();
        resumeMenuItem.setAccelerator();
        cancelMenuItem.setAccelerator();
        RemoveMenuItem.setAccelerator();
        settingMenuItem.setAccelerator();*/
        //add the Items to the download menu
        downloadMenu.add(newDownloadMenuItem);
        downloadMenu.add(pauseMenuItem);
        downloadMenu.add(resumeMenuItem);
        downloadMenu.add(cancelMenuItem);
        downloadMenu.add(RemoveMenuItem);
        downloadMenu.add(settingMenuItem);
        //add the menus to the menu bar
        menuBar.add(downloadMenu);
        menuBar.add(helpMenu);
        //add the menu bar to the frame
        setJMenuBar(menuBar);




        //add the JDM Logo to the Frame
        downloadManagerLogo = new JPanel();
        ImageIcon thisLogo = new ImageIcon(getClass().getResource("logoInFrame.png"));
        JLabel logo = new JLabel(thisLogo);
        downloadManagerLogo.add(logo);
        add(downloadManagerLogo, BorderLayout.WEST);




        //create the panel of the buttons and set the size and location of it
        buttonPanel = new JPanel(new GridLayout(1, 6, 3, 3));
        buttonPanel.setPreferredSize(new Dimension(20, 30));
        //create the newDownload button and set the icon and size
        Icon newDownloadIcon = new ImageIcon(getClass().getResource("newDownloadIcon.png"));
        newDownloadButton = new JButton(newDownloadIcon);
        //create the pause button and set the icon and size
        Icon pauseIcon = new ImageIcon(getClass().getResource("pauseIcon.png"));
        pauseButton = new JButton(pauseIcon);
        //create the resume button and set the icon and size
        Icon resumeIcon = new ImageIcon(getClass().getResource("resumeIcon.png"));
        resumeButton = new JButton(resumeIcon);
        //create the cancel button and set the icon and size
        Icon cancelIcon = new ImageIcon(getClass().getResource("cancelIcon.png"));
        cancelButton = new JButton(cancelIcon);
        //create the remove button and set the icon and size
        Icon removeIcon = new ImageIcon(getClass().getResource("removeIcon.png"));
        removeButton = new JButton(removeIcon);
        //create the setting button and set the icon and size
        Icon settingIcon = new ImageIcon(getClass().getResource("settingIcon.png"));
        settingButton = new JButton(settingIcon);
        //add the buttons to their panel
        buttonPanel.add(newDownloadButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resumeButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(settingButton);
        add(buttonPanel, BorderLayout.NORTH);
    }

    /**
     * This method will make the Main frame visible to show on the screens.
     */
    public void showFrame()
    {
        repaint();
        setVisible(true);
    }


}
