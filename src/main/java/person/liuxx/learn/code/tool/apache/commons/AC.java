package person.liuxx.learn.code.tool.apache.commons;

import java.time.LocalDate;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月26日 下午2:51:04
 * @since 1.0.0
 */
public class AC
{
    private String name;
    private LocalDate date;
    private int number;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "AC [name=" + name + ", date=" + date + ", number=" + number + "]";
    }
}
