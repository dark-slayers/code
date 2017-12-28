package person.liuxx.learn.code.bean.po;

import java.time.LocalDate;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2017年11月30日 上午11:37:55
* @since 1.0.0 
*/
public class P
{
    private int id;
    private String number;
    private LocalDate startDate;
    public P(){
        
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
    public LocalDate getStartDate()
    {
        return startDate;
    }
    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }
    @Override
    public String toString()
    {
        return "P [id=" + id + ", number=" + number + ", startDate=" + startDate + "]";
    }
    
}
