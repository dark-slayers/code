package person.liuxx.learn.code.newapi.java8.stream;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月31日 下午3:06:09
 * @since 1.0.0
 */
public class StreamCollect
{
    public static void collect()
    {
        Stream<String> stream = createStream();
        String[] array = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(array));
        stream = createStream();
        HashSet<String> set = stream.parallel().collect(HashSet::new, HashSet::add,
                HashSet::addAll);
        System.out.println(set);
        stream = createStream();
        set = stream.parallel().collect(() ->
        {
            return new HashSet<String>();
        }, (set1, text) ->
        {
            set1.add(text);
        }, (set1, set2) ->
        {
            set1.addAll(set2);
        });
        System.out.println(set);
        stream = createStream();
        Set<String> set1 = stream.parallel().collect(Collectors.toSet());
        System.out.println(set1);
        stream = createStream();
        TreeSet<String> treeSet = stream.parallel().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);
        stream = createStream();
        treeSet = stream.parallel().map(String::toUpperCase).collect(Collectors.toCollection(
                TreeSet::new));
        System.out.println(treeSet);
        stream = createStream();
        String s = stream.parallel().map(String::toUpperCase).collect(Collectors.joining());
        System.out.println(s);
        stream = createStream();
        // 将流中的每个元素字符串使用<->拼接
        s = stream.parallel().map(String::toUpperCase).collect(Collectors.joining("<->"));
        System.out.println(s);
        stream = createStream();
        IntSummaryStatistics summary = stream.collect(Collectors.summarizingInt(String::length));
        double avg = summary.getAverage();
        System.out.println("avg:" + avg);
        double count = summary.getCount();
        System.out.println("count:" + count);
        double max = summary.getMax();
        System.out.println("max:" + max);
        double sum = summary.getSum();
        System.out.println("sum:" + sum);
    }

    public static void collectToMap()
    {
        List<Person> list = Person.createList(10);
        Stream<Person> stream = list.stream();
        Map<Integer, String> idToName = stream.collect(Collectors.toMap(Person::getId,
                Person::getName));
        System.out.println(idToName);
        System.out.println("---------------");
        stream = list.stream();
        Map<Integer, Person> idToPerson = stream.collect(Collectors.toMap(Person::getId, Function
                .identity()));
        System.out.println(idToPerson);
        System.out.println("---------------");
        stream = list.stream();
        Map<String, Person> nameToPerson = stream.collect(Collectors.toMap(Person::getName, Function
                .identity(), (existingValue, newValue) -> newValue));
        System.out.println(nameToPerson);
        System.out.println("---------------");
        stream = list.stream();
        Map<String, List<Person>> listMap = stream.collect(Collectors.groupingBy(Person::getName));
        System.out.println(listMap);
        System.out.println("---------------");
        stream = list.stream();
        Map<Boolean, List<Person>> listMap2 = stream.collect(Collectors.partitioningBy(p -> p
                .getAge() > 20));
        System.out.println(listMap2);
        System.out.println("---------------");
        stream = list.stream();
        Map<String, Set<Person>> nameToPersonSet = stream.collect(Collectors.toMap(Person::getName,
                Collections::singleton, (a, b) ->
                {
                    Set<Person> r = new HashSet<>(a);
                    r.addAll(b);
                    return r;
                }));
        System.out.println(nameToPersonSet);
        System.out.println("---------------");
        Map<String, Set<Integer>> nameToAgeSet = stream.collect(Collectors.toMap(Person::getName,
                p ->
                {
                    Set<Integer> r = new HashSet<>();
                    r.add(p.getAge());
                    return r;
                }, (a, b) ->
                {
                    Set<Integer> r = new HashSet<>(a);
                    r.addAll(b);
                    return r;
                }));
        System.out.println(nameToAgeSet);
        System.out.println("---------------");
        stream = list.stream();
        TreeMap<String, Person> nameToPersonTreeMap = stream.collect(Collectors.toMap(
                Person::getName, Function.identity(), (existingValue, newValue) -> newValue,
                TreeMap::new));
        System.out.println(nameToPersonTreeMap);
        System.out.println("---------------");
    }

    private static Stream<String> createStream()
    {
        String[] array =
        { "AaA", "BbB", "CcC", "DdD", "EeE", "FFgg", "jjcc", "AaA", "AaA", "AAA", "BBB" };
        return Stream.of(array);
    }
}

class Person
{
    private int id;
    private String name;
    private int age;

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    Person(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

    private static Person create(int id)
    {
        SecureRandom rand = new SecureRandom();
        String name = "";
        int i = rand.nextInt(4);
        int age = 0;
        switch (i)
        {
        case 0:
            {
                name = "Axe";
                age = 16;
                break;
            }
        case 1:
            {
                name = "Boc";
                age = 18;
                break;
            }
        case 2:
            {
                name = "Ctu";
                age = 21;
                break;
            }
        default:
            {
                name = "Zx";
                age = 24;
                break;
            }
        }
        return new Person(id, name, age);
    }

    public static List<Person> createList(int maxNumber)
    {
        List<Person> result = new ArrayList<>();
        for (int i = 1, max = maxNumber + 1; i < max; i++)
        {
            result.add(Person.create(i));
        }
        return result;
    }
}