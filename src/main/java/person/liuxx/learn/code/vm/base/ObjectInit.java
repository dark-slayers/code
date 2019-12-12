package person.liuxx.learn.code.vm.base;

import java.util.Objects;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年11月27日 下午4:28:27
 * @since 1.0.0
 */
public class ObjectInit
{
    void init1()
    {
        // 初始化的触发
        // 1、创建类的实例,初始化将在a = new B()时触发。
        B a = null;
        P.s();
        a = new B();
        P.s();
        // 2、类的static方法被调用
        C.f();
        P.s();
        // 3、类的static字段被使用
        P.p(Objects.isNull(D.a) + "");
        P.s();
        // 4、类的static字段被赋值
        D1.a = new A();
        P.s();
    }

    public static void main(String[] args)
    {
        ObjectInit t = new ObjectInit();
        t.init1();
    }
}

class P
{
    static void p(String text)
    {
        System.out.println(text);
    }

    public static void s()
    {
        p("----------");
    }
}

class A
{
    static
    {
        P.p("A init !");
    }
}

class B
{
    static B b = new B();
    static A a = new A();
    static
    {
        P.p("B init !");
    }
}

class C
{
    static
    {
        P.p("C init !");
    }
    static A a = new A();

    static void f()
    {
        P.p("C.f()");
    }
}

class D
{
    static
    {
        P.p("D init !");
    }
    static A a;
}

class D1
{
    static
    {
        P.p("D1 init !");
    }
    static A a;
}