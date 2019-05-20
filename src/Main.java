import java.sql.*;
public class Main {
    private final static String url = "jdbc:postgresql://localhost:5432/2019-05-20_Morning_Classwork";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    public static void Exercise1(Connection conn) throws SQLException
    {

//        Create a new Los Angeles entry for Papers with any code that cost 90.1.
//        String SQL = " INSERT INTO boxes(code,contents,value,warehouse) VALUES('L9T0','Papers',90.1,4)";
        String SQL = "select * from warehouses";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next())
        {
            System.out.println(1);
        }


    }

    public static void Exercise2(Connection conn) throws SQLException
    {
//        Select the warehouse code and the average value of the boxes in each warehouse.
        String SQL = "select warehouse, avg(value) from warehouses left join boxes b on warehouses.code = b.warehouse group by warehouse";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next())
        {
            System.out.print(rs.getString(1) + "\t");
            System.out.println(rs.getString(2) + "\t");

        }


    }

    public static void Exercise3(Connection conn) throws SQLException
    {
//        Select the warehouse code and the average value of the boxes in each warehouse,
//        but select only those warehouses where the average value of the boxes is greater than 150.
        String SQL = "select warehouse , avg(value) from boxes where value > 150 group by warehouse";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while (rs.next())
        {
            System.out.print(rs.getString(1) + "\t");
            System.out.println(rs.getString(2) + "\t");

        }
    }

    public static void Exercise4(Connection conn) throws SQLException
    {
//        Find all values per each content in the Boxes table.
        String SQL = "select contents,sum(value) from boxes group by contents";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while (rs.next())
        {
            System.out.print(rs.getString(1) + "\t");
            System.out.println(rs.getString(2) + "\t");

        }
    }

    public static void Exercise5(Connection conn) throws SQLException
    {
//        Find all values per each content in the Boxes table.
        String SQL = "select sum(value) from boxes";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while (rs.next())
        {
            System.out.print(rs.getString(1) + "\t");

        }
    }

    public static void Exercise6(Connection conn) throws SQLException
    {
//       Reduce the value of all boxes by 15%.
//        String SQL = "update boxes set value = value *.85";
        String SQL = "select value from boxes";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while (rs.next())
        {
            System.out.print(rs.getString(1) + "\t");

        }
    }


    public static void Exercise7(Connection conn) throws SQLException
    {
//      Remove all boxes with a value lower than $100.
        String SQL = "select * from boxes";
//        String SQL = "delete  from boxes where value < 100";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while (rs.next())
        {
            System.out.print(rs.getString(1) + "\t");
            System.out.print(rs.getString(2) + "\t");
            System.out.println(rs.getString(3) + "\t");

        }
    }


    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
//            Exercise1(conn);
//            Exercise2(conn);
//            Exercise3(conn);
//            Exercise4(conn);
//            Exercise5(conn);
//            Exercise6(conn);
            Exercise7(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        connect();
    }
}
    // jdbc:postgresql://localhost:5432/2019-05-20_Morning_Classwork
