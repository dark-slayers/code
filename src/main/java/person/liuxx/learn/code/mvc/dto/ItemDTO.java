package person.liuxx.learn.code.mvc.dto;

import person.liuxx.learn.code.mvc.domain.Item;
import person.liuxx.util.bean.LocalDateBeanUtil;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年6月22日 下午1:25:09
 * @since 1.0.0
 */
public class ItemDTO
{
    private String code;
    private int takeTime;
    private int number;

    public Item createItem()
    {
        Item item = new Item();
        LocalDateBeanUtil.copyProperties(item, this);
        return item;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public int getTakeTime()
    {
        return takeTime;
    }

    public void setTakeTime(int takeTime)
    {
        this.takeTime = takeTime;
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
        return "ItemDTO [code=" + code + ", takeTime=" + takeTime + ", number=" + number + "]";
    }
}
