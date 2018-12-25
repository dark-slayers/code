package person.liuxx.learn.code.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/** 
* @author  刘湘湘 
* @version 1.4.2<br>创建时间：2018年11月30日 上午11:03:28
* @since 1.4.2 
*/
public class ReadLog
{
    public static void main(String[] args){
        Path logPath=Paths.get("E:/dshell/INFO.log");
        Path targetPath=Paths.get("E:/dshell/READ_1.log");
        try
        {
            List<String> lines=Files.lines(logPath).filter(l->l.contains("18-11-29 at 23")).collect(Collectors.toList());
            Files.write(targetPath, lines);
        } catch (IOException e)
        {

            e.printStackTrace();
        }
    }
}
