package General;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by VenD on 4/8/2019.
 */
public class DBConnection {
     public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://bystoredstage.cu7blggvl4kd.eu-west-2.rds.amazonaws.com:3306/bystored_QA1";

    public static final String USER = "bystored";
    public static final String PASS = "bystored";
    public static  Connection conn = null;
    public static Statement stmt = null;
    public static String sql;
    public static String email;
    //public static String allFactors;
    public static ArrayList<String> allFactor = new ArrayList<String>();


    public static Connection connectDb() throws SQLException {



//    Statement stmt = null;

        //STEP 2: Register JDBC driver
//        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
//        conn = DriverManager.getConnection(DB_URL,USER,PASS);

    conn=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("DataBase is connected...");

        //STEP 4: Execute a query

//        stmt = conn.createStatement();
//        String sql;
//        sql = "select * from users order by id desc";
//        ResultSet rs = stmt.executeQuery(sql);
//
//        while (rs.next()) {
//            System.out.println(rs.getInt(1));
//        }
//
////    int id  = rs.getInt("id");
////    System.out.print("ID: " + id);
//    rs.close();
//    stmt.close();
//    conn.close();allFactor
 return conn;


    }

    public static ArrayList<String> GetStairsInfo(String email) throws SQLException {

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
//        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("DataBase is connected...");

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();

        sql = "select job_factor_identifier from job_parameters where booking_id=(select id from bookings where orderRef=(select id from orders where user=(select id from users where email= 'test379@bystored.com'))) ";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getString(1));
            allFactor.add(rs.getString("job_factor_identifier"));
           // allFactors = rs.getString("job_factor_identifier");

        }

        System.out.println(allFactor);

//    int id  = rs.getInt("id");
//    System.out.print("ID: " + id);
        rs.close();
        stmt.close();
        conn.close();
        return allFactor;




    }


    public static void closeDB() throws SQLException
    {


        conn.close();
    }


}
