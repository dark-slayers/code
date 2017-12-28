package person.liuxx.learn.code.algorithms.search.uf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import person.liuxx.learn.code.algorithms.search.uf.data.Contact;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月3日 下午2:29:30
 * @since 1.0.0
 */
public class UFRun
{
    private static Logger log = LoggerFactory.getLogger(UFRun.class);

    static void createFile()
    {
        UFFile.createTiny();
        UFFile.createMedium();
        UFFile.createLarge();
    }

    static void runTest()
    {
        UF uf = new UF2(10);
        List<Integer[]> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++)
        {
            int id = rand.nextInt(10);
            Contact c = new Contact(id, 5, 9);
            Integer[] ele = new Integer[]
            { c.getId(), c.randomNext().getId() };
            list.add(ele);
        }
        for (Integer[] i : list)
        {
            int p = i[0];
            int q = i[1];
            log.info("参数输入：{}<->{}", p, q);
            if (uf.connected(p, q))
            {
                continue;
            }
            uf.union(p, q);
            log.info("归并分量");
        }
        log.info("uf.count()：{}", uf.count());
        log.info("uf.find(6)：{}", uf.find(6));
        log.info("uf.find(7)：{}", uf.find(7));
        log.info("uf.find(8)：{}", uf.find(8));
        log.info("uf.find(9)：{}", uf.find(9));
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月3日 下午2:29:30
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        runTest();
    }
}
