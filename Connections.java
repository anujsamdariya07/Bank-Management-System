package bank.management.system;

import java.sql.*;

// 5 steps:-
// 1. Register the driver.
// 2. Create connection.
// 3. Create statement.
// 4. Execute query.
// 5. CLose connection.

public class Connections
{
    Connection c;
    Statement s;
    Connections()
    {
        try
        {
            c = DriverManager.getConnection
                    ("jdbc:mysql:///bankmanagementsystem",
                            "root", "root");
            s = c.createStatement();
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        new Connections();
    }
}
