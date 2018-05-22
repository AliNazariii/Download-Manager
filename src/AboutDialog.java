import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
    private JLabel author;
    private JLabel id;
    private JLabel startDate;
    private JLabel finalDate;

    public AboutDialog(DownloadManagerFrame downloadManagerFrame, String name) {
        super(downloadManagerFrame, name);
        setLayout(new GridLayout(4, 1));
        setSize(350, 200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(208, 223, 248));
        getContentPane().setForeground(new Color(50, 54, 63));

        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setResizable(false);

        author = new JLabel("By: Ali Nazari", SwingConstants.CENTER);
        author.setFont(new Font("Titillium Web", 4, 20));
        add(author);
        id = new JLabel("9631075", SwingConstants.CENTER);
        id.setFont(new Font("Titillium Web", 4, 17));
        add(id);
        startDate = new JLabel("Started project on 12 May 2018", SwingConstants.CENTER);
        startDate.setFont(new Font("Titillium Web", 4, 14));
        add(startDate);
        finalDate = new JLabel("Finished on 19 May 2018", SwingConstants.CENTER);
        finalDate.setFont(new Font("Titillium Web", 4, 14));
        add(finalDate);

        setVisible(true);
    }
}