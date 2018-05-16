import javafx.scene.control.ToolBar;

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


    private JToolBar toolBar;
    private JButton newDownloadButton;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton cancelButton;
    private JButton sortButton;
    private JButton removeButton;
    private JButton videoSnifferButton;
    private JButton mediaGrabberButton;
    private JButton batchDownloadButton;
    private JButton settingButton;
    private JTextField filterFilesTextField;


    private JPanel downloadManagerLogo;

    private JPanel leftSide;
    private JPanel rightSide;



    public DownloadManagerFrame(String name)
    {
        super(name);

        //this is the size of the Main Frame
        setSize(800, 600);
        //if the client click on the exit, the program will go to the system tray
        setDefaultCloseOperation(DownloadManagerFrame.EXIT_ON_CLOSE);
        //put the main frame to the center of the screen
        setLocationRelativeTo(null);
        //set the Layout Manager
        getContentPane().setLayout(new BorderLayout());



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



        /*
        This panel is for Logo and the tabs like (Queue and downloadList)
        the first row is for logo
        and the second row is for tabs
         */
        leftSide = new JPanel(new BorderLayout());
        leftSide.setBackground(new Color(50, 54, 63));


        //add the JDM Logo to the Frame
        downloadManagerLogo = new JPanel();
        ImageIcon thisLogo = new ImageIcon(getClass().getResource("logoInFrame.png"));
        JLabel logo = new JLabel(thisLogo);
        downloadManagerLogo.add(logo);
        //use transparent of the picture not to show the white background under the eagle
        downloadManagerLogo.setOpaque(false);
        leftSide.add(downloadManagerLogo, BorderLayout.NORTH);

        add(leftSide, BorderLayout.WEST);



        /*
        This panel contains buttons and also list of the downloads
        the first row is the buttons.
        the second row is for the list and the other things
         */
        rightSide = new JPanel(new BorderLayout());
        rightSide.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //rightSide.setBackground(Color.RGBtoHSB(50, 54, 63, 222));


        //create the toolbar of the buttons and avoid being floating
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        //create the newDownload button and set the icon
        Icon newDownloadIcon = new ImageIcon(getClass().getResource("newDownloadIcon.png"));
        newDownloadButton = new JButton(newDownloadIcon);
        newDownloadButton.setFocusable(false);
        //create the pause button and set the icon
        Icon pauseIcon = new ImageIcon(getClass().getResource("pauseIcon.png"));
        pauseButton = new JButton(pauseIcon);
        pauseButton.setFocusable(false);
        //create the resume button and set the icon
        Icon resumeIcon = new ImageIcon(getClass().getResource("resumeIcon.png"));
        resumeButton = new JButton(resumeIcon);
        resumeButton.setFocusable(false);
        //create the cancel button and set the icon
        Icon cancelIcon = new ImageIcon(getClass().getResource("cancelIcon.png"));
        cancelButton = new JButton(cancelIcon);
        cancelButton.setFocusable(false);
        //create the sort button and set the icon
        Icon sortIcon = new ImageIcon(getClass().getResource("sortIcon.png"));
        sortButton = new JButton(sortIcon);
        sortButton.setFocusable(false);
        //create the remove button and set the icon
        Icon removeIcon = new ImageIcon(getClass().getResource("removeIcon.png"));
        removeButton = new JButton(removeIcon);
        removeButton.setFocusable(false);
        //create the videoSniffer button and set the icon
        Icon videoSnifferIcon = new ImageIcon(getClass().getResource("videoSnifferIcon.png"));
        videoSnifferButton = new JButton(videoSnifferIcon);
        videoSnifferButton.setFocusable(false);
        //create the mediaGrabber button and set the icon
        Icon mediaGrabberIcon = new ImageIcon(getClass().getResource("mediaGrabberIcon.png"));
        mediaGrabberButton = new JButton(mediaGrabberIcon);
        mediaGrabberButton.setFocusable(false);
        //create the batchDownload button and set the icon
        Icon batchDownloadIcon = new ImageIcon(getClass().getResource("batchDownloadIcon.png"));
        batchDownloadButton = new JButton(batchDownloadIcon);
        batchDownloadButton.setFocusable(false);
        //create the setting button and set the icon
        Icon settingIcon = new ImageIcon(getClass().getResource("settingIcon.png"));
        settingButton = new JButton(settingIcon);
        settingButton.setFocusable(false);
        //textfield for filtering files by searching words
        filterFilesTextField = new JTextField("Filter files...");
        filterFilesTextField.setFocusable(false);
        //add the buttons to their panel
        toolBar.add(Box.createRigidArea(new Dimension(20,0)));
        toolBar.add(newDownloadButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(new JSeparator(SwingConstants.VERTICAL));
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(resumeButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(pauseButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(cancelButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(new JSeparator(SwingConstants.VERTICAL));
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(sortButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(new JSeparator(SwingConstants.VERTICAL));
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(removeButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(new JSeparator(SwingConstants.VERTICAL));
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(videoSnifferButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(mediaGrabberButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(batchDownloadButton);
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(new JSeparator(SwingConstants.VERTICAL));
        toolBar.add(Box.createRigidArea(new Dimension(10,0)));
        toolBar.add(settingButton);
        toolBar.add(Box.createRigidArea(new Dimension(30,0)));
        toolBar.add(filterFilesTextField);
        toolBar.add(Box.createRigidArea(new Dimension(1,0)));

        rightSide.add(toolBar, BorderLayout.NORTH);
        add(rightSide, BorderLayout.CENTER);
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
