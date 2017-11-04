package util.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by ֣Զ�� on 2017/8/2.
 */
public class DBUtil {
    private static String url;
    private static String userName;
    private static String password;
    private static String driver;
    private static Connection connection;

    static{
        //�������ݿ�������Ϣ��������ص����Ը�ֵ
        loadConfig();
    }

    /**
     * �������ݿ�������Ϣ��������ص����Ը�ֵ
     */
    public static void loadConfig() {
        try {
            InputStream inStream = DBUtil.class
                    .getResourceAsStream("/config/jdbc.properties");
            Properties prop = new Properties();
            prop.load(inStream);
            userName = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            driver= prop.getProperty("jdbc.driver");
            url = prop.getProperty("jdbc.url");
        } catch (Exception e) {
            throw new RuntimeException("��ȡ���ݿ������ļ��쳣��", e);
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver); // ע������
            connection = DriverManager.getConnection(url, userName, password); // ��ȡ����
        } catch (Exception e) {
            throw new RuntimeException("get connection error!", e);
        }
        return connection;
    }

}
