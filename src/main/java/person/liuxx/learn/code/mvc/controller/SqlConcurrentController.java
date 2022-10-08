package person.liuxx.learn.code.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import person.liuxx.learn.code.mvc.domain.Item;
import person.liuxx.learn.code.mvc.dto.ItemDTO;
import person.liuxx.learn.code.mvc.service.SqlConcurrentService;
import person.liuxx.util.service.exception.SaveException;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年6月22日 下午3:02:33
 * @since 1.0.0
 */
@RestController
@Api(value = "数据库并发测试控制器")
public class SqlConcurrentController
{
    @Autowired
    private SqlConcurrentService service;

    @ApiOperation(value = "添加Item", notes = "添加Item")
    @ApiImplicitParam(name = "item", value = "item", required = true, dataType = "ItemDTO")
    @PostMapping("/item")
    public Item addItem(@RequestBody ItemDTO item)
    {
        return service.saveItem(item).<SaveException>orElseThrow(() ->
        {
            throw new SaveException("添加item失败：" + item);
        });
    }
}
