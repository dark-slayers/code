package person.liuxx.learn.code.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import person.liuxx.learn.code.mvc.domain.Item;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年6月22日 下午2:37:36
 * @since 1.0.0
 */
public interface ItemRepository extends JpaRepository<Item, Long>
{
    List<Item> findByCode(String code);
}
