package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddStaff {
    public AddStaff(Connection conn) {

        final int[] counter = {0};

        JFrame addstaffform = new JFrame("Add Staff");
        addstaffform.setSize(300, 300);

        JLabel namel = new JLabel("Name");
        JTextArea name = new JTextArea();
        namel.setBounds(10, 10, 100, 30);
        name.setBounds(10, 40, 130, 25);

        JLabel lastnamel = new JLabel("Lastname");
        JTextArea lastname = new JTextArea();
        lastnamel.setBounds(160, 10, 100, 30);
        lastname.setBounds(160, 40, 130, 25);

        JLabel usernamel = new JLabel("Username");
        JTextArea username = new JTextArea();
        usernamel.setBounds(10, 60, 100, 30);
        username.setBounds(10, 90, 130, 25);

        JLabel passwordl = new JLabel("Password");
        JTextArea password = new JTextArea();
        passwordl.setBounds(160, 60, 100, 30);
        password.setBounds(160, 90, 130, 25);

        JLabel kindl = new JLabel("What's his/her position?");
        JTextArea kind = new JTextArea();
        kindl.setBounds(10, 110, 200, 30);
        kind.setBounds(10, 140, 130, 25);

        JButton apply = new JButton("Apply");
        apply.setBounds(110, 180, 80, 30);


        ActionListener actionListener = e -> {

            try {

                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM UserPass where kind = '" + kind.getText() + "' ;");

                while (rs.next()) {
                    counter[0]++;
                }
                System.out.println(counter[0]);
                rs.close();

            } catch (Exception r) {
                r.getMessage();
            }

            try {
                if (kind.getText().equals("driver")) {

                    String insertsql = "INSERT INTO UserPass (personid  , name  ,lastname ,username ,password , kind ) VALUES (?,  ? , ? ,? ,? ,? );";
                    PreparedStatement preparedStatement = conn.prepareStatement(insertsql);
                    preparedStatement.setInt(1, 9801 + counter[0]);
                    preparedStatement.setString(2, name.getText());
                    preparedStatement.setString(3, lastname.getText());
                    preparedStatement.setString(4, username.getText());
                    preparedStatement.setString(5, password.getText());
                    preparedStatement.setString(6, "driver");
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Completed");
                    name.setText(null);
                    lastname.setText(null);
                    username.setText(null);
                    password.setText(null);
                    kind.setText(null);
                    kind.setBackground(Color.white);

                } else if (kind.getText().equals("staff")) {

                    PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO UserPass (personid  , name  ,lastname ,username ,password , kind ) VALUES (?,  ? , ?,? ,? ,? );");
                    preparedStatement.setInt(1, 9701 + counter[0]);
                    preparedStatement.setString(2, name.getText());
                    preparedStatement.setString(3, lastname.getText());
                    preparedStatement.setString(4, username.getText());
                    preparedStatement.setString(5, password.getText());
                    preparedStatement.setString(6, "staff");
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Completed");
                    name.setText(null);
                    lastname.setText(null);
                    username.setText(null);
                    password.setText(null);
                    kind.setText(null);
                    kind.setBackground(Color.white);

                }else {

                    JOptionPane.showMessageDialog(null, "Wrong Position");
                    kind.setBackground(Color.lightGray);

                }
            } catch (SQLException e1) {
                e1.getSQLState();
            }
        };
        apply.addActionListener(actionListener);


        addstaffform.add(name);
        addstaffform.add(namel);
        addstaffform.add(lastname);
        addstaffform.add(lastnamel);
        addstaffform.add(password);
        addstaffform.add(passwordl);
        addstaffform.add(usernamel);
        addstaffform.add(username);
        addstaffform.add(apply);
        addstaffform.add(kind);
        addstaffform.add(kindl);
        addstaffform.setLocationRelativeTo(null);
        addstaffform.setResizable(false);
        addstaffform.setLayout(null);
        addstaffform.setVisible(true);


    }
}
