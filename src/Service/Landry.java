package Service;

import Controller.RequestForStaff;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Landry {
    public Landry(Connection conn) {
        JFrame landryfrom = new JFrame("Landry");
        landryfrom.setSize(400, 350);

        JLabel roomnumberl = new JLabel("Room number");
        JTextArea roomnumber = new JTextArea();
        roomnumberl.setBounds(20, 30, 100, 30);
        roomnumber.setBounds(20, 60, 80, 25);

        JLabel namel = new JLabel("Name");
        JTextArea name = new JTextArea();
        namel.setBounds(120, 30, 100, 30);
        name.setBounds(120, 60, 100, 25);

        JLabel lastnamel = new JLabel("Last Name");
        JTextArea lastname = new JTextArea();
        lastnamel.setBounds(240, 30, 100, 30);
        lastname.setBounds(240, 60, 100, 25);

        JLabel datel = new JLabel("Date");
        JTextArea day = new JTextArea();
        datel.setBounds(20, 100, 100, 30);
        day.setBounds(20, 130, 40, 25);

        JTextArea month = new JTextArea();
        month.setBounds(70, 130, 40, 25);

        JTextArea year = new JTextArea("2018");
        year.setBounds(120, 130, 70, 25);

        JLabel indexl = new JLabel("Index");
        JTextArea index = new JTextArea();
        indexl.setBounds(20, 170, 100, 30);
        index.setBounds(20, 200, 100, 25);

        JLabel costl = new JLabel("Cost");
        JTextArea cost = new JTextArea();
        costl.setBounds(240, 100, 120, 30);
        cost.setBounds(240, 130, 120, 25);

        JLabel incomel = new JLabel("Income");
        JTextArea income = new JTextArea();
        incomel.setBounds(20, 250, 120, 30);
        income.setBounds(20, 280, 120, 25);

        JButton continuebtn = new JButton("Apply");
        continuebtn.setBounds(220, 280, 80, 30);

        ImageIcon water1 = new ImageIcon("send.png");
        JButton sendmessagebtn = new JButton(water1);
        sendmessagebtn.setBounds(350, 280, 30, 30);

        ActionListener actionListener3 = e -> new RequestForStaff(conn, "Landry");
        sendmessagebtn.addActionListener(actionListener3);


        ImageIcon water = new ImageIcon("recieve.png");
        JButton messagebtn = new JButton(water);
        messagebtn.setBounds(310, 280, 30, 30);

        ActionListener actionListener1 = e -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Message where Getteruser = 'landryofhotel';");
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
                String insertSQL = "INSERT INTO LandryTable (RoomNumber, name,lastname  ,cost , useday , usemonth ,useyear , landryindex ) VALUES (?, ? , ? , ? ,? ,? ,?, ? );";
                PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
                preparedStatement.setInt(1, Integer.parseInt(roomnumber.getText()));
                preparedStatement.setString(2, name.getText());
                preparedStatement.setString(3, lastname.getText());
                preparedStatement.setInt(4, Integer.parseInt(cost.getText()));
                preparedStatement.setInt(5, Integer.parseInt(day.getText()));
                preparedStatement.setInt(6, Integer.parseInt(month.getText()));
                preparedStatement.setInt(7, Integer.parseInt(year.getText()));
                preparedStatement.setInt(8, Integer.parseInt(index.getText()));
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
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM LandryTable ;");
            int landrycost = 0;
            while (rs6.next()) {
                landrycost = landrycost + rs6.getInt("cost");
            }
            rs6.close();
            income.setText(String.valueOf(landrycost));
            income.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        landryfrom.add(sendmessagebtn);
        landryfrom.add(messagebtn);
        landryfrom.add(index);
        landryfrom.add(indexl);
        landryfrom.add(name);
        landryfrom.add(namel);
        landryfrom.add(lastname);
        landryfrom.add(lastnamel);
        landryfrom.add(datel);
        landryfrom.add(day);
        landryfrom.add(month);
        landryfrom.add(year);
        landryfrom.add(income);
        landryfrom.add(incomel);
        landryfrom.add(cost);
        landryfrom.add(costl);
        landryfrom.add(continuebtn);
        landryfrom.add(roomnumber);
        landryfrom.add(roomnumberl);
        landryfrom.setLocationRelativeTo(null);
        landryfrom.setResizable(false);
        landryfrom.setLayout(null);
        landryfrom.setVisible(true);
    }
}
