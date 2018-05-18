import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is a panel that will go to the CompletedDownloads or DownlaodQueue
 */
public class Download extends JPanel
{
    private JToggleButton openButton;
    private JToggleButton pauseButton;
    private JToggleButton removeButton;
    private JToggleButton detailsButton;
    private JLabel nameOfFile;
    private JProgressBar progressBar;
    private JLabel sizeOfFile;
    private JLabel speedDownload;

    public Download(String nameOfFile, String sizeOfFile, String speedDownload)
    {
        super(new BorderLayout());

        JPanel eagleGetLogo = new JPanel();
        ImageIcon eagleIcon = new ImageIcon(getClass().getResource("eagleIcon.png"));
        JLabel eagle = new JLabel(eagleIcon);
        eagleGetLogo.add(eagle);
        eagleGetLogo.setOpaque(false);
        add(eagleGetLogo, BorderLayout.WEST);


        JPanel centerOfPanel = new JPanel(new GridLayout());

        this.nameOfFile = new JLabel(nameOfFile);
        centerOfPanel.add(this.nameOfFile, BorderLayout.NORTH);


        progressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        progressBar.setSize(550, 20);
        progressBar.setValue(40);
        progressBar.setStringPainted(true);
        centerOfPanel.add(progressBar, BorderLayout.CENTER);



        JPanel southPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

        Icon pauseIcon = new ImageIcon(getClass().getResource("pauseIcon2.png"));
        pauseButton = new JToggleButton(pauseIcon);
        pauseButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        pauseButton.setContentAreaFilled(false);
        pauseButton.setOpaque(false);
        pauseButton.setFocusable(false);
        pauseButton.addMouseListener(new DownloadMouseHandler());
        buttonPanel.add(pauseButton);

        Icon openIcon = new ImageIcon(getClass().getResource("openIcon2.png"));
        openButton = new JToggleButton(openIcon);
        openButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        openButton.setContentAreaFilled(false);
        openButton.setOpaque(false);
        openButton.setFocusable(false);
        openButton.addMouseListener(new DownloadMouseHandler());
        buttonPanel.add(openButton);

        Icon removeIcon = new ImageIcon(getClass().getResource("removeIcon2.png"));
        removeButton = new JToggleButton(removeIcon);
        removeButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        removeButton.setContentAreaFilled(false);
        removeButton.setOpaque(false);
        removeButton.setFocusable(false);
        removeButton.addMouseListener(new DownloadMouseHandler());
        buttonPanel.add(removeButton);

        southPanel.add(buttonPanel, BorderLayout.WEST);

        this.sizeOfFile = new JLabel(sizeOfFile);
        southPanel.add(this.sizeOfFile, BorderLayout.CENTER);

        this.speedDownload = new JLabel(speedDownload);
        southPanel.add(this.speedDownload, BorderLayout.EAST);

        centerOfPanel.add(southPanel, BorderLayout.SOUTH);

        add(centerOfPanel, BorderLayout.CENTER);


        Icon detailsIcon = new ImageIcon(getClass().getResource("detailsIcon.png"));
        detailsButton = new JToggleButton(detailsIcon);
        detailsButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        detailsButton.setContentAreaFilled(false);
        detailsButton.setOpaque(false);
        detailsButton.setFocusable(false);
        detailsButton.addMouseListener(new DownloadMouseHandler());
        add(detailsButton, BorderLayout.EAST);

        validate();
        repaint();
    }

    public class DownloadMouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if (e.getSource().equals(openButton))
            {
                System.out.println("openButton");
            }
            else if (e.getSource().equals(pauseButton))
            {
                System.out.println("pauseButton");
            }
            else if (e.getSource().equals(removeButton))
            {
                System.out.println("removeButton");
            }
            else
            {
                System.out.println();
            }
        }
    }


}
