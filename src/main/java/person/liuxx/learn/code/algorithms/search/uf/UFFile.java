package person.liuxx.learn.code.algorithms.search.uf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import person.liuxx.learn.code.algorithms.search.uf.data.Contact;
import person.liuxx.learn.code.config.ElConfig;
import person.liuxx.util.base.StringUtil;

/**
 * @author 刘湘湘
 * 
 * @version 1.0.0<br>
 *          创建时间：2017年11月20日 上午11:29:15
 * 
 * @since 1.0.0
 */
public class UFFile {
    private static Logger log = LoggerFactory.getLogger(UFFile.class);
    private static AnnotationConfigApplicationContext context;
    private static Random rand;
    private static final int TINY_COMPONENTS_NUMBER = 10;
    private static final int MEDIUM_COMPONENTS_NUMBER = 1000;
    private static final int LARGE_COMPONENTS_NUMBER = 1_000_000;
    public static final int MAX = 1_000_000;
    private static final int STEP = 1000;
    static {
        context = new AnnotationConfigApplicationContext(ElConfig.class);
        rand = new Random();
    }

    public static void createTiny() {
        ElConfig config = context.getBean(ElConfig.class);
        create(MAX, STEP, config.getTinyUF(), TINY_COMPONENTS_NUMBER);
    }

    public static void createMedium() {
        ElConfig config = context.getBean(ElConfig.class);
        create(MAX, STEP, config.getMediumUF(), MEDIUM_COMPONENTS_NUMBER);
    }

    public static void createLarge() {
        ElConfig config = context.getBean(ElConfig.class);
        create(MAX, STEP, config.getLargeUF(), LARGE_COMPONENTS_NUMBER);
    }

    public static List<Integer[]> readTIny() {
        ElConfig config = context.getBean(ElConfig.class);
        return readList(config.getTinyUF());
    }

    private static List<Integer[]> readList(Resource resource) {
        List<Integer[]> result = new ArrayList<>();
        try {
            Path target = resource.getFile().toPath();
            result = Files.lines(target)
                    .skip(1)
                    .filter(l -> !StringUtil.isEmpty(l))
                    .filter(l -> l.contains(","))
                    .map(l -> {
                        String[] a = l.split(",");
                        return new Integer[] { Integer.valueOf(a[0]), Integer.valueOf(a[1]) };
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("IOException:{}", e);
        }
        return result;
    }

    private static void create(int max, int step, Resource resource, int number) {
        try {
            Path target = resource.getFile().toPath();
            List<String> list = new ArrayList<>();
            list.add(max + "," + step);
            for (int i = 0; i < number; i++) {
                int id = rand.nextInt(max);
                Contact c = new Contact(id, step, max);
                list.add(c.getId() + "," + c.randomNext().getId());
            }
            Files.write(target, list);
        } catch (IOException e) {
            log.error("IOException:{}", e);
        }
    }
}
