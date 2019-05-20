package person.liuxx.learn.code.io.picture;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/** 屏幕截图
 * @author 刘湘湘
 * @since 2019年5月20日 上午9:55:41
 */
public class CaptureScreen1
{
    public static void captureScreen(String folder, String fileName) throws Exception
    {
        // 获得屏幕大小并创建一个Rectangle(区域)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        // 创建包含从屏幕中读取的像素的图像
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        // 保存路径
        File screenFile = new File(folder);
        if (!screenFile.exists())
        {
            screenFile.mkdir();
        }
        File f = new File(screenFile, fileName);
        // 决定了f为文件，将图像1以.png格式写入文件f
        ImageIO.write(image, "png", f);
        // 自动打开
        // 启动 2345看图王 打开截图
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN))
        {
            Desktop.getDesktop().open(f);
        }
    }

    public static void main(String[] args)
    {
        try
        {
            captureScreen("E:/dshell", "11.png");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
