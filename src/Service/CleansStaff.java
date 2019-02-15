package Service;

import Controller.RequestForStaff;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class CleansStaff {
    public CleansStaff(Connection conn, int staff_id) {
        JFrame cleansstaff = new JFrame("Staff");
        cleansstaff.setSize(350, 420);

        JLabel staffnamel = new JLabel("Name(Staff)");
        JTextArea staffname = new JTextArea();
        staffnamel.setBounds(20, 10, 100, 30);
        staffname.setBounds(20, 40, 100, 25);

        JLabel stafflastnamel = new JLabel("LastName(Staff)");
        JTextArea stafflastname = new JTextArea();
        stafflastnamel.setBounds(140, 10, 130, 30);
        stafflastname.setBounds(140, 40, 130, 25);

        JLabel roomnumberl = new JLabel("Room number");
        JTextArea roomnumber = new JTextArea();
        roomnumberl.setBounds(20, 100, 100, 30);
        roomnumber.setBounds(20, 130, 80, 25);

        JLabel datel = new JLabel("Date");
        JTextArea day = new JTextArea();
        datel.setBounds(120, 100, 100, 30);
        day.setBounds(120, 130, 40, 25);

        JTextArea month = new JTextArea();
        month.setBounds(170, 130, 40, 25);

        JTextArea year = new JTextArea("2018");
        year.setBounds(220, 130, 70, 25);

        JLabel indexl = new JLabel("Index");
        JTextArea index = new JTextArea();
        indexl.setBounds(20, 170, 100, 30);
        index.setBounds(20, 200, 100, 25);

        JLabel costl = new JLabel("Cost");
        JTextArea cost = new JTextArea();
        costl.setBounds(170, 170, 120, 30);
        cost.setBounds(170, 200, 120, 25);

        JLabel incomel = new JLabel("Income");
        JTextArea income = new JTextArea();
        incomel.setBounds(20, 320, 120, 30);
        income.setBounds(20, 350, 120, 25);

        JButton continuebtn = new JButton("Apply");
        continuebtn.setBounds(180, 347, 80, 30);

        ImageIcon water1 = new ImageIcon("send.png");
        JButton sendmessagebtn = new JButton(water1);
        sendmessagebtn.setBounds(310, 347, 30, 30);

        ActionListener actionListener3 = e -> new RequestForStaff(conn, "Staff" + (staff_id - 9700));
        sendmessagebtn.addActionListener(actionListener3);


        ImageIcon water = new ImageIcon("recieve.png");
        JButton messagebtn = new JButton(water);
        messagebtn.setBounds(270, 347, 30, 30);

        try {
            Statement st3 = conn.createStatement();
            ResultSet rs1 = st3.executeQuery("SELECT * from UserPass where personid = '" + staff_id + "';");
            rs1.next();
            staffname.setText(rs1.getString("name"));
            stafflastname.setText(rs1.getString("lastname"));
            staffname.setEnabled(false);
            stafflastname.setEnabled(false);
            rs1.close();
        } catch (Exception r) {
            r.getMessage();
        }


        ActionListener actionListener1 = e -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Message where Getteruser = 'staff" + (staff_id - 9700) + "' ;");
                JFrame chatbox = new JFrame("Received Massage");
                chatbox.setSize(300, 300);
                JLabel label = new JLabel("Not yet");
                JPanel panel = new JPanel();
                JScrollPane jScrollPane = new JScrollPane(panel);
                jScrollPane.setBounds(10, 10, 280, 260);
                String chat = "<html>";
                while (resultSet.next()) {
                    chat = chat.concat(resultSet.getString("Senderuser") + ": " + resultSet.getString("text") + " <br/> " + "--------------------" + " <br/> ");
                }
                chat = chat.concat("</html>");
                label.setText(chat);

                panel.add(label);
                chatbox.add(jScrollPane);
                chatbox.setLocationRelativeTo(null);
                chatbox.setResizable(false);
                chatbox.setLayout(null);
                chatbox.setVisible(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        };
        messagebtn.addActionListener(actionListener1);


        ActionListener actionListener2 = e -> {
            try {
                String insertSQL = "INSERT INTO CleansStaffTable ( staffid , staffname ,stafflastname ,RoomNumber ,cost , useday , usemonth ,useyear , staffindex) VALUES ( ? , ? , ? ,?, ? , ? ,?, ? , ? );";
                PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
                preparedStatement.setInt(1, staff_id);
                preparedStatement.setString(2, staffname.getText());
                preparedStatement.setString(3, stafflastname.getText());
                preparedStatement.setInt(4, Integer.parseInt(roomnumber.getText()));
                preparedStatement.setInt(5, Integer.parseInt(cost.getText()));
                preparedStatement.setInt(6, Integer.parseInt(day.getText()));
                preparedStatement.setInt(7, Integer.parseInt(month.getText()));
                preparedStatement.setInt(8, Integer.parseInt(year.getText()));
                preparedStatement.setInt(9, Integer.parseInt(index.getText()));
                preparedStatement.executeUpdate();
            } catch (Exception e1) {
                e1.getMessage();
            }
            JOptionPane.showMessageDialog(null, "Done");
            roomnumber.setText(null);
            cost.setText(null);
            day.setText(null);
            month.setText(null);
            year.setText(null);
            index.setText(null);
        };
        continuebtn.addActionListener(actionListener2);

        try {
            Statement stincome = conn.createStatement();
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM CleansStaffTable where staffid = '"+ staff_id +"' ;");
            int staffcost = 0;
            while (rs6.next()) {
                staffcost = staffcost + rs6.getInt("cost");
            }
            rs6.close();
            income.setText(String.valueOf(staffcost));
            income.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cleansstaff.add(sendmessagebtn);
        cleansstaff.add(messagebtn);
        cleansstaff.add(stafflastname);
        cleansstaff.add(staffname);
        cleansstaff.add(stafflastnamel);
        cleansstaff.add(staffnamel);
        cleansstaff.add(index);
        cleansstaff.add(indexl);
        cleansstaff.add(datel);
        cleansstaff.add(day);
        cleansstaff.add(month);
        cleansstaff.add(year);
        cleansstaff.add(income);
        cleansstaff.add(incomel);
        cleansstaff.add(cost);
        cleansstaff.add(costl);
        cleansstaff.add(continuebtn);
        cleansstaff.add(roomnumber);
        cleansstaff.add(roomnumberl);
        cleansstaff.setLocationRelativeTo(null);
        cleansstaff.setResizable(false);
        cleansstaff.setLayout(null);
        cleansstaff.setVisible(true);
    }
}
