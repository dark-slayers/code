package person.liuxx.learn.code.mvc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;

import person.liuxx.learn.code.mvc.dto.ItemDTO;
import person.liuxx.learn.code.mvc.service.SqlConcurrentService;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年6月22日 下午3:10:22
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SqlConcurrentControllerTest
{
    @Autowired
    SqlConcurrentService projectService;
    @Autowired
    WebApplicationContext context;
    MockMvc mvc;

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年6月22日 下午3:10:22
     * @since 1.0.0
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年6月22日 下午3:10:22
     * @since 1.0.0
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * {@link person.liuxx.learn.code.mvc.controller.SqlConcurrentController#addItem(person.liuxx.learn.code.mvc.dto.ItemDTO)}
     * 的测试方法。
     */
    @Test
    public void testAddItem() throws Exception
    {
        final int max = 3;
        ExecutorService exec = Executors.newFixedThreadPool(max);
        ExecutorCompletionService<String> service = new ExecutorCompletionService<String>(exec);
        service.submit(() ->
        {
            ItemDTO item = new ItemDTO();
            item.setCode("Test000047");
            item.setTakeTime(5);
            item.setNumber(1);
            MvcResult result = post(item);
            String content = result.getResponse().getContentAsString();
            return content;
        });
        service.submit(() ->
        {
            ItemDTO item = new ItemDTO();
            item.setCode("Test000048");
            item.setTakeTime(15);
            item.setNumber(2);
            MvcResult result = post(item);
            String content = result.getResponse().getContentAsString();
            return content;
        });
        service.submit(() ->
        {
            ItemDTO item = new ItemDTO();
            item.setCode("Test000049");
            item.setTakeTime(10);
            item.setNumber(3);
            MvcResult result = post(item);
            String content = result.getResponse().getContentAsString();
            return content;
        });
        List<String> list = new ArrayList<>();
        try
        {
            for (int i = 0; i < max; i++)
            {
                Future<String> f = service.take();
                String s = f.get();
                System.out.println(s);
                list.add(s);
            }
        } catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        } finally
        {
            exec.shutdown();
        }
        assertTrue(true);
    }

    private MvcResult post(ItemDTO item) throws Exception
    {
        String requestBody = JSON.toJSONString(item);
        String url = "/item";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        return result;
    }
}
