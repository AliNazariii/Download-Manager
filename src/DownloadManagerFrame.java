import javafx.scene.control.ToolBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private JMenuItem aboutMenuItem;
    private JMenu downloadMenu;
    private JMenuItem newDownloadMenuItem;
    private JMenuItem pauseMenuItem;
    private JMenuItem resumeMenuItem;
    private JMenuItem cancelMenuItem;
    private JMenuItem deleteMenuItem;
    private JMenuItem settingMenuItem;
    private JMenuItem exitMenuItem;


    private CompletedDownloads completedDownloads;
    private DownloadQueue downloadQueue;


    private JPanel rightSide;

    private JToolBar toolBar;
    private JButton newDownloadButton;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton cancelButton;
    private JButton sortButton;
    private JButton deleteButton;
    private JButton videoSnifferButton;
    private JButton mediaGrabberButton;
    private JButton batchDownloadButton;
    private JButton settingButton;
    private JTextField filterFilesTextField;


    private JPanel leftSide;

    private JPanel downloadManagerLogo;
    private JPanel myLogo;



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



        setMenuBar();
        setLeftSide();
        setRightSide();
    }


    /**
     * This method will create the MenuBar
     * create Download and Help Menu
     * create About MenuItem in Help Menu
     * create NewDownload, Resume, Pause, Cancel, Delete, Setting, Exit in Download Menu
     * and will set all of their configurations
     * This is the JMenuBar of the Frame.
     */
    public void setMenuBar()
    {
        //Here I created the menu bar
        menuBar = new JMenuBar();

        /*
        Here I Started to add the download menu
        then add the menu Items and their features
         */
        downloadMenu = new JMenu("Download");
        downloadMenu.setMnemonic(KeyEvent.VK_D);

        newDownloadMenuItem = new JMenuItem("New Download", KeyEvent.VK_N);
        newDownloadMenuItem.setToolTipText("New Download");
        newDownloadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newDownloadMenuItem.addMouseListener(new MouseHandler());
        downloadMenu.add(newDownloadMenuItem);

        downloadMenu.add(new JSeparator());

        resumeMenuItem = new JMenuItem("Resume", KeyEvent.VK_R);
        resumeMenuItem.setToolTipText("Resume");
        resumeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        resumeMenuItem.addMouseListener(new MouseHandler());
        downloadMenu.add(resumeMenuItem);

        pauseMenuItem = new JMenuItem("Pause", KeyEvent.VK_P);
        pauseMenuItem.setToolTipText("Pause");
        pauseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        pauseMenuItem.addMouseListener(new MouseHandler());
        downloadMenu.add(pauseMenuItem);

        cancelMenuItem = new JMenuItem("Cancel", KeyEvent.VK_C);
        cancelMenuItem.setToolTipText("Cancel");
        cancelMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
        cancelMenuItem.addMouseListener(new MouseHandler());
        downloadMenu.add(cancelMenuItem);

        downloadMenu.add(new JSeparator());

        deleteMenuItem = new JMenuItem("Delete", KeyEvent.VK_D);
        deleteMenuItem.setToolTipText("Delete");
        deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        deleteMenuItem.addMouseListener(new MouseHandler());
        downloadMenu.add(deleteMenuItem);

        downloadMenu.add(new JSeparator());

        settingMenuItem = new JMenuItem("Setting", KeyEvent.VK_S);
        settingMenuItem.setToolTipText("Settings");
        settingMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        settingMenuItem.addMouseListener(new MouseHandler());
        downloadMenu.add(settingMenuItem);

        downloadMenu.add(new JSeparator());

        exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        exitMenuItem.addMouseListener(new MouseHandler());
        downloadMenu.add(exitMenuItem);

        //here I add the download menu to the menu bar
        menuBar.add(downloadMenu);


        /*
        here I started to make the help menu
        and the About menu Item and their features
         */
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        aboutMenuItem = new JMenuItem("About", KeyEvent.VK_A);
        aboutMenuItem.setToolTipText("About");
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        aboutMenuItem.addMouseListener(new MouseHandler());
        helpMenu.add(aboutMenuItem);

        //and here add the help menu to menu bar
        menuBar.add(helpMenu);

        //and at last I added the menu bar to the main frame
        setJMenuBar(menuBar);
    }


    /**
     * This method will make all of things that related to the left black bar
     * make a black panel and place the the EagleGet logo
     * create the Queue, downloaded items and other tabs...
     * Layout Manager = Border layout
     * This is the West of the Main Frame.
     */
    public void setLeftSide()
    {
        //here I created the panel and set it's color
        leftSide = new JPanel(new BorderLayout());
        leftSide.setBackground(new Color(50, 54, 63));


        //create the JDM Logo to add to the Frame
        downloadManagerLogo = new JPanel();
        ImageIcon thisLogo = new ImageIcon(getClass().getResource("logoInFrame.png"));
        JLabel logo = new JLabel(thisLogo);
        downloadManagerLogo.add(logo);
        //use transparent of the picture not to show the white background under the eagle
        downloadManagerLogo.setOpaque(false);
        //at last, I added the logo panel to the left panel
        leftSide.add(downloadManagerLogo, BorderLayout.NORTH);


        //create the author's panel to add to the left panel
        myLogo = new JPanel();
        ImageIcon myIcon = new ImageIcon(getClass().getResource("myIcon.png"));
        JLabel myLabel = new JLabel(myIcon);
        myLogo.add(myLabel);
        //use transparent of the picture not to show the white background under the eagle
        myLogo.setOpaque(false);
        myLogo.setFocusable(true);
        //here I added the authors panel to the left panel
        leftSide.add(myLogo, BorderLayout.SOUTH);

        //and at last...Adding the left panel to the main panel
        add(leftSide, BorderLayout.WEST);
    }


    /**
     * this method will create a panel that placed in the right side of the frame.
     * contains buttons and also list of the downloads
     * Layout Manager = Border Layout
     * The buttons are in a JToolBar that placed at the NORTH of the panel.
     * and the list of the downloads placed at the CENTER of the panel.
     */
    public void setRightSide()
    {
        //create the right panel and set color
        rightSide = new JPanel(new BorderLayout());
        rightSide.setBackground(new Color(231, 239, 251));


        //create the toolbar of the buttons and avoid being floating
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(new Color(208, 223, 248));

        //create the newDownload button and set the icon and other features
        Icon newDownloadIcon = new ImageIcon(getClass().getResource("newDownloadIcon.png"));
        newDownloadButton = new JButton(newDownloadIcon);
        newDownloadButton.setOpaque(false);
        newDownloadButton.setFocusable(false);
        newDownloadButton.addMouseListener(new MouseHandler());

        //create the pause button and set the icon and other features
        Icon pauseIcon = new ImageIcon(getClass().getResource("pauseIcon.png"));
        pauseButton = new JButton(pauseIcon);
        pauseButton.setOpaque(false);
        pauseButton.setFocusable(false);
        pauseButton.addMouseListener(new MouseHandler());

        //create the resume button and set the icon and other features
        Icon resumeIcon = new ImageIcon(getClass().getResource("resumeIcon.png"));
        resumeButton = new JButton(resumeIcon);
        resumeButton.setOpaque(false);
        resumeButton.setFocusable(false);
        resumeButton.addMouseListener(new MouseHandler());

        //create the cancel button and set the icon and other features
        Icon cancelIcon = new ImageIcon(getClass().getResource("cancelIcon.png"));
        cancelButton = new JButton(cancelIcon);
        cancelButton.setOpaque(false);
        cancelButton.setFocusable(false);
        cancelButton.addMouseListener(new MouseHandler());

        //create the sort button and set the icon and other features
        Icon sortIcon = new ImageIcon(getClass().getResource("sortIcon.png"));
        sortButton = new JButton(sortIcon);
        sortButton.setOpaque(false);
        sortButton.setFocusable(false);
        sortButton.addMouseListener(new MouseHandler());

        //create the delete button and set the icon and other features
        Icon deleteIcon = new ImageIcon(getClass().getResource("deleteIcon.png"));
        deleteButton = new JButton(deleteIcon);
        deleteButton.setOpaque(false);
        deleteButton.setFocusable(false);
        deleteButton.addMouseListener(new MouseHandler());

        //create the videoSniffer button and set the icon and other features
        Icon videoSnifferIcon = new ImageIcon(getClass().getResource("videoSnifferIcon.png"));
        videoSnifferButton = new JButton(videoSnifferIcon);
        videoSnifferButton.setOpaque(false);
        videoSnifferButton.setFocusable(false);
        videoSnifferButton.addMouseListener(new MouseHandler());

        //create the mediaGrabber button and set the icon and other features
        Icon mediaGrabberIcon = new ImageIcon(getClass().getResource("mediaGrabberIcon.png"));
        mediaGrabberButton = new JButton(mediaGrabberIcon);
        mediaGrabberButton.setOpaque(false);
        mediaGrabberButton.setFocusable(false);
        mediaGrabberButton.addMouseListener(new MouseHandler());

        //create the batchDownload button and set the icon and other features
        Icon batchDownloadIcon = new ImageIcon(getClass().getResource("batchDownloadIcon.png"));
        batchDownloadButton = new JButton(batchDownloadIcon);
        batchDownloadButton.setOpaque(false);
        batchDownloadButton.setFocusable(false);
        batchDownloadButton.addMouseListener(new MouseHandler());

        //create the setting button and set the icon and other features
        Icon settingIcon = new ImageIcon(getClass().getResource("settingIcon.png"));
        settingButton = new JButton(settingIcon);
        settingButton.setOpaque(false);
        settingButton.setFocusable(false);
        settingButton.addMouseListener(new MouseHandler());

        //textfield for filtering files by searching words and other features
        filterFilesTextField = new JTextField("Filter files...");
        filterFilesTextField.setForeground(new Color(166, 166, 166));
        filterFilesTextField.setOpaque(false);
        filterFilesTextField.addMouseListener(new MouseHandler());

        //add the buttons to their tool bar and set the spaces and separators
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
        toolBar.add(deleteButton);
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

        //add the toolBar to the NORTH of the right panel
        rightSide.add(toolBar, BorderLayout.NORTH);


        completedDownloads = new CompletedDownloads();
        rightSide.add(completedDownloads, BorderLayout.CENTER);


        //at last I add the right panel to the main frame
        add(rightSide, BorderLayout.CENTER);
    }


    /**
     * This method will make the Main frame visible to show on the screens.
     */
    public void showFrame()
    {
        //pack();
        repaint();
        setVisible(true);
    }


    /**
     * I handle the actions that happen with Mouse here
     */
    public class MouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if (e.getSource().equals(newDownloadButton) || e.getSource().equals(newDownloadMenuItem))
            {
                System.out.println("newDownload");
            }
            else if (e.getSource().equals(resumeButton) || e.getSource().equals(resumeMenuItem))
            {
                System.out.println("resume");
            }
            else if (e.getSource().equals(pauseButton) || e.getSource().equals(pauseMenuItem))
            {
                System.out.println("pause");
            }
            else if (e.getSource().equals(cancelButton) || e.getSource().equals(cancelMenuItem))
            {
                System.out.println("Cancel");
            }
            else if (e.getSource().equals(deleteButton) || e.getSource().equals(deleteMenuItem))
            {
                System.out.println("delete");
            }
            else if (e.getSource().equals(settingButton) || e.getSource().equals(settingMenuItem))
            {
                System.out.println("setting");
            }
            else if (e.getSource().equals(exitMenuItem))
            {
                System.out.println("Exit");
            }
            else if (e.getSource().equals(aboutMenuItem))
            {
                System.out.println("about");
            }
            else if (e.getSource().equals(settingMenuItem))
            {
                System.out.println("Item");
            }
            else
            {
                System.out.println("Extra Buttons");
            }
        }
    }

}
