package person.liuxx.learn.code.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月20日 上午11:32:37
 * @since 1.0.0
 */
@Configuration
@ComponentScan
public class ElConfig
{
    @Value("classpath:algorithms/tinyUF.txt")
    private Resource tinyUF;
    @Value("classpath:algorithms/mediumUF.txt")
    private Resource mediumUF;
    @Value("classpath:algorithms/largeUF.txt")
    private Resource largeUF;

    public Resource getTinyUF()
    {
        return tinyUF;
    }

    public Resource getMediumUF()
    {
        return mediumUF;
    }

    public Resource getLargeUF()
    {
        return largeUF;
    }

}
