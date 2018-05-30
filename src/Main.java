import GUI.*;
import javax.swing.*;
import java.util.Set;

/**
 * This is a Download Manager Program...
 * @author Ali Nazari 9631075
 */
public class Main
{
    public static void main(String[] args)
    {
        DownloadManager JDM = new DownloadManager("Java Download Manager");

        try {
            UIManager.setLookAndFeel(Setting.getLookAndFeel());
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(DownloadManager.getFrame());

        JDM.showFrame();
    }
}
