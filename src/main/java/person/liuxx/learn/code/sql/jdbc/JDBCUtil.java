package person.liuxx.learn.code.sql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月4日 上午11:33:53
 * @since 1.0.0
 */
public class JDBCUtil
{
    public JDBCUtil()
    {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + "192.168.25.101" + ":1433";
        String username = "username";
        String password = "password";
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            statement.close();
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}
