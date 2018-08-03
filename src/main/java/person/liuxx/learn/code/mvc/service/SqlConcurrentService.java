package person.liuxx.learn.code.mvc.service;

import java.util.Optional;

import person.liuxx.learn.code.mvc.domain.Item;
import person.liuxx.learn.code.mvc.dto.ItemDTO;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2018年6月22日 上午9:58:03
* @since 1.0.0 
*/
public interface SqlConcurrentService
{
    Optional<Item> saveItem(ItemDTO item);
}
