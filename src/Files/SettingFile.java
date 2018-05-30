package Files;

import GUI.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SettingFile implements Serializable
{
    private static String lookAndFeel;
    private static transient int maxSimultaneouslyDownload;
    private static String path;

    public SettingFile()
    {
        lookAndFeel = Setting.getLookAndFeel();
        maxSimultaneouslyDownload = Setting.getMaxSimultaneouslyDownload();
        path = Setting.getPath();
    }
    public static void saveSetting()
    {
        SettingFile settingFile = new SettingFile();

        try (FileOutputStream fileOutputStream = new FileOutputStream("Settings.jdm"))
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(settingFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
