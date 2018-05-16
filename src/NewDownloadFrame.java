import javax.swing.*;
import java.awt.*;

public class NewDownloadFrame extends JFrame
{
    private JTabbedPane tabs;
    private JTextField URLFileld;
    private JTextField nameField;
    private JLabel sizeLabel;
    private JTextField pathField;

    private JButton generalButton;

    private JButton connectionButton;

    private JButton automationButton;

    public NewDownloadFrame()
    {
        super("New Download");
        setLayout(new BorderLayout());
        setSize(350, 200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(50, 54, 63));
        setDefaultCloseOperation(SettingFrame.HIDE_ON_CLOSE);
        showFrame();
    }

    public void showFrame()
    {
        repaint();
        setVisible(true);
    }

}
