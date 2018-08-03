package person.liuxx.learn.code.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年6月22日 下午1:24:59
 * @since 1.0.0
 */
@Entity
@Table(name = "item")
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private int number;
    @Column(name = "start_time")
    private LocalDateTime startTime;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public LocalDateTime getStartTime()
    {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }

    @Override
    public String toString()
    {
        return "Item [id=" + id + ", code=" + code + ", number=" + number + ", startTime="
                + startTime + "]";
    }
}
