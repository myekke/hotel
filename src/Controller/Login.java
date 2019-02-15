package Controller;

import Service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.sql.*;

public class Login {
    public Login(Connection conn ) {

        JFrame loginform = new JFrame("Hotel Login");
        loginform.setSize(270, 420);

        ImageIcon water1 = new ImageIcon("Hotel.png");
        JButton imagebtn = new JButton(water1);
        imagebtn.setBounds(40, 40, 190, 190);
        loginform.add(imagebtn);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 250, 80, 25);
        loginform.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 250, 160, 25);
        loginform.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 280, 80, 25);
        loginform.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 280, 160, 25);
        loginform.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(85, 320, 100, 30);
        loginform.add(loginButton);

        ActionListener loginbtn = (e) -> {
            String usernamein;
            String passwordin;
            usernamein = String.valueOf(userText.getText());
            passwordin = String.valueOf(passwordText.getText());
            String sql = "Select * from UserPass where username=? and password=? ";
            try {
                PreparedStatement pst;
                ResultSet rs;
                pst = conn.prepareStatement(sql);
                pst.setString(1, usernamein);
                pst.setString(2, passwordin);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("personid");
                    if (id == 9901) {
                        try {
                            new Manager(conn);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                    if (id == 9902) new Reception(conn );
                    for (int i = 0; i < 50; i++) {
                        if (id == (9801 + i)) {
                            new DriverStaff(conn, id);
                            break;
                        }
                    }
                    for (int i = 0; i < 50; i++) {
                        if (id == (9701 + i)) {
                            new CleansStaff(conn, id);
                            break;
                        }
                    }
                    if (id == 9601) new Gym(conn);
                    if (id == 9501) new Restaurant(conn);
                    if (id == 9401) new Pool(conn);
                    if (id == 9301) new Landry(conn);

                } else {
                    JOptionPane.showMessageDialog(null, "username and password do not matched");
                }
            } catch (SQLException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        };
        loginButton.addActionListener(loginbtn);
        loginform.setLocationRelativeTo(null);
        loginform.setResizable(false);
        loginform.setLayout(null);
        loginform.setVisible(true);
    }
}
