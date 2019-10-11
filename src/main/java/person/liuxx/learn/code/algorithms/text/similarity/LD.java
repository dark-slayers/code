package person.liuxx.learn.code.algorithms.text.similarity;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年9月2日 下午3:23:54
 * @since 1.0.0
 */
public class LD
{
    public static void main(String args[])
    {
        String str1 = "hello";
        String str2 = "hello world";
        System.out.println("calDistance : " + calDistance(str1, str2));
        System.out.println(str1 + " is " + calSimilar(str1, str2) + " similar to " + str2);
        System.out.println(str2 + " is " + calSimilar(str2, str1) + " similar to " + str1);
    }

    // 计算编辑距离
    public static int calDistance(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0)
        {
            return len2;
        }
        if (len2 == 0)
        {
            return len1;
        }
        int d[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
        {// 初始化第一列
            d[i][0] = i;
        }
        for (int j = 0; j <= len2; j++)
        {// 初始化第一行
            d[0][j] = j;
        }
        int eq = 0;
        char char1, char2;
        for (int i = 1; i <= len1; i++)
        {
            char1 = str1.charAt(i - 1);
            for (int j = 1; j <= len2; j++)
            {
                char2 = str2.charAt(j - 1);
                if (char1 == char2 || char1 + 32 == char2 || char1 - 32 == char2)
                {
                    eq = 0;
                } else
                {
                    eq = 1;
                }
                d[i][j] = Math.min(d[i - 1][j - 1] + eq, Math.min(d[i][j - 1] + 1, d[i - 1][j]
                        + 1));
            }
        }
        return d[len1][len2];
    }

    // 计算相似度
    public static double calSimilar(String str1, String str2)
    {
        if (str1 == null || str2 == null || (str1.length() == 0 && str2.length() == 0))
        {
            return 0;
        }
        return 1 - ((double)calDistance(str1, str2) / Math.max(str1.length(), str2.length()));
    }
}
