package Controller;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("waiting for server ...");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "12345678");
        conn.setAutoCommit(true);
        new Login(conn);
    }
}
