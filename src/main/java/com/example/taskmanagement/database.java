package com.example.taskmanagement;

import java.sql.Connection;
import java.sql.DriverManager;

class database {
    public static Connection connectDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // CONNECT DATABASE
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/plan",
                    "root","password"
            );
            return connect;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
