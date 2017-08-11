package person.liuxx.learn.code.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流的转换操作
 * 
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月10日 下午3:32:38
 * @since 1.0.0
 */
public class StreamChange
{
    static Stream<String> createStream()
    {
        String[] array =
        { "AaA", "BbB", "CcC", "DdD", "EeE", "FFgg", "jjcc", "AaA", "AaA", "AAA", "BBB" };
        Arrays.stream(array);
        return Stream.of(array);
    }

    /**
     * 流的过滤
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午3:43:47
     * @since 1.0.0
     */
    static void filterDemo()
    {
        Stream<String> stream = createStream();
        // 获取流中长度大于3的字符串
        stream.filter(s -> s.length() > 3).forEach(System.out::println);
        System.out.println("-------");
        stream = createStream();
        // 获取流中以字母"A"开头字符串
        stream.filter(s -> s.startsWith("A")).forEach(System.out::println);
        System.out.println("-------");
        // 获取流中以字母"A"开头字符串,去除重复
        stream = createStream();
        stream.filter(s -> s.startsWith("A")).distinct().forEach(System.out::println);
        System.out.println("-------");
    }

    /**
     * 流的转换
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午3:52:13
     * @since 1.0.0
     */
    static void mapDemo()
    {
        Stream<String> stream = createStream();
        // 将字符串流转换为boolean值的流
        stream.map(s -> s.length() > 3).forEach(System.out::println);
        System.out.println("-------");
        stream = createStream();
        // 将字符串流转换为int值的流
        stream.map(s -> s.length()).forEach(System.out::println);
        System.out.println("-------");
        stream = createStream();
        // 将字符串流转换为小写
        stream.map(s -> s.toLowerCase()).forEach(System.out::println);
        System.out.println("-------");
    }

    /**
     * flatMap方法接受一个将元素转为流的函数，flatMap方法将元素转换后的多个流展开合并为一个流
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午4:07:33
     * @since 1.0.0
     */
    static void flatMapDemo()
    {
        Stream<String> stream = createStream();
        // 将字符串流转换为char的流，直接调用map会将字符串转为表示一个流的对象，无法将流展开获取其中的元素、
        // 应该使用flatMap方法
        stream.map(s -> charStream(s)).forEach(System.out::println);
        System.out.println("-------");
        stream = createStream();
        stream.flatMap(s -> charStream(s)).forEach(System.out::println);
        System.out.println("-------");
    }

    static Stream<Character> charStream(String word)
    {
        List<Character> list = new ArrayList<Character>();
        for (char c : word.toCharArray())
        {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * 从一个流中获取子流（获取前面指定数量的元素，或者抛弃前面指定数量的元素）
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午4:13:15
     * @since 1.0.0
     */
    static void subDemo()
    {
        Stream<String> stream = createStream();
        // limit(n)返回一个包含n个元素的新流，如果原始流的长度小于n,返回原始流
        stream.limit(3).forEach(System.out::println);
        System.out.println("-------");
        stream = createStream();
        // skip(n)返回一个抛弃前面n个元素的新流
        stream.skip(3).forEach(System.out::println);
        System.out.println("-------");
    }

    /**
     * 将两个流合并为一个流
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午4:20:19
     * @since 1.0.0
     */
    static void concatDemo()
    {
        Stream<String> stream1 = createStream();
        Stream<String> stream2 = createStream();
        // Stream.concat(stream1, stream2)将stream2连接到stream1后面，stream1不应该是无限流
        Stream<String> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(System.out::println);
        System.out.println("-------");
    }

    /**
     * peek方法产生一个与原始流具有相同元素的流，但是在每次获取一个元素时，会调用一个方法。
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午4:23:38
     * @since 1.0.0
     */
    static void peekDemo()
    {
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching : " + e))
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(powers));
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午3:32:27
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        filterDemo();
        mapDemo();
        flatMapDemo();
        subDemo();
        concatDemo();
        peekDemo();
    }
}
