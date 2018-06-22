package person.liuxx.learn.code.newapi.java8.stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 流的创建
 * 
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月10日 下午2:27:18
 * @since 1.0.0
 */
public class StreamCreate
{
    /**
     * 创建有限流的几种方式
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午3:14:50
     * @since 1.0.0
     */
    static void limitedStream()
    {
        String[] array =
        { "AaA", "BbB", "CcC", "DdD", "EeE", "FFgg", "jjcc" };
        // 1、使用Stream接口的静态工厂方法Stream.of创建
        Stream<String> stream = Stream.of(array);
        stream.forEach(System.out::println);
        System.out.println("---------");
        Stream<String> stream0 = Stream.of("AaA", "BbB", "CcC", "DdD");
        stream0.forEach(System.out::println);
        System.out.println("---------");
        // 2、使用Collection接口的默认方法：stream()
        List<String> list = new ArrayList<>(Arrays.asList(array));
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);
        System.out.println("---------");
        // 3、使用Iterable接口创建流
        Stream<String> stream3 = StreamSupport.stream(new A(new String[]
        { "AA", "BB", "CC" }).spliterator(), false);
        stream3.forEach(System.out::println);
        System.out.println("---------");
        // 4、使用Iterator接口创建流
        Stream<String> stream4 = StreamSupport.stream(Spliterators.spliteratorUnknownSize(new B(
                new String[]
                { "AA", "BB", "CC", "EEE", "ZZZ" }), Spliterator.ORDERED), false);
        stream4.forEach(System.out::println);
        System.out.println("---------");
        // 5、使用Arrays类的静态方法将数组转为流
        Stream<String> stream5 = Arrays.stream(array);
        stream5.forEach(System.out::println);
        System.out.println("---------");
        // 6、使用Pattern的splitAsStream方法将字符串分割为流
        Stream<String> stream6 = Pattern.compile("[\\P{L}]+").splitAsStream("hello as stream !");
        stream6.forEach(System.out::println);
        System.out.println("---------");
    }

    /**
     * 创建无限流的几种方式,为了输出，生成的流使用limit方法截取了一定的长度。
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月10日 下午3:15:42
     * @since 1.0.0
     */
    static void limitlessStream()
    {
        // 1、使用Supplier<T>接口创建无限流
        Stream<Double> stream2 = Stream.generate(() -> Math.random()).limit(10);
        stream2.forEach(System.out::println);
        System.out.println("---------");
        Stream<String> stream2a = Stream.generate(() -> "SSS").limit(5);
        stream2a.forEach(System.out::println);
        System.out.println("---------");
        // 2、使用Stream.iterate方法创建无限流，Stream.iterate第一个参数为“种子”，第二参数个为使用前一个值作为参数的方法。
        Stream<BigInteger> stream3 = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE))
                .limit(5);
        stream3.forEach(System.out::println);
        System.out.println("---------");
        Stream<String> stream4 = Stream.iterate("A", s ->
        {
            return s + s.length();
        }).limit(5);
        stream4.forEach(System.out::println);
        System.out.println("---------");
    }

    static void f()
    {
        limitedStream();
        limitlessStream();
    }

    public static void main(String[] args)
    {
        f();
    }
}

class A implements Iterable<String>
{
    private String[] array;
    private int index;

    public A(String[] array)
    {
        this.array = array;
        index = 0;
    }

    @Override
    public Iterator<String> iterator()
    {
        return new Iterator<String>()
        {
            @Override
            public boolean hasNext()
            {
                return index < array.length;
            }

            @Override
            public String next()
            {
                return array[index++];
            }
        };
    }
}

class B implements Iterator<String>
{
    private String[] array;
    private int index;

    public B(String[] array)
    {
        this.array = array;
        index = 0;
    }

    @Override
    public boolean hasNext()
    {
        return index < array.length;
    }

    @Override
    public String next()
    {
        return array[index++];
    }
}