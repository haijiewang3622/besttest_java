package day07;

import java.sql.*;
import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * 实现订单管理系统
 *
 * 订单数据:
 *    order_id,  唯一
 *    order_amount(订单金额),
 *    order_user_id(订单付款人id),
 *    order_user_name(订单付款人名字),
 *    order_merchant_id(订单商家id)
 *    order_merchant_name(订单商家名称)
 *
 * 要求:
 *  提供一个机遇客户端输入(Scaner)的程序,界面程序,给出相关选项
 *  如界面如下:
 *      1.创建订单
 *      2.修改订单
 *      3.删除订单
 *      4.查询订单
 *
 *
 *  生成订单,
 *  修改订单,基于order_id进行修改,可能修改的是金额,也可能是其他字段,具体修改啥,不确定
 *  删除订单,基于order_id进行删除
 *  查询,可以查询一条,基于order_id
 *  也可以基于其他字段,查询多条
 *
 * @author haoc
 */

//mysql -uroot -p123456 -h localhost -P3306
public class Topic2 {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/cakes";
    private static final String USER_NAME = "root";
    private static final String PASSWD = "123456";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 输入第一个数：1.创建订单2.修改订单3.删除订单4.查询订单" );
        Integer s1 = Integer.valueOf(scanner.next());
        switch (s1){
            case 1:
                CreateOrder();
                break;
            case 2:
                UpdateOrder();
                break;
            case 3:
                DeleteOrder();
                break;
            case 4:
                SelectOrder();
                break;
            default:
                System.out.println("请重新输入：");
                break;
        }

    }
    //todo 输入的字符串会报错  还没有解决

    public static void CreateOrder() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWD);
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入订单ID：");
        Integer c1 = Integer.valueOf(scanner.next());
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("输入订单金额：");
        Integer c2 = Integer.valueOf(scanner.next());
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("输入用户ID：");
        Integer c3 = Integer.valueOf(scanner.next());
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("输入用户姓名：");
        String c4 = valueOf(scanner.next());
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("输入商户ID：");
        Integer c5 = Integer.valueOf(scanner.next());
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("输入商户姓名：");
        String c6 = valueOf(scanner.next());

        statement.execute("insert into tb_order(order_id,order_amount,order_user_id,order_user_name,order_merchant_id,order_merchant_name) values("+c1+","+c2+","+c3+","+ c4 +","+c5+","+c6+")");
        statement.close();
        connection.close();
    }

    /**
     *
     * @throws SQLException
     */
    public static void UpdateOrder() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWD);
        Statement statement = connection.createStatement();

        statement.executeUpdate("update tb_order set order_user_name = '小红' where order_id =1 ");
        statement.close();
        connection.close();
    }
    /**
     * TODO 待补充：
     * 1、输入订单号不存在，目前没有输出结果；
     * 2、输入不合法的内容
     */
    public static void DeleteOrder() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWD);
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入订单ID：");
        Integer s3 = Integer.valueOf(scanner.next());
        statement.execute("delete from tb_order  where order_id = "+s3);
        statement.close();
        connection.close();
    }
    /**
     * TODO 待补充：
     * 1、输入订单号不存在，目前没有输出结果；
     * 2、输入不合法的内容
     * 3、基于其他字段,查询多条
     */
    public static void SelectOrder() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWD);
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入订单ID：");
        Integer s2 = Integer.valueOf(scanner.next());
        ResultSet resultSet = statement.executeQuery("select * from tb_order  where order_id = "+ s2);

        while (resultSet.next()){
            int order_id = resultSet.getInt("order_id");
            int order_amount = resultSet.getInt("order_amount");
            int order_user_id = resultSet.getInt("order_user_id");
            String order_user_name = resultSet.getString("order_user_name");
            int order_merchant_id = resultSet.getInt("order_merchant_id");
            String order_merchant_name = resultSet.getString("order_merchant_name");
            String info = String.format("order order_id=%s,order_amount=%s,order_user_id=%s,order_user_name=%s,order_merchant_id=%s,order_merchant_name=%s", order_id, order_amount,order_user_id,order_user_name,order_merchant_id,order_merchant_name);
            System.out.println(info);

        }
        resultSet.close();
        statement.close();
        connection.close();
    }



}
