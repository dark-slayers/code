package person.liuxx.learn.code.concurrent.util;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年6月26日 上午10:57:05
 * @since 1.0.0
 */
public class CountDownLatch
{
    private long count;

    /**
     * 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年6月26日 上午10:59:03
     * @since 1.0.0
     */
    public void await()
    {
    }

    /**
     * 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年6月26日 上午10:59:09
     * @since 1.0.0
     * @param timeout
     * @param unit
     * @return
     */
    boolean await(long timeout, TimeUnit unit)
    {
        return false;
    }

    /**
     * 递减锁存器的计数，如果计数到达零，则释放所有等待的线程。
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年6月26日 上午10:59:12
     * @since 1.0.0
     */
    void countDown()
    {
        synchronized (this)
        {
            count--;
        }
    }

    /**
     * 返回当前计数。
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年6月26日 上午10:59:16
     * @since 1.0.0
     * @return
     */
    long getCount()
    {
        return count;
    }

    /**
     * 返回标识此锁存器及其状态的字符串。
     */
    @Override
    public String toString()
    {
        return "";
    }
}
