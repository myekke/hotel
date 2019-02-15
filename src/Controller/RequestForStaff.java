package Controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RequestForStaff {
    public RequestForStaff(Connection conn , String usermessage) {
        JFrame reqform = new JFrame("Request Form");
        reqform.setSize(300, 250);

        JLabel userl = new JLabel("Username");
        JTextArea user = new JTextArea();
        userl.setBounds(10 , 10 , 80 , 30);
        user.setBounds(10 , 40 , 120 , 25 );

        JLabel messagel = new JLabel("Message");
        JTextArea message = new JTextArea();
        messagel.setBounds(10 , 75 , 80 , 30);
        message.setBounds(10 , 105 , 280 , 50);


        JButton sendbtn = new JButton("Send");
        sendbtn.setBounds(110 , 165 , 80 , 30);

        ActionListener actionListener = e -> {
            try {
                String insertSQL = "INSERT INTO Message (Senderuser, Getteruser,text) VALUES ( ? ,? ,? );";
                PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
                preparedStatement.setString(1, usermessage);
                preparedStatement.setString(2, user.getText());
                preparedStatement.setString(3, message.getText());
                preparedStatement.executeUpdate();
            } catch (Exception e1) {
                e1.getMessage();
            }
            JOptionPane.showMessageDialog(null, "Sent");
            user.setText(null);
            message.setText(null);
        };
        sendbtn.addActionListener(actionListener);

        reqform.add(user);
        reqform.add(userl);
        reqform.add(message);
        reqform.add(messagel);
        reqform.add(sendbtn);
        reqform.setLocationRelativeTo(null);
        reqform.setResizable(false);
        reqform.setLayout(null);
        reqform.setVisible(true);


    }
}
