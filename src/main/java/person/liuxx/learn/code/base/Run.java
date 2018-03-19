package person.liuxx.learn.code.base;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年9月30日 上午9:38:55
 * @since 1.0.0
 */
public class Run
{
    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年9月30日 上午9:38:55
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        a();
    }

    static void a()
    {
        int[] a =
        { 0, 1, 10 };
        int[] b =
        { 0, 1, 10 };
        System.out.println(a == b);
        System.out.println(Objects.equals(a, b));
        System.out.println(Arrays.equals(a, b));
        int[][] array = new int[240][3];
        int[][] inputArray =
        {
                { 0, 0, 67 },
                { 1, 0, 47 },
                { 3, 0, 51 },
                { 3, 13, 6 },};
        int index = 0;
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 24; y++)
            {
                array[index] = new int[]
                { x, y, 0 };
                Stream<int[]> stream = Stream.of(inputArray);
                int xf = x;
                int yf = y;
                Optional<int[]> op = stream.filter(ia -> Objects.equals(xf, ia[0]) && Objects
                        .equals(yf, ia[1])).findAny();
                int indexF = index;
                op.ifPresent(ia ->
                {
                    array[indexF] = ia;
                });
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String s = String.join(",", Stream.of(array).map(ia -> Arrays.toString(ia)).collect(
                Collectors.toList()));
        sb.append(s);
        sb.append("];");
        System.out.println(sb);
    }
}
