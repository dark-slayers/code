package person.liuxx.learn.code.javascript;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年9月15日 下午1:42:58
 * @since 1.0.0
 */
public class RunScript
{
    static void a() throws IOException
    {
        List<String> list = Files.readAllLines(Paths.get("D:/temp/kuai.txt"));
        list.stream().map(l ->
        {
            Script script = getScript(l);
            A a = script.getA();
            return a.getCookie();
        }).forEach(System.out::println);
    }

    static Script getScript(String s)
    {
        Pattern pattern = Pattern.compile("<script language=\"javascript\">.*?</script>");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find())
        {
            return new Script(matcher.group());
        }
        return null;
    }

    String h1 = "";

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年9月15日 下午1:42:58
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            a();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

class A
{
    int[] array;
    int q1;
    int q2;
    int q3;
    int q4;
    int q5;
    int q6;
    int q7;
    int q8;
    int q9;
    int q10;
    int q11;
    int q12;
    int q13;
    int q14;

    String r()
    {
        int qo = q2;
        do
        {
            array[qo] = (-array[qo]) & 0xff;
            array[qo] = (((array[qo] >> q3) | ((array[qo] << q4) & 0xff)) - q5) & 0xff;
        } while (--qo >= 2);
        qo = q6;
        do
        {
            array[qo] = (array[qo] - array[qo - 1]) & 0xff;
        } while (--qo >= 3);
        qo = 1;
        for (;;)
        {
            if (qo > q7)
                break;
            array[qo] = ((((((array[qo] + q8) & 0xff) + q9) & 0xff) << q10) & 0xff) | (((((array[qo]
                    + q11) & 0xff) + q12) & 0xff) >> q13);
            qo++;
        }
        String po = "";
        for (qo = 1; qo < array.length - 1; qo++)
        {
            if (qo % q14 != 0)
                po += String.valueOf((char) (array[qo] ^ q1));
        }
        return po;
    }

    String getCookie()
    {
        String s = r();
        String cookie = s.split(";")[0].substring(17);
        return cookie;
    }

    @Override
    public String toString()
    {
        return "A [array=" + Arrays.toString(array) + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3
                + ", q4=" + q4 + ", q5=" + q5 + ", q6=" + q6 + ", q7=" + q7 + ", q8=" + q8 + ", q9="
                + q9 + ", q10=" + q10 + ", q11=" + q11 + ", q12=" + q12 + ", q13=" + q13 + ", q14="
                + q14 + "]";
    }
}

class Script
{
    private String script;
    private String text;

    /**
     * @param group
     */
    public Script(String script)
    {
        this.script = script;
    }

    A getA()
    {
        A a = new A();
        int endIndex = script.indexOf(")\",");
        text = script.substring(0, endIndex).trim();
        int beginIndex = text.lastIndexOf("(");
        text = text.substring(beginIndex + 1).trim();
        a.q1 = Integer.valueOf(text);
        text = script.substring(endIndex).trim();
        beginIndex = text.indexOf("oo = [");
        text = text.substring(beginIndex + 6).trim();
        endIndex = text.indexOf("];");
        String arrayText = text.substring(0, endIndex).trim();
        String[] textArray = arrayText.split(",");
        a.array = new int[textArray.length];
        for (int i = 0, max = textArray.length; i < max; i++)
        {
            a.array[i] = Integer.valueOf(textArray[i].substring(2).trim(), 16);
        }
        text = text.substring(endIndex + 1).trim();
        a.q2 = getNumber("\"qo=", ";");
        a.q3 = getNumber(">>", ")");
        a.q4 = getNumber("<<", ")");
        a.q5 = getNumber("))-", ")");
        a.q6 = getNumber("eval(qo);qo =", ";");
        a.q7 = getNumber("if (qo >", ")");
        a.q8 = getNumber("(oo[qo] +", ")");
        a.q9 = getNumber("0xff) +", ")");
        a.q10 = getNumber("<<", ")");
        a.q11 = getNumber("(oo[qo] +", ")");
        a.q12 = getNumber("0xff) +", ")");
        a.q13 = getNumber(">>", ")");
        a.q14 = getNumber("%", ")");
        return a;
    }

    int getNumber(String begin, String end)
    {
        int beginIndex = text.indexOf(begin);
        text = text.substring(beginIndex + begin.length()).trim();
        int endIndex = text.indexOf(end);
        return Integer.valueOf(text.substring(0, endIndex).trim());
    }
}