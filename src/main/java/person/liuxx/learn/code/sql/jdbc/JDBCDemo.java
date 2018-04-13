package person.liuxx.learn.code.sql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月4日 上午11:33:53
 * @since 1.0.0
 */
public class JDBCDemo
{
    static final String SQL_SERVICE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";

    public static void demo()
    {
        String sql = "SELECT * FROM user";
        // 带参数的SQL语句执行应使用PreparedStatement，
        // 使用PreparedStatement可以提高性能（数据库会对预编译语句进行优化）和安全性（防止参数中的SQL注入）
        String prepareSql = "SELECT * FROM user WHERE name = ?";
        // 打开数据库连接需要较大的开销，项目中建议使用连接池
        try (Connection conn = conn();
                Statement statement = conn.createStatement();
                PreparedStatement pstmt = conn.prepareStatement(prepareSql);)
        {
            statement.executeUpdate("INSERT INTO user VALUES('AAA',15)");
            try (ResultSet rs = statement.executeQuery(sql);)
            {
                while (rs.next())
                {
                    System.out.println(rs.getString(1));
                }
            }
            // 执行PreparedStatement之前，必须设置参数值
            pstmt.setString(1, "AAA");
            try (ResultSet rs = pstmt.executeQuery();)
            {
                while (rs.next())
                {
                    System.out.println(rs.getString(1));
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static Connection conn()
    {
        // MySQL jdbc: mysql://192.168.12.11:3306/aa?useSSL=true
        // ORACLE jdbc: oracle: thin: @//192.168.12.11:1521/aa
        String url = "jdbc:sqlserver://192.168.12.11:1433";
        String username = "username";
        String password = "password";
        Connection conn = null;
        try
        {
            Class.forName(SQL_SERVICE_DRIVER);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
