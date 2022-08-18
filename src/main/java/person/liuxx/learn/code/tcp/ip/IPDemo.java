package person.liuxx.learn.code.tcp.ip;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 刘湘湘
 * 
 * @version 1.0.0<br>
 *          创建时间：2019年12月5日 下午3:07:54
 * 
 * @since 1.0.0
 */
public class IPDemo {
    static String ipTo2(String ip) {
        List<String> list = Pattern.compile("\\.")
                .splitAsStream(ip)
                .map(Integer::valueOf)
                .map(i -> intTo2(i))
                .collect(Collectors.toList());
        return list.stream().collect(Collectors.joining());
    }

    static String intTo2(int i) {
        String value = Integer.toBinaryString(i);
        String s = Stream.generate(() -> "0")
                .limit(8 - value.length())
                .collect(Collectors.joining());
        return s + Integer.toBinaryString(i);
    }

    static void showType(String ip) {
        String text = ipTo2(ip);
        LinkedList<String> list = Pattern.compile("")
                .splitAsStream(text)
                .collect(Collectors.toCollection(LinkedList::new));
        String[] array = { "A", "B", "C", "D", "E" };
        int i = 0;
        for (; i < 5; i++) {
            if (Objects.equals("0", list.pop())) {
                break;
            }
        }
        System.out.println("ip：" + ip + "类型为：" + array[i]);
    }

    /**
     * @author 刘湘湘
     * 
     * @version 1.0.0<br>
     *          创建时间：2019年12月5日 下午3:07:54
     * 
     * @since 1.0.0
     * 
     * @param args
     */
    public static void main(String[] args) {
        String ip = "10.168.1.1";
        String s = ipTo2(ip);
        System.out.println(s);
        showType(ip);
    }
}
