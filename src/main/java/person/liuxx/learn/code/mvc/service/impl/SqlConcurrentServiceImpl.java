package person.liuxx.learn.code.mvc.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import person.liuxx.learn.code.mvc.dao.ItemRepository;
import person.liuxx.learn.code.mvc.domain.Item;
import person.liuxx.learn.code.mvc.dto.ItemDTO;
import person.liuxx.learn.code.mvc.service.SqlConcurrentService;
import person.liuxx.util.service.exception.SaveException;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年6月22日 上午9:57:53
 * @since 1.0.0
 */
@Service
public class SqlConcurrentServiceImpl implements SqlConcurrentService
{
    private Logger log = LoggerFactory.getLogger(SqlConcurrentServiceImpl.class);
    @Autowired
    private ItemRepository itemDao;

    /**
     *spring事务是单例，将隔离性设置为Isolation.SERIALIZABLE在并发的情况下会导致后续
     */
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public synchronized Optional<Item> saveItem(ItemDTO item)
    {
        if (itemDao.findByCode(item.getCode()).size() == 0)
        {
            try
            {
                int takeTime = item.getTakeTime();
                log.info("take time : {}", takeTime);
                Thread.sleep(item.getTakeTime() * 1000);
                Item saveItem = item.createItem();
                saveItem.setStartTime(LocalDateTime.now());
                log.info("save item : {}", LocalDateTime.now());
                Item sqlItem = itemDao.save(saveItem);
                log.info("sqlItem : {}", sqlItem);
                return Optional.ofNullable(sqlItem);
            } catch (InterruptedException e)
            {
                throw new SaveException("Thread.sleep 出现异常！", e);
            }
        }
        return Optional.empty();
    }
}
