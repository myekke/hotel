package Service;

import Controller.RequestForStaff;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Restaurant {
    public Restaurant(Connection conn) {
        JFrame restaurantform = new JFrame("Restaurant");
        restaurantform.setSize(400, 350);

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

        ActionListener actionListener3 = e -> new RequestForStaff(conn, "Restaurant");
        sendmessagebtn.addActionListener(actionListener3);

        ImageIcon water = new ImageIcon("recieve.png");
        JButton messagebtn = new JButton(water);
        messagebtn.setBounds(310, 280, 30, 30);

        ActionListener actionListener1 = e -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Message where Getteruser = 'restaurantofhotel';");
                JFrame chatbox = new JFrame("Received Massage");
                chatbox.setSize(300, 300);
                JLabel label = new JLabel("Not yet");
                JPanel panel = new JPanel();
                JScrollPane jScrollPane = new JScrollPane(panel);
                jScrollPane.setBounds(10, 10, 280, 260);
                String chat = "<html>";
                while (resultSet.next()){
                    chat = chat.concat(resultSet.getString("Senderuser")+": " + resultSet.getString("text") + " <br/> "+ "--------------------" +" <br/> " );
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
                String insertSQL = "INSERT INTO RestaurantTable ( RoomNumber, name,lastname  ,cost , useday , usemonth ,useyear , restaurantindex ) VALUES (?, ? , ? , ? ,? ,? ,?, ?  );";
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
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM RestaurantTable ;");
            int restaurantcost = 0;
            while (rs6.next()) {
                restaurantcost = restaurantcost + rs6.getInt("cost");
            }
            rs6.close();
            income.setText(String.valueOf(restaurantcost));
            income.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        restaurantform.add(sendmessagebtn);
        restaurantform.add(messagebtn);
        restaurantform.add(index);
        restaurantform.add(indexl);
        restaurantform.add(name);
        restaurantform.add(namel);
        restaurantform.add(lastname);
        restaurantform.add(lastnamel);
        restaurantform.add(datel);
        restaurantform.add(day);
        restaurantform.add(month);
        restaurantform.add(year);
        restaurantform.add(income);
        restaurantform.add(incomel);
        restaurantform.add(cost);
        restaurantform.add(costl);
        restaurantform.add(continuebtn);
        restaurantform.add(roomnumber);
        restaurantform.add(roomnumberl);
        restaurantform.setLocationRelativeTo(null);
        restaurantform.setResizable(false);
        restaurantform.setLayout(null);
        restaurantform.setVisible(true);
    }
}
