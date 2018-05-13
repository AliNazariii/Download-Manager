import javax.swing.*;

/**
 * This is a Download Manager Program...
 * @author Ali Nazari 9631075
 */
public class Main
{
    public static void main(String[] args)
    {
        //choose the default look and feel...Now we use Windows
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        DownloadManagerFrame JDM = new DownloadManagerFrame("Java Download Manager");
        JDM.showFrame();
    }
}
