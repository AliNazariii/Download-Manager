import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class SettingFrame extends JFrame
{
    private JToolBar toolBar;

    private JLabel superNumberLabel;
    private JLabel numberLabel;
    private JTextField numberField;

    private JLabel superPathLabel;
    private JLabel pathLabel;
    private JTextField pathField;



    public SettingFrame()
    {
        super("Setting");
        setLayout(new BorderLayout());
        setSize(350, 200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(50, 54, 63));
        setDefaultCloseOperation(SettingFrame.HIDE_ON_CLOSE);


        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(new Color(208, 223, 248));

        superNumberLabel = new JLabel("Downloads");
        superNumberLabel.setOpaque(false);
        superNumberLabel.setFocusable(false);
        superNumberLabel.addMouseListener(new MouseHandler());

        toolBar.add(superNumberLabel);




        add(toolBar, BorderLayout.NORTH);

        showFrame();



    }

    public class MouseHandler extends MouseAdapter
    {

    }

    public void showFrame()
    {
        repaint();
        setVisible(true);
    }
}
