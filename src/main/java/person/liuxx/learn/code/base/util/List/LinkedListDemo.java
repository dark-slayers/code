package person.liuxx.learn.code.base.util.List;

import person.liuxx.learn.code.algorithms.data.LinkedListOne;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年5月17日 上午9:23:50
 * @since 1.0.0
 */
public class LinkedListDemo
{
    public void run()
    {
        testGC();
    }

    public void testGC()
    {
        LinkedListOne<String> list = new LinkedListOne<>();
        for (int i = 0; i < 10000; i++)
        {
            list.add("AAACFDKLGJSDFL;KGJLS;DFKJGS;LDFHKJ");
        }
        list.clear();
        System.gc();
    }
}
