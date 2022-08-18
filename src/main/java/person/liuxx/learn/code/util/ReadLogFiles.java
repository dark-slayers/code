package person.liuxx.learn.code.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 刘湘湘
 * 
 * @version 1.1.0<br>
 *          创建时间：2021年2月4日 上午9:42:56
 * 
 * @since 1.1.0
 */
public class ReadLogFiles {
    public static void main(String[] args) {
//         String path = "E:/shell/bala-app/logs/sql1.txt";
        String path = "E:/shell/bala-app/logs/DEBUG.log";
        int defalutLineNumber = 15;
        String todatString = Pattern.compile("")
                .splitAsStream(LocalDate.now().toString())
                .skip(2)
                .collect(Collectors.joining());
        read(path, defalutLineNumber, todatString+" at ", "updateState", "","");
//        read(path, defalutLineNumber,  "table_id: 3440", "");
    }   

    static void read(String path, int lineNumber, String... word) {
        try {
            List<String> logList = search(Files.lines(Paths.get(path)), lineNumber, word);
            Files.write(Paths.get(path + "_all"), logList);
            System.out.println("文件写入完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<String> search(Stream<String> lines, int lineNumber, String... word) {
        AtomicInteger index = new AtomicInteger(0);
        return lines.filter(t -> {
            if (Stream.of(word).allMatch(w -> t.contains(w))) {
                index.set(lineNumber);
            } else {
                index.getAndDecrement();
            }
            return index.intValue() > 0;
        }).collect(Collectors.toList());
    }
}
