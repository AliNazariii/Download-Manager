import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class AboutFrame extends JFrame
{

    public AboutFrame()
    {
        super("About");
        setLayout(new BorderLayout());
        setSize(350, 200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(50, 54, 63));
        setDefaultCloseOperation(SettingFrame.HIDE_ON_CLOSE);
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
