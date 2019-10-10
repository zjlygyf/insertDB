package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDB {
	
	private static final String user = "root";

    private static final String pwd = "root";

    private static final String url = "jdbc:mysql://localhost:3306/eshop";

    private static final String driver = "com.mysql.jdbc.Driver";

    public static Connection getCon() {

        Connection con = null;

        try {

            Class.forName(driver).newInstance();

            con = DriverManager.getConnection(url, user, pwd);

            if (con != null) {

                System.out.println("�������ӵ����ݿ⣺" + con.getCatalog());

            }

        } catch (Exception e) {

            System.out.println("�������ݿ�ʧ�ܣ�");

            e.printStackTrace();

        }

        return con;

    } 

    public boolean insertDB(String classname, String classteacher, String classplace) {

        Connection con = null;

        Statement stm = null;

        boolean flag = false;

        String sql = "insert into school values('" + classname  + "','" + classteacher + "','"

                + classplace + "')";

        try {

            con = getCon();

            stm = con.createStatement();

            int i = stm.executeUpdate(sql);

            if (i > 0) {

                flag = true;

                System.out.println(flag + "�������ݳɹ���");

            }

        } catch (Exception e) {

            flag = false;

            e.printStackTrace();

        } finally {

            close(null, stm, con);

        }

        return flag;

    }

    //�ر��������

    public void close(ResultSet rs, Statement stm, Connection con) {

        if (rs != null)

            try {

                rs.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        if (stm != null)

            try {

                stm.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        if (con != null)

            try {

                con.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

    }

}
