package Models;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is a panel that will go to the CompletedDownloads or DownlaodQueue
 */
public class Download extends JPanel
{
    private JLabel nameOfFile;
    public JProgressBar progressBar;
    private JLabel sizeOfFile;
    private JLabel speedDownload;
    private JLabel linkLabel;
    private JLabel pathLabel;
    private JLabel startLabel;

    public Download(String nameOfFile, String sizeOfFile, String speedDownload)
    {
        super(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 10));
        setBackground(Color.decode("#e7effb"));

        JPanel eagleGetLogo = new JPanel();
        ImageIcon eagleIcon = new ImageIcon(getClass().getResource("/Icons/eagleIcon.png"));
        JLabel eagle = new JLabel(eagleIcon);
        eagleGetLogo.add(eagle);
        eagleGetLogo.setOpaque(false);
        add(eagleGetLogo, BorderLayout.WEST);

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                System.out.println("download panel clicked");
                setBackground(Color.decode("#ecbf7e"));
            }
            /*@Override
            public void mouseEntered(MouseEvent e)
            {
                System.out.println("enter download panel");
                setBackground(Color.decode("#c3c1be"));
            }
            @Override
            public void mouseExited(MouseEvent e)
            {
                System.out.println("exit download panel");
                setBackground(Color.decode("#e7effb"));
            }*/
        });


        JPanel centerOfPanel = new JPanel(new BorderLayout());
        centerOfPanel.setOpaque(false);

        this.nameOfFile = new JLabel(nameOfFile);
        this.nameOfFile.setFont(new Font("Titillium Web", 4, 12));
        this.nameOfFile.setOpaque(false);
        centerOfPanel.add(this.nameOfFile, BorderLayout.NORTH);

        progressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.decode("#018f99"));
        centerOfPanel.add(progressBar, BorderLayout.CENTER);

        this.sizeOfFile = new JLabel(sizeOfFile);
        this.sizeOfFile.setFont(new Font("Titillium Web", 4, 12));
        this.sizeOfFile.setOpaque(false);
        centerOfPanel.add(this.sizeOfFile, BorderLayout.SOUTH);

        add(centerOfPanel, BorderLayout.CENTER);

        validate();
        repaint();
    }

    public class DownloadActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            /*if (e)
            {
                System.out.println();
            }*/
        }
    }


}
