import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class NewDownloadFrame extends JFrame
{
    private JTabbedPane topTabs;

    private JPanel HTTPPanel;
    private JPanel northPanelHttp;
    private JPanel URLPanelHttp;
    private JPanel URLLogoHttp;
    private JTextField URLFieldHttp;
    private JButton openBT;
    private JPanel namePanelHttp;
    private JPanel nameLogoHttp;
    private JTextField nameFieldHttp;
    private JLabel sizeLabelHttp;
    private JPanel pathPanelHttp;
    private JTextField pathFieldHttp;
    private JLabel capacityLabelHttp;
    private JToggleButton fileChooserButtonHttp;
    private JFileChooser fileChooserHttp;

    private JPanel southPanelHttp;
    private JTabbedPane leftTabsHttp;
    private JButton generalButtonHttp;
    private JButton connectionButtonHttp;
    private JButton automationButtonHttp;


    private JPanel BTPanel;
    private JPanel northPanelBT;
    private JPanel URLPanelBT;
    private JPanel URLLogoBT;
    private JTextField URLFieldBT;
    private JPanel namePanelBT;
    private JPanel nameLogoBT;
    private JTextField nameFieldBT;
    private JLabel sizeLabelBT;
    private JPanel pathPanelBT;
    private JTextField pathFieldBT;
    private JLabel capacityLabelBT;
    private JToggleButton fileChooserButtonBT;
    private JFileChooser fileChooserBT;

    private JPanel southPanelBT;
    private JTabbedPane leftTabsBT;
    private JButton generalButtonBT;
    private JButton connectionButtonBT;
    private JButton automationButtonBT;

    public NewDownloadFrame()
    {
        super("New Download");
        setLayout(new BorderLayout());
        setSize(450, 375);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(NewDownloadFrame.HIDE_ON_CLOSE);

        topTabs = new JTabbedPane(JTabbedPane.NORTH);

        setHTTP();
        topTabs.add("       HTTP       ", HTTPPanel);

        setBT();
        topTabs.add("        BT        ", BTPanel);

        add(topTabs);
        showFrame();
    }

    public void setHTTP()
    {
        HTTPPanel = new JPanel(new BorderLayout(10, 10));
        HTTPPanel.setBackground(new Color(255, 255, 255));


        northPanelHttp = new JPanel(new BorderLayout(10, 7));
        northPanelHttp.setOpaque(false);


        URLPanelHttp = new JPanel(new BorderLayout());
        URLPanelHttp.setOpaque(false);

        Icon URLIcon = new ImageIcon(getClass().getResource("urlIcon.png"));
        URLLogoHttp = new JPanel();
        JLabel url = new JLabel(URLIcon);
        URLLogoHttp.add(url);
        URLLogoHttp.setOpaque(false);
        URLPanelHttp.add(URLLogoHttp, BorderLayout.WEST);

        URLFieldHttp = new JTextField();
        URLFieldHttp.setPreferredSize(new Dimension(URLFieldHttp.getWidth(), 25));
        URLFieldHttp.setForeground(new Color(89, 89, 89));
        URLPanelHttp.add(URLFieldHttp, BorderLayout.CENTER);

        northPanelHttp.add(URLPanelHttp, BorderLayout.NORTH);


        namePanelHttp = new JPanel(new BorderLayout());
        namePanelHttp.setOpaque(false);

        Icon nameIcon = new ImageIcon(getClass().getResource("nameIcon.png"));
        nameLogoHttp = new JPanel();
        JLabel name = new JLabel(nameIcon);
        nameLogoHttp.add(name);
        nameLogoHttp.setOpaque(false);
        namePanelHttp.add(nameLogoHttp, BorderLayout.WEST);

        nameFieldHttp = new JTextField();
        nameFieldHttp.setPreferredSize(new Dimension(nameFieldHttp.getWidth(), 25));
        nameFieldHttp.setForeground(new Color(89, 89, 89));
        namePanelHttp.add(nameFieldHttp, BorderLayout.CENTER);

        northPanelHttp.add(namePanelHttp, BorderLayout.CENTER);


        sizeLabelHttp = new JLabel("UnKnow Size");
        northPanelHttp.add(sizeLabelHttp, BorderLayout.SOUTH);


        pathPanelHttp = new JPanel(new BorderLayout(10, 10));
        pathPanelHttp.setBorder(BorderFactory.createLineBorder(new Color(41, 117, 211)));
        pathPanelHttp.setOpaque(false);

        pathFieldHttp = new JTextField("  C:\\Users\\Ali_Z\\Desktop                                                          ");
        pathFieldHttp.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pathFieldHttp.setForeground(new Color(89, 89, 89));
        pathPanelHttp.add(pathFieldHttp, BorderLayout.WEST);

        capacityLabelHttp = new JLabel("20GB Free");
        capacityLabelHttp.setForeground(new Color(41, 117, 211));
        pathPanelHttp.add(capacityLabelHttp, BorderLayout.CENTER);

        Icon fileChooserIcon = new ImageIcon(getClass().getResource("fileChooserIcon.png"));
        fileChooserButtonHttp = new JToggleButton(fileChooserIcon);
        fileChooserButtonHttp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        fileChooserButtonHttp.setContentAreaFilled(false);
        fileChooserButtonHttp.setOpaque(false);
        fileChooserButtonHttp.setFocusable(false);
        fileChooserButtonHttp.addMouseListener(new NewDownloadMouseHandler());
        pathPanelHttp.add(fileChooserButtonHttp, BorderLayout.EAST);

        northPanelHttp.add(pathPanelHttp, BorderLayout.SOUTH);


        HTTPPanel.add(northPanelHttp, BorderLayout.NORTH);

    }

    public void setFileChooserHttp()
    {
        fileChooserHttp = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooserHttp.setDialogTitle("Browse For Folder");
        int returnValue = fileChooserHttp.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserHttp.getSelectedFile();
            System.out.println(selectedFile.getName());
        }
    }

    public void setBT()
    {
        BTPanel = new JPanel(new BorderLayout(10, 10));
        BTPanel.setBackground(new Color(255, 255, 255));


        northPanelBT = new JPanel(new BorderLayout(10, 7));
        northPanelBT.setOpaque(false);


        URLPanelBT = new JPanel(new BorderLayout());
        URLPanelBT.setOpaque(false);

        Icon URLIcon = new ImageIcon(getClass().getResource("urlIcon.png"));
        URLLogoBT = new JPanel();
        JLabel url = new JLabel(URLIcon);
        URLLogoBT.add(url);
        URLLogoBT.setOpaque(false);
        URLPanelBT.add(URLLogoBT, BorderLayout.WEST);

        URLFieldBT = new JTextField();
        URLFieldBT.setPreferredSize(new Dimension(URLFieldBT.getWidth(), 25));
        URLFieldBT.setForeground(new Color(89, 89, 89));
        URLPanelBT.add(URLFieldBT, BorderLayout.CENTER);

        openBT = new JButton("Open BT file");
        //openBT.setBackground(new Color(54, 76, 190));
        //openBT.setForeground(new Color(255, 255, 255));
        openBT.setOpaque(false);
        //openBT.setMargin(new Insets(0, 5, 0, 5));
        URLPanelBT.add(openBT, BorderLayout.EAST);

        northPanelBT.add(URLPanelBT, BorderLayout.NORTH);


        namePanelBT = new JPanel(new BorderLayout());
        namePanelBT.setOpaque(false);

        Icon nameIcon = new ImageIcon(getClass().getResource("nameIcon.png"));
        nameLogoBT = new JPanel();
        JLabel name = new JLabel(nameIcon);
        nameLogoBT.add(name);
        nameLogoBT.setOpaque(false);
        namePanelBT.add(nameLogoBT, BorderLayout.WEST);

        nameFieldBT = new JTextField();
        nameFieldBT.setPreferredSize(new Dimension(nameFieldBT.getWidth(), 25));
        nameFieldBT.setForeground(new Color(89, 89, 89));
        namePanelBT.add(nameFieldBT, BorderLayout.CENTER);

        northPanelBT.add(namePanelBT, BorderLayout.CENTER);


        sizeLabelBT = new JLabel("UnKnow Size");
        northPanelBT.add(sizeLabelBT, BorderLayout.SOUTH);


        pathPanelBT = new JPanel(new BorderLayout(10, 10));
        pathPanelBT.setBorder(BorderFactory.createLineBorder(new Color(41, 117, 211)));
        pathPanelBT.setOpaque(false);

        pathFieldBT = new JTextField("  C:\\Users\\Ali_Z\\Desktop                                                          ");
        pathFieldBT.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pathFieldBT.setForeground(new Color(89, 89, 89));
        pathPanelBT.add(pathFieldBT, BorderLayout.WEST);

        capacityLabelBT = new JLabel("20GB Free");
        capacityLabelBT.setForeground(new Color(41, 117, 211));
        pathPanelBT.add(capacityLabelBT, BorderLayout.CENTER);

        Icon fileChooserIcon = new ImageIcon(getClass().getResource("fileChooserIcon.png"));
        fileChooserButtonBT = new JToggleButton(fileChooserIcon);
        fileChooserButtonBT.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        fileChooserButtonBT.setContentAreaFilled(false);
        fileChooserButtonBT.setOpaque(false);
        fileChooserButtonBT.setFocusable(false);
        fileChooserButtonBT.addMouseListener(new NewDownloadMouseHandler());
        pathPanelBT.add(fileChooserButtonBT, BorderLayout.EAST);

        northPanelBT.add(pathPanelBT, BorderLayout.SOUTH);


        BTPanel.add(northPanelBT, BorderLayout.NORTH);

    }

    public void setFileChooserBT()
    {
        fileChooserBT = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooserBT.setDialogTitle("Browse For Folder");
        int returnValue = fileChooserBT.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserBT.getSelectedFile();
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
            if (e.getSource().equals(fileChooserButtonHttp))
            {
                System.out.println("fileChooserButtonHttp");
                setFileChooserHttp();
            }
            else if (e.getSource().equals(fileChooserButtonBT))
            {
                System.out.println("fileChooserButtonBT");
                setFileChooserBT();
            }
            else
            {
                System.out.println("Extra Buttons");
            }
        }

        /*public void mousePressed(MouseEvent e)
        {
            if (e.getSource().equals(newDownloadMenuItem))
            {
                System.out.println("newDownloadMenuItem");
                setNewDownloadFrame();
            }
            else if (e.getSource().equals(aboutMenuItem))
            {
                System.out.println("aboutMenuItem");
                setAboutFrame();
            }

        }*/
    }

    public void showFrame()
    {
        pack();
        repaint();
        setVisible(true);
    }
}
