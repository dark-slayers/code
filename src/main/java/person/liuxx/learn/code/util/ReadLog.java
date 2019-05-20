package person.liuxx.learn.code.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import person.liuxx.util.base.StringUtil;

/**
 * @author 刘湘湘
 * @version 1.4.2<br>
 *          创建时间：2018年11月30日 上午11:03:28
 * @since 1.4.2
 */
public class ReadLog
{
    static final Path DIR = Paths.get("E:/dshell/");
    static final String FILE_NAME = "in";
    static final String FILE_TYPE = "txt";

    public static void main(String[] args)
    {
        Path logPath = DIR.resolve(FILE_NAME + "." + FILE_TYPE);
        Path targetPath = DIR.resolve(FILE_NAME + "_1." + FILE_TYPE);
        try
        {
            List<A> lines = Files.lines(logPath)
                    .filter(s -> !StringUtil.isEmpty(s))
                    // .filter(l -> l.contains("ChangedProcessedDaoImpl"))
                    // .filter(l -> l.contains("19-01-21 at 17:36"))
                    .map(A::new)
                    .filter(s -> !s.uri.endsWith(".html"))
                    .collect(Collectors.toList());
            Map<String, Integer> map = new HashMap<>();
            Iterator<A> iterator = lines.iterator();
            while (iterator.hasNext())
            {
                A a = iterator.next();
                String key = "/depend/voes/";
                if (a.uri.startsWith(key))
                {
                    int value = a.number;
                    if (map.containsKey(key))
                    {
                        value = map.get(key) + a.number;
                    }
                    map.put(key, value);
                    iterator.remove();
                }
            }
            List<String> list = lines.stream().map(a -> a.toString()).collect(Collectors.toList());
            list.add(mapS(map));
            Files.write(targetPath, list);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static String mapS(Map<String, Integer> map)
    {
        StringBuilder sb = new StringBuilder();
        for (String k : map.keySet())
        {
            sb.append(k);
            sb.append("\t");
            sb.append(map.get(k));
            sb.append("\n");
        }
        return sb.toString();
    }
}

class A
{
    final String uri;
    final int number;

    A(String s)
    {
        String[] array = s.split("\t");
        uri = array[0];
        number = Integer.valueOf(array[1]);
    }

    @Override
    public String toString()
    {
        return uri + "\t" + number;
    }
}