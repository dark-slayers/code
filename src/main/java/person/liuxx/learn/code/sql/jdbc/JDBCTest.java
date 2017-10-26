package person.liuxx.learn.code.sql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月11日 上午10:39:47
 * @since 1.0.0
 */
public class JDBCTest
{
    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月11日 上午10:39:47
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://" + "192.168.25.101" + ":1433";
            String user = "username";
            String password = "password";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.close();
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
