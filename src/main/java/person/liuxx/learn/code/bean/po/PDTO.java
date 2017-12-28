package person.liuxx.learn.code.bean.po;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月30日 上午11:39:41
 * @since 1.0.0
 */
public class PDTO
{
    private int id;
    private String number;
    private String startDate;

    public PDTO()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    @Override
    public String toString()
    {
        return "PDTO [id=" + id + ", number=" + number + ", startDate=" + startDate + "]";
    }
}
