package person.liuxx.learn.code.net.httpclient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.hc.client5.http.impl.sync.CloseableHttpClient;
import org.apache.hc.client5.http.impl.sync.HttpClients;
import org.apache.hc.client5.http.protocol.ClientProtocolException;
import org.apache.hc.client5.http.sync.methods.HttpGet;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.ResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Objects;

import person.liuxx.util.log.LogUtil;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月29日 上午8:30:32
 * @since 1.0.0
 */
public class ProxyLearn
{
    private static Logger log = LogManager.getLogger();

    static void test()
    {
        try (CloseableHttpClient httpclient = HttpClients.createDefault())
        {
            final HttpGet httpget = new HttpGet("http://www.goubanjia.com/free/index3.shtml");
            httpget.addHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36");
            log.info("Executing request {} -> {}", httpget.getMethod(), httpget.getUri());
            final ResponseHandler<String> responseHandler = new ResponseHandler<String>()
            {
                @Override
                public String handleResponse(final ClassicHttpResponse response) throws IOException
                {
                    final int status = response.getCode();
                    if (status >= HttpStatus.SC_SUCCESS && status < HttpStatus.SC_REDIRECTION)
                    {
                        log.info("获取服务器相应：{}", status);
                        final HttpEntity entity = response.getEntity();
                        try
                        {
                            return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
                        } catch (final ParseException ex)
                        {
                            throw new ClientProtocolException(ex);
                        }
                    } else
                    {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            final String responseBody = httpclient.execute(httpget, responseHandler);
            Document doc = Jsoup.parse(responseBody);
            Element table = doc.getElementById("list");
            Elements trs = table.getElementsByTag("tr");
            List<String> list = new ArrayList<>();
            for (Element tr : trs)
            {
                Elements tds = tr.getElementsByTag("td");
                if (tds.size() > 1)
                {
                    Element td = tds.get(0);
                    Elements spans = td.getElementsByAttributeValueNot("style", "display: none;");
                    log.info("td.size():{}", spans.size());
                    log.info("-------------");
                    // log.info("td:{}", td);
                    StringBuilder text = new StringBuilder();
                    for (Element e : spans)
                    {
                        if (Objects.equal(e.attr("style"), "display:none;"))
                        {
                            continue;
                        }
                        if (Objects.equal(e.tagName(), "td"))
                        {
                            continue;
                        }
                        if (spans.size() - spans.indexOf(e) == 1)
                        {
                            text.append(":");
                        }
                        log.info("td.style:{}", e.attr("style"));
                        log.info("td.tagName():{}", e.tagName());
                        log.info("td.text():{}", e.text());
                        log.info("-------------");
                        text.append(e.text());
                    }
                    list.add(text.toString());
                }
            }
            log.info("list:{}", list);
            String[] array = list.get(0).split(" ");
            System.out.println(Arrays.toString(array));
            list.stream().map(l -> l).filter(a -> a.contains(".")).forEach(a ->
            {
                System.out.println(a);
                System.out.println(a);
                System.out.println("------");
            });
        } catch (IOException | URISyntaxException e)
        {
            log.error(LogUtil.errorInfo(e));
        }
    }

    public static void main(String[] args)
    {
        test();
    }
}
