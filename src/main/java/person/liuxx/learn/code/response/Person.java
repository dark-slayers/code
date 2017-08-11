package person.liuxx.learn.code.response;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月11日 下午4:07:54
 * @since 1.0.0
 */
public class Person
{
    public Person()
    {
    }

    public Person(Long id, String name, Integer age, String address)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private Long id;
    private String name;
    private Integer age;
    private String address;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address
                + "]";
    }
}
