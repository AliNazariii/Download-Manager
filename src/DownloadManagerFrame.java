
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the Main Frame of the download manager that will be shown...
 */
public class DownloadManagerFrame extends JFrame
{
    private JMenuBar menuBar;

    private JMenu helpMenu;
    private JMenuItem aboutMenuItem;
    private JMenu lookAndFeel;
    private JMenuItem metalLF;
    private JMenuItem nimbusLF;
    private JMenuItem CdeLF;
    private JMenuItem windowsLF;
    private JMenuItem windowsClassicLF;
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

    private JToolBar leftToolBar;
    private JButton processingButton;
    private JButton completedButton;
    private JButton queueButton;

    private JPanel myLogo;


    private SettingFrame settingFrame;
    private AboutDialog aboutDialog;
    private NewDownloadFrame newDownloadFrame;


    public DownloadManagerFrame(String name)
    {
        super(name);
        //this is the size of the Main Frame
        setSize(800, 600);
        //if the client click on the exit, the program will go to the system tray
        //setDefaultCloseOperation(DownloadManagerFrame.EXIT_ON_CLOSE);
        //put the main frame to the center of the screen
        setLocationRelativeTo(null);
        //set the Layout Manager
        getContentPane().setLayout(new BorderLayout());

        setMenuBar();
        setLeftSide();
        setRightSide();
        setDownloadLists();

        SystemTray systemTray = SystemTray.getSystemTray();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(getClass().getResource("/Icons/eagleIcon.png"));
        PopupMenu popupMenu = new PopupMenu();
        TrayIcon icon = new TrayIcon(image, "JDM", popupMenu);
        MenuItem openItem = new MenuItem("Open JDM");
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
            }
        });
        popupMenu.add(openItem);

        MenuItem closeItem = new MenuItem("Close JDM");
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemTray.getSystemTray().remove(icon);
                System.exit(0);
            }
        });
        popupMenu.add(closeItem);
        icon.setImageAutoSize(true);
        try {
            systemTray.add(icon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
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
        KeyStroke newDownloadMenu = KeyStroke.getKeyStroke("control N");
        newDownloadMenuItem.setAccelerator(newDownloadMenu);
        newDownloadMenuItem.addActionListener(e -> setNewDownloadFrame());
        newDownloadMenuItem.addMouseListener(new JDMMouseHandler());
        downloadMenu.add(newDownloadMenuItem);

        downloadMenu.add(new JSeparator());

        resumeMenuItem = new JMenuItem("Resume", KeyEvent.VK_R);
        resumeMenuItem.setToolTipText("Resume");
        KeyStroke resumeMenu = KeyStroke.getKeyStroke("control R");
        resumeMenuItem.setAccelerator(resumeMenu);
        resumeMenuItem.addActionListener(e -> System.out.println("Resume"));
        resumeMenuItem.addMouseListener(new JDMMouseHandler());
        downloadMenu.add(resumeMenuItem);

        pauseMenuItem = new JMenuItem("Pause", KeyEvent.VK_P);
        pauseMenuItem.setToolTipText("Pause");
        KeyStroke pauseMenu = KeyStroke.getKeyStroke("control P");
        pauseMenuItem.setAccelerator(pauseMenu);
        pauseMenuItem.addActionListener(e -> System.out.println("Pause"));
        pauseMenuItem.addMouseListener(new JDMMouseHandler());
        downloadMenu.add(pauseMenuItem);

        cancelMenuItem = new JMenuItem("Cancel", KeyEvent.VK_C);
        cancelMenuItem.setToolTipText("Cancel");
        KeyStroke cancelMenu = KeyStroke.getKeyStroke("alt C");
        cancelMenuItem.setAccelerator(cancelMenu);
        cancelMenuItem.addActionListener(e -> System.out.println("Cancel"));
        cancelMenuItem.addMouseListener(new JDMMouseHandler());
        downloadMenu.add(cancelMenuItem);

        downloadMenu.add(new JSeparator());

        deleteMenuItem = new JMenuItem("Delete", KeyEvent.VK_D);
        deleteMenuItem.setToolTipText("Delete");
        KeyStroke deleteMenu = KeyStroke.getKeyStroke("control D");
        deleteMenuItem.setAccelerator(deleteMenu);
        deleteMenuItem.addActionListener(e -> System.out.println("Delete"));
        deleteMenuItem.addMouseListener(new JDMMouseHandler());
        downloadMenu.add(deleteMenuItem);

        downloadMenu.add(new JSeparator());

        settingMenuItem = new JMenuItem("Setting", KeyEvent.VK_S);
        settingMenuItem.setToolTipText("Settings");
        KeyStroke settingMenu = KeyStroke.getKeyStroke("alt S");
        settingMenuItem.setAccelerator(settingMenu);
        settingMenuItem.addActionListener(e -> setSettingFrame());
        settingMenuItem.addMouseListener(new JDMMouseHandler());
        downloadMenu.add(settingMenuItem);

        downloadMenu.add(new JSeparator());

        exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit");
        KeyStroke exitMenu = KeyStroke.getKeyStroke("alt E");
        exitMenuItem.setAccelerator(exitMenu);
        exitMenuItem.addActionListener(e -> System.exit(0));
        exitMenuItem.addMouseListener(new JDMMouseHandler());
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
        KeyStroke aboutMenu = KeyStroke.getKeyStroke("alt A");
        aboutMenuItem.setAccelerator(aboutMenu);
        aboutMenuItem.addActionListener(e -> setAboutDialog());
        aboutMenuItem.addMouseListener(new JDMMouseHandler());
        helpMenu.add(aboutMenuItem);

        lookAndFeel = new JMenu("Look And Feel");
        lookAndFeel.setMnemonic(KeyEvent.VK_L);

        metalLF = new JMenuItem("Metal", KeyEvent.VK_M);
        metalLF.setToolTipText("Metal");
        metalLF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));
        metalLF.addMouseListener(new JDMMouseHandler());
        lookAndFeel.add(metalLF);

        nimbusLF = new JMenuItem("Nimbus", KeyEvent.VK_N);
        nimbusLF.setToolTipText("Nimbus");
        nimbusLF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.SHIFT_MASK));
        nimbusLF.addMouseListener(new JDMMouseHandler());
        lookAndFeel.add(nimbusLF);

        CdeLF = new JMenuItem("CDE/Motif", KeyEvent.VK_D);
        CdeLF.setToolTipText("CDE/Motif");
        CdeLF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
        CdeLF.addMouseListener(new JDMMouseHandler());
        lookAndFeel.add(CdeLF);

        windowsLF = new JMenuItem("Windows", KeyEvent.VK_W);
        windowsLF.setToolTipText("Windows");
        windowsLF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.SHIFT_MASK));
        windowsLF.addMouseListener(new JDMMouseHandler());
        lookAndFeel.add(windowsLF);

        windowsClassicLF = new JMenuItem("Windows Classic", KeyEvent.VK_L);
        windowsClassicLF.setToolTipText("Windows Classic");
        windowsClassicLF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
        windowsClassicLF.addMouseListener(new JDMMouseHandler());
        lookAndFeel.add(windowsClassicLF);

        helpMenu.add(lookAndFeel);

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
        ImageIcon thisLogo = new ImageIcon(getClass().getResource("/Icons/logoInFrame.png"));
        JLabel logo = new JLabel(thisLogo);
        downloadManagerLogo.add(logo);
        //use transparent of the picture not to show the white background under the eagle
        downloadManagerLogo.setOpaque(false);
        //at last, I added the logo panel to the left panel
        leftSide.add(downloadManagerLogo, BorderLayout.NORTH);


        //here I create the leftSide Toolbar for 3 buttons that contains downloadLists
        leftToolBar = new JToolBar(JToolBar.VERTICAL);
        leftToolBar.setFloatable(false);
        leftToolBar.setBackground(new Color(50, 54, 63));

        Icon processingIcon = new ImageIcon(getClass().getResource("/Icons/processingIcon.png"));
        processingButton = new JButton("Processing", processingIcon);
        processingButton.setForeground(new Color(255, 255, 255));
        processingButton.setOpaque(false);
        processingButton.setFocusable(false);
        processingButton.addMouseListener(new JDMMouseHandler());

        Icon completedIcon = new ImageIcon(getClass().getResource("/Icons/completedIcon.png"));
        completedButton = new JButton("Completed", completedIcon);
        completedButton.setForeground(new Color(255, 255, 255));
        completedButton.setOpaque(false);
        completedButton.setFocusable(false);
        completedButton.addMouseListener(new JDMMouseHandler());

        Icon queueIcon = new ImageIcon(getClass().getResource("/Icons/queueIcon.png"));
        queueButton = new JButton("Queue", queueIcon);
        queueButton.setForeground(new Color(255, 255, 255));
        queueButton.setOpaque(false);
        queueButton.setFocusable(false);
        queueButton.addMouseListener(new JDMMouseHandler());

        leftToolBar.add(Box.createRigidArea(new Dimension(0,20)));
        leftToolBar.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftToolBar.add(processingButton);
        leftToolBar.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftToolBar.add(completedButton);
        leftToolBar.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftToolBar.add(queueButton);
        leftToolBar.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftToolBar.add(Box.createRigidArea(new Dimension(0,300)));

        leftSide.add(leftToolBar, BorderLayout.CENTER);



        //create the author's panel to add to the left panel
        myLogo = new JPanel();
        ImageIcon myIcon = new ImageIcon(getClass().getResource("/Icons/myIcon.png"));
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

        setToolBar();
        setDownloadLists();

        //at last I add the right panel to the main frame
        add(rightSide, BorderLayout.CENTER);
    }

    /**
     * This method do the ToolBar part of the setRightSide method
     */
    public void setToolBar()
    {
        //create the toolbar of the buttons and avoid being floating
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(new Color(208, 223, 248));

        //create the newDownload button and set the icon and other features
        Icon newDownloadIcon = new ImageIcon(getClass().getResource("/Icons/newDownloadIcon.png"));
        newDownloadButton = new JButton(newDownloadIcon);
        newDownloadButton.setToolTipText("New Download");
        newDownloadButton.setOpaque(false);
        newDownloadButton.setFocusable(false);
        newDownloadButton.addMouseListener(new JDMMouseHandler());

        //create the pause button and set the icon and other features
        Icon pauseIcon = new ImageIcon(getClass().getResource("/Icons/pauseIcon.png"));
        pauseButton = new JButton(pauseIcon);
        pauseButton.setToolTipText("Pause");
        pauseButton.setOpaque(false);
        pauseButton.setFocusable(false);
        pauseButton.addMouseListener(new JDMMouseHandler());

        //create the resume button and set the icon and other features
        Icon resumeIcon = new ImageIcon(getClass().getResource("/Icons/resumeIcon.png"));
        resumeButton = new JButton(resumeIcon);
        resumeButton.setToolTipText("Resume");
        resumeButton.setOpaque(false);
        resumeButton.setFocusable(false);
        resumeButton.addMouseListener(new JDMMouseHandler());

        //create the cancel button and set the icon and other features
        Icon cancelIcon = new ImageIcon(getClass().getResource("/Icons/cancelIcon.png"));
        cancelButton = new JButton(cancelIcon);
        cancelButton.setToolTipText("Cancel");
        cancelButton.setOpaque(false);
        cancelButton.setFocusable(false);
        cancelButton.addMouseListener(new JDMMouseHandler());

        //create the sort button and set the icon and other features
        Icon sortIcon = new ImageIcon(getClass().getResource("/Icons/sortIcon.png"));
        sortButton = new JButton(sortIcon);
        sortButton.setToolTipText("Sort");
        sortButton.setOpaque(false);
        sortButton.setFocusable(false);
        sortButton.addMouseListener(new JDMMouseHandler());

        //create the delete button and set the icon and other features
        Icon deleteIcon = new ImageIcon(getClass().getResource("/Icons/deleteIcon.png"));
        deleteButton = new JButton(deleteIcon);
        deleteButton.setToolTipText("Delete Download");
        deleteButton.setOpaque(false);
        deleteButton.setFocusable(false);
        deleteButton.addMouseListener(new JDMMouseHandler());

        //create the videoSniffer button and set the icon and other features
        Icon videoSnifferIcon = new ImageIcon(getClass().getResource("/Icons/videoSnifferIcon.png"));
        videoSnifferButton = new JButton(videoSnifferIcon);
        videoSnifferButton.setOpaque(false);
        videoSnifferButton.setToolTipText("Video Sniffer");
        videoSnifferButton.setFocusable(false);
        videoSnifferButton.addMouseListener(new JDMMouseHandler());

        //create the mediaGrabber button and set the icon and other features
        Icon mediaGrabberIcon = new ImageIcon(getClass().getResource("/Icons/mediaGrabberIcon.png"));
        mediaGrabberButton = new JButton(mediaGrabberIcon);
        mediaGrabberButton.setOpaque(false);
        mediaGrabberButton.setToolTipText("Media Grabber");
        mediaGrabberButton.setFocusable(false);
        mediaGrabberButton.addMouseListener(new JDMMouseHandler());

        //create the batchDownload button and set the icon and other features
        Icon batchDownloadIcon = new ImageIcon(getClass().getResource("/Icons/batchDownloadIcon.png"));
        batchDownloadButton = new JButton(batchDownloadIcon);
        batchDownloadButton.setOpaque(false);
        batchDownloadButton.setToolTipText("Batch Download");
        batchDownloadButton.setFocusable(false);
        batchDownloadButton.addMouseListener(new JDMMouseHandler());

        //create the setting button and set the icon and other features
        Icon settingIcon = new ImageIcon(getClass().getResource("/Icons/settingIcon.png"));
        settingButton = new JButton(settingIcon);
        settingButton.setToolTipText("Setting");
        settingButton.setOpaque(false);
        settingButton.setFocusable(false);
        settingButton.addMouseListener(new JDMMouseHandler());

        //textfield for filtering files by searching words and other features
        filterFilesTextField = new JTextField("Filter files...");
        filterFilesTextField.setForeground(new Color(166, 166, 166));
        filterFilesTextField.setOpaque(false);
        filterFilesTextField.addMouseListener(new JDMMouseHandler());

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
    }

    /**
     * This method do the DownloadLists of the setRightSide method
     */
    public void setDownloadLists()
    {
        completedDownloads = new CompletedDownloads();
        downloadQueue = new DownloadQueue();
    }

    /**
     * This method will create the completed download list
     */
    public void callCompleteDownloads()
    {
        rightSide.add(completedDownloads, BorderLayout.CENTER);
        completedDownloads.showDownloads();
        showFrame();
    }

    /**
     * This method will show the Queue list
     */
    public void callDownloadQueue()
    {
        rightSide.add(downloadQueue, BorderLayout.CENTER);
        downloadQueue.showDownloads();
        showFrame();
    }

    /**
     * This method will make the Main frame visible to show on the screens.
     */
    public void showFrame()
    {
        //pack();
        validate();
        repaint();
        setVisible(true);
    }

    /**
     * This method will create the Setting Frame
     * contains where to save files
     * and how many downloads can perform together
     */
    public void setSettingFrame()
    {
        settingFrame = new SettingFrame();
    }

    /**
     * This method will create the About Frame
     * contains author's name, id, date, ...
     */
    public void setAboutDialog()
    {
        aboutDialog = new AboutDialog(this, "About");
    }

    /**
     * This method will create the New Download Frame
     */
    public void setNewDownloadFrame()
    {
        newDownloadFrame = new NewDownloadFrame();
    }

    /**
     * This is the main part of changing the Look and Feel
     * this method is called by the MouseHandler.
     */
    public void setUI()
    {
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * I handle the actions that happen with Mouse here
     */
    public class JDMMouseHandler extends MouseAdapter
    {
        @Override
        //This method usually use for the buttons
        public void mouseClicked(MouseEvent e)
        {
            if (e.getSource().equals(newDownloadButton))
            {
                System.out.println("newDownloadButton");
                setNewDownloadFrame();
            }
            else if (e.getSource().equals(resumeButton))
            {
                System.out.println("resumeButton");
            }
            else if (e.getSource().equals(pauseButton))
            {
                System.out.println("pauseButton");
            }
            else if (e.getSource().equals(cancelButton))
            {
                System.out.println("cancelButton");
            }
            else if (e.getSource().equals(deleteButton))
            {
                System.out.println("deleteButton");
            }
            else if (e.getSource().equals(settingButton))
            {
                System.out.println("settingButton");
                setSettingFrame();
            }
            else if (e.getSource().equals(queueButton))
            {
                System.out.println("queueButton");
                callDownloadQueue();
            }
            else if (e.getSource().equals(completedButton))
            {
                System.out.println("completedButton");
                callCompleteDownloads();
            }
            else if (e.getSource().equals(processingButton))
            {
                System.out.println("processingButton");
            }
            else
            {
                System.out.println("Extra Buttons");
            }
        }
        //This method usually use for the menuItems
        public void mousePressed(MouseEvent e)
        {
            if (e.getSource().equals(newDownloadMenuItem))
            {
                System.out.println("newDownloadMenuItem");
                setNewDownloadFrame();
            }
            else if (e.getSource().equals(resumeMenuItem))
            {
                System.out.println("resumeMenuItem");
            }
            else if (e.getSource().equals(pauseMenuItem))
            {
                System.out.println("pauseMenuItem");
            }
            else if (e.getSource().equals(cancelMenuItem))
            {
                System.out.println("cancelMenuItem");
            }
            else if (e.getSource().equals(deleteMenuItem))
            {
                System.out.println("deleteMenuItem");
            }
            else if (e.getSource().equals(settingMenuItem))
            {
                System.out.println("settingMenuItem");
                setSettingFrame();
            }
            else if (e.getSource().equals(exitMenuItem))
            {
                System.out.println("exitMenuItem");
                System.exit(0);
            }
            else if (e.getSource().equals(aboutMenuItem))
            {
                System.out.println("aboutMenuItem");
                setAboutDialog();
            }
            //Listener of the Metal
            else if (e.getSource().equals(metalLF))
            {
                System.out.println("Metal Look&Feel");
                try
                {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
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
            }
        }
    }
}
