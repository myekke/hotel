package Service;

import Controller.RequestForStaff;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class DriverStaff {
    public DriverStaff(Connection conn, int driver_id) {
        JFrame driverform = new JFrame("DriverStaff");
        driverform.setSize(400, 420);

        JLabel drivernamel = new JLabel("Name(DriverStaff)");
        JTextArea drivername = new JTextArea();
        drivernamel.setBounds(20, 10, 100, 30);
        drivername.setBounds(20, 40, 100, 25);

        JLabel driverlastnamel = new JLabel("LastName(DriverStaff)");
        JTextArea driverlastname = new JTextArea();
        driverlastnamel.setBounds(140, 10, 130, 30);
        driverlastname.setBounds(140, 40, 130, 25);

        JLabel roomnumberl = new JLabel("Room number");
        JTextArea roomnumber = new JTextArea();
        roomnumberl.setBounds(20, 100, 100, 30);
        roomnumber.setBounds(20, 130, 80, 25);

        JLabel namel = new JLabel("Name");
        JTextArea name = new JTextArea();
        namel.setBounds(120, 100, 100, 30);
        name.setBounds(120, 130, 100, 25);

        JLabel lastnamel = new JLabel("Last Name");
        JTextArea lastname = new JTextArea();
        lastnamel.setBounds(240, 100, 100, 30);
        lastname.setBounds(240, 130, 100, 25);

        JLabel datel = new JLabel("Date");
        JTextArea day = new JTextArea();
        datel.setBounds(20, 170, 100, 30);
        day.setBounds(20, 200, 40, 25);

        JTextArea month = new JTextArea();
        month.setBounds(70, 200, 40, 25);

        JTextArea year = new JTextArea("2018");
        year.setBounds(120, 200, 70, 25);

        JLabel indexl = new JLabel("Index");
        JTextArea index = new JTextArea();
        indexl.setBounds(20, 240, 100, 30);
        index.setBounds(20, 270, 100, 25);

        JLabel costl = new JLabel("Cost");
        JTextArea cost = new JTextArea();
        costl.setBounds(240, 170, 120, 30);
        cost.setBounds(240, 200, 120, 25);

        JLabel incomel = new JLabel("Income");
        JTextArea income = new JTextArea();
        incomel.setBounds(20, 320, 120, 30);
        income.setBounds(20, 350, 120, 25);

        JButton continuebtn = new JButton("Apply");
        continuebtn.setBounds(220, 350, 80, 30);

        try {
            Statement st3 = conn.createStatement();
            ResultSet rs1 = st3.executeQuery("SELECT * from UserPass where '" + driver_id + "';");
            for (int i = 0; i < (driver_id - 9800) + 2; i++) {
                rs1.next();
            }
            drivername.setText(rs1.getString("name"));
            driverlastname.setText(rs1.getString("lastname"));
            drivername.setEnabled(false);
            driverlastname.setEnabled(false);
        } catch (Exception r) {
            r.getMessage();
        }

        ImageIcon water1 = new ImageIcon("send.png");
        JButton sendmessagebtn = new JButton(water1);
        sendmessagebtn.setBounds(350, 350, 30, 30);

        ActionListener actionListener3 = e -> new RequestForStaff(conn, "Driver" + (9800 - driver_id));
        sendmessagebtn.addActionListener(actionListener3);

        ImageIcon water = new ImageIcon("recieve.png");
        JButton messagebtn = new JButton(water);
        messagebtn.setBounds(310, 350, 30, 30);

        ActionListener actionListener1 = e -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Message where Getteruser = 'driver" + (driver_id - 9800) + "' ;");
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
                String insertSQL = "INSERT INTO DriverTable (driverid  , drivername ,driverlastname , name,lastname ,RoomNumber ,cost , useday , usemonth ,useyear , driverindex) VALUES (?,  ? , ? ,? ,? ,?, ? , ? ,?, ? , ? );";
                PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
                preparedStatement.setInt(1, driver_id);
                preparedStatement.setString(2, drivername.getText());
                preparedStatement.setString(3, driverlastname.getText());
                preparedStatement.setString(4, name.getText());
                preparedStatement.setString(5, lastname.getText());
                preparedStatement.setInt(6, Integer.parseInt(roomnumber.getText()));
                preparedStatement.setInt(7, Integer.parseInt(cost.getText()));
                preparedStatement.setInt(8, Integer.parseInt(day.getText()));
                preparedStatement.setInt(9, Integer.parseInt(month.getText()));
                preparedStatement.setInt(10, Integer.parseInt(year.getText()));
                preparedStatement.setInt(11, Integer.parseInt(index.getText()));
                preparedStatement.executeUpdate();
            } catch (Exception e1) {
                e1.getMessage();
            }
            JOptionPane.showMessageDialog(null, "Done");
            name.setText(null);
            lastname.setText(null);
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
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM DriverTable ;");
            int drivercost = 0;
            while (rs6.next()) {
                drivercost = drivercost + rs6.getInt("cost");
            }
            rs6.close();
            income.setText(String.valueOf(drivercost));
            income.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        driverform.add(sendmessagebtn);
        driverform.add(messagebtn);
        driverform.add(driverlastname);
        driverform.add(drivername);
        driverform.add(driverlastnamel);
        driverform.add(drivernamel);
        driverform.add(index);
        driverform.add(indexl);
        driverform.add(name);
        driverform.add(namel);
        driverform.add(lastname);
        driverform.add(lastnamel);
        driverform.add(datel);
        driverform.add(day);
        driverform.add(month);
        driverform.add(year);
        driverform.add(income);
        driverform.add(incomel);
        driverform.add(cost);
        driverform.add(costl);
        driverform.add(continuebtn);
        driverform.add(roomnumber);
        driverform.add(roomnumberl);
        driverform.setLocationRelativeTo(null);
        driverform.setResizable(false);
        driverform.setLayout(null);
        driverform.setVisible(true);

    }
}
