package person.liuxx.learn.code.vm.classfile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月14日 下午4:38:18
 * @since 1.0.0
 */
public final class AccessFlagsUtil
{
    private AccessFlagsUtil()
    {
        throw new AssertionError("工具类禁止实例化！");
    }

    public static void show(String label, Map<Integer, String> map, int flag)
    {
        System.out.println(label + " accessFlags : " + QueueUtil.intToHexString(flag));
        List<String> flags = getAccessFlags(map, flag);
        System.out.println(label + " accessFlags : " + flags);
    }

    public static List<String> getAccessFlags(Map<Integer, String> map, int flag)
    {
        List<String> result = new ArrayList<>();
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Set<Set<Integer>> allSubList = getAllSubList(map.keySet().size());
        Set<Integer> findSet = new HashSet<>();
        for (Set<Integer> set : allSubList)
        {
            if (flag == sum(keyList, set))
            {
                findSet = set;
                break;
            }
        }
        for (Integer k : findSet)
        {
            result.add(map.get(keyList.get(k)));
        }
        return result;
    }

    private static int sum(List<Integer> keyList, Set<Integer> set)
    {
        return set.stream().mapToInt(keyList::get).sum();
    }

    static void test(int size)
    {
        // Map<Integer, String> map = FieldInfo.getAccessFlagsMap();
        // List<Integer> keyList = new ArrayList<>(map.keySet());
        // System.out.println(keyList);
        // Set<Integer> ss=new HashSet<>();
        // ss.add(0);
        // ss.add(6);
        // System.out.println(sum(keyList, ss));
        // Set<Set<Integer>> allSubList = getAllSubList(8);
        // System.out.println(allSubList);
        System.out.println(getSubList(2, 8));
        // Set<Integer> findSet = new HashSet<>();
        // for (Set<Integer> set : allSubList)
        // {
        // if (18 == sum(keyList, set))
        // {
        // findSet = set;
        // break;
        // }
        // }
        // System.out.println(findSet);
        // List<String> list=getAccessFlags(map,18);
        // System.out.println(list);
    }

    private static Set<Set<Integer>> getAllSubList(int size)
    {
        Set<Set<Integer>> result = new HashSet<>();
        for (int j = 0; j < size; j++)
        {
            result.addAll(getSubList(j, size));
        }
        return result;
    }

    private static Set<Set<Integer>> getSubList(int number, int size)
    {
        Set<Set<Integer>> result = new HashSet<>();
        List<Integer> indexList = new ArrayList<>(number);
        for (int i = 0; i < number; i++)
        {
            indexList.add(i);
        }
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>(number);
        int listIndex = 0;
        for (;;)
        {
            if (i > size - 1)
            {
                break;
            }
            System.out.println("listIndex : " + listIndex + ", j : " + j);
            indexList.set(i, j);
            Set<Integer> copyList = new HashSet<>(indexList);
            System.out.println("copyList : " + copyList);
            if (copyList.size() == number)
            {
                result.add(copyList);
            }
            j++;
            if (j > size - 1)
            {
                for (;;)
                {
                    if (i > number - 1)
                    {
                        break;
                    }
                    if (indexList.get(listIndex) < size)
                    {
                        break;
                    }
                    j = 0;
                    i++;
                }
            }
        }
        return result;
    }
}
