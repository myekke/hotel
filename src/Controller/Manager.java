package Controller;

import Information.RoomInfo;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager {
    public Manager(Connection conn) throws Exception {

        JFrame managerform = new JFrame("Manager");
        managerform.setSize(560, 570);

        JTextArea search = new JTextArea();
        search.setBounds(10, 10, 200, 30);
        JButton searchbtn = new JButton("Search");
        searchbtn.setBounds(230, 10, 80, 30);
        JLabel label = new JLabel("Search Result");
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setBounds(10, 50, 400, 420);

        ImageIcon water = new ImageIcon("send.png");
        JButton sendmessagebtn = new JButton(water);
        sendmessagebtn.setBounds(330, 10, 30, 30);

        ImageIcon water2 = new ImageIcon("recieve.png");
        JButton messagebtn = new JButton(water2);
        messagebtn.setBounds(370, 10, 30, 30);

        JLabel gymincomel = new JLabel("Gym Income");
        JTextArea gymincome = new JTextArea();
        gymincomel.setBounds(430, 10, 120, 30);
        gymincome.setBounds(430, 40, 120, 30);

        JLabel landryincomel = new JLabel("Landry Income");
        JTextArea landryincome = new JTextArea();
        landryincomel.setBounds(430, 80, 120, 30);
        landryincome.setBounds(430, 110, 120, 30);

        JLabel restaurantincomel = new JLabel("Restaurant Income");
        JTextArea restaurantincome = new JTextArea();
        restaurantincomel.setBounds(430, 150, 120, 30);
        restaurantincome.setBounds(430, 180, 120, 30);

        JLabel poolincomel = new JLabel("Pool Income");
        JTextArea poolincome = new JTextArea();
        poolincomel.setBounds(430, 220, 120, 30);
        poolincome.setBounds(430, 250, 120, 30);

        JLabel hotelincomel = new JLabel("Hotel Income");
        JTextArea hotelincome = new JTextArea();
        hotelincomel.setBounds(430, 290, 120, 30);
        hotelincome.setBounds(430, 320, 120, 30);

        JLabel staffincomel = new JLabel("Staff Income");
        JTextArea staffincome = new JTextArea();
        staffincomel.setBounds(430, 360, 120, 30);
        staffincome.setBounds(430, 390, 120, 30);

        JLabel driverincomel = new JLabel("Driver Income");
        JTextArea driverincome = new JTextArea();
        driverincomel.setBounds(430, 430, 120, 30);
        driverincome.setBounds(430, 460, 120, 30);

        JButton addbtn = new JButton("Add Staff");
        addbtn.setBounds(30, 490, 100, 30);

        JButton bankbtnever = new JButton("Account");
        bankbtnever.setBounds(150, 490, 100, 30);

        JButton infobtn = new JButton("Info");
        infobtn.setBounds(270, 490, 100, 30);

        ActionListener actionListener1 = e -> new RequestForStaff(conn, "Manager");
        sendmessagebtn.addActionListener(actionListener1);

        ActionListener actionListener2 = e -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Message where Getteruser = 'managerofhotel' ;");
                JFrame chatbox = new JFrame("Received Massage");
                chatbox.setSize(300, 300);
                JLabel label2 = new JLabel("Not yet");
                JPanel panel2 = new JPanel();
                JScrollPane jScrollPane2 = new JScrollPane(panel2);
                jScrollPane2.setBounds(10, 10, 280, 260);
                String chat = "<html>";
                while (resultSet.next()) {
                    chat = chat.concat(resultSet.getString("Senderuser") + ": " + resultSet.getString("text") + " <br/> " + "--------------------" + " <br/> ");
                }
                chat = chat.concat("</html>");
                label2.setText(chat);

                panel2.add(label2);
                chatbox.add(jScrollPane2);
                chatbox.setLocationRelativeTo(null);
                chatbox.setResizable(false);
                chatbox.setLayout(null);
                chatbox.setVisible(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        };
        messagebtn.addActionListener(actionListener2);

        ActionListener actionListener3 = e -> new AddStaff(conn);
        addbtn.addActionListener(actionListener3);

        ActionListener actionListener4 = e -> {
            String[] name = search.getText().split(" ");
            try {
                Statement statement = conn.createStatement();
                ResultSet rs1 = statement.executeQuery("SELECT * FROM SingleRoomTable where name = '" + name[0] + "' AND  Lastname = '" + name[1] + "' ;");
                String roomnumber = "";
                while (rs1.next()) {
                    roomnumber = roomnumber + rs1.getInt("Roomnumber") + " | ";
                }
                rs1.close();
                ResultSet rs2 = statement.executeQuery("SELECT * FROM DoubleRoomEconomyTable where name1 = '" + name[0] + "' AND  lastname1 = '" + name[1] + "' or name2 = '" + name[0] + "' AND  lastname2 = '" + name[1] + "';");
                while (rs2.next()) {
                    roomnumber = roomnumber + rs2.getInt("Roomnumber") + " | ";
                }
                rs2.close();
                ResultSet rs3 = statement.executeQuery("SELECT * FROM DoubleRoomQueenTable where name1 = '" + name[0] + "' AND  lastname1 = '" + name[1] + "' or name2 = '" + name[0] + "' AND  lastname2 = '" + name[1] + "';");
                while (rs3.next()) {
                    roomnumber = roomnumber + rs3.getInt("Roomnumber") + " | ";
                }
                rs3.close();
                ResultSet rs4 = statement.executeQuery("SELECT * FROM DoubleRoomKingTable where name1 = '" + name[0] + "' AND  lastname1 = '" + name[1] + "' or name2 = '" + name[0] + "' AND  lastname2 = '" + name[1] + "';");
                while (rs4.next()) {
                    roomnumber = roomnumber + rs4.getInt("Roomnumber") + " | ";
                }
                rs4.close();
                ResultSet rs5 = statement.executeQuery("SELECT * FROM TripleRoomEconomyTable where name1 = '" + name[0] + "' AND  lastname1 = '" + name[1] + "' or name2 = '" + name[0] + "' AND  lastname2 = '" + name[1] + "' or name3 = '" + name[0] + "' AND  lastname3 = '" + name[1] + "' ;");
                while (rs5.next()) {
                    roomnumber = roomnumber + rs5.getInt("Roomnumber") + " | ";
                }
                rs5.close();
                ResultSet rs6 = statement.executeQuery("SELECT * FROM TripleRoomQueenTable where name1 = '" + name[0] + "' AND  lastname1 = '" + name[1] + "' or name2 = '" + name[0] + "' AND  lastname2 = '" + name[1] + "' or name3 = '" + name[0] + "' AND  lastname3 = '" + name[1] + "' ;");
                while (rs6.next()) {
                    roomnumber = roomnumber + rs6.getInt("Roomnumber") + " | ";
                }
                rs6.close();
                ResultSet rs8 = statement.executeQuery("SELECT * FROM TripleRoomKingTable where name1 = '" + name[0] + "' AND  lastname1 = '" + name[1] + "' or name2 = '" + name[0] + "' AND  lastname2 = '" + name[1] + "' or name3 = '" + name[0] + "' AND  lastname3 = '" + name[1] + "' ;");
                while (rs8.next()) {
                    roomnumber = roomnumber + rs8.getInt("Roomnumber") + " | ";
                }
                rs8.close();
                ResultSet rs7 = statement.executeQuery("SELECT * FROM QuadRoomVipTable where name1 = '" + name[0] + "' AND  lastname1 = '" + name[1] + "' or name2 = '" + name[0] + "' AND  lastname2 = '" + name[1] + "' or name3 = '" + name[0] + "' AND  lastname3 = '" + name[1] + "' or name4 = '" + name[0] + "' AND  lastname4 = '" + name[1] + "' ;");
                while (rs7.next()) {
                    roomnumber = roomnumber + rs7.getInt("Roomnumber") + " | ";
                }
                rs7.close();
                ResultSet rs9 = statement.executeQuery("SELECT * FROM QuadRoomMasterTable where name1 = '" + name[0] + "' AND  lastname1 = '" + name[1] + "' or name2 = '" + name[0] + "' AND  lastname2 = '" + name[1] + "' or name3 = '" + name[0] + "' AND  lastname3 = '" + name[1] + "' or name4 = '" + name[0] + "' AND  lastname4 = '" + name[1] + "' ;");
                while (rs9.next()) {
                    roomnumber = roomnumber + rs9.getInt("Roomnumber") + " | ";
                }
                rs9.close();

                if (roomnumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Doesn't Exist");
                } else {
                    JOptionPane.showMessageDialog(null, "Room:" + roomnumber);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        };
        searchbtn.addActionListener(actionListener4);

        ActionListener actionListener5 = e -> {
            try {
                new Bankmanager(conn);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        };
        bankbtnever.addActionListener(actionListener5);

        ActionListener actionListener6 = e -> new RoomInfo(conn);
        infobtn.addActionListener(actionListener6);

        String text = "<html>";
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM SingleRoomTable WHERE phone IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " Single" + " <br/> " + "-------------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM DoubleRoomEconomyTable WHERE phone1 IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " Double" + " <br/> " + "------------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM TripleRoomEconomyTable WHERE phone1 IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " Triple" + " <br/> " + "-----------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM QuadRoomVipTable WHERE phone1 IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " Quad" + " <br/> " + "-----------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        text = text.concat("</html>");
        label.setText(text);


        try {
            Statement stincome = conn.createStatement();
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM GymTable ;");
            int gymcost = 0;
            while (rs6.next()) {
                gymcost = gymcost + rs6.getInt("cost");
            }
            rs6.close();
            gymincome.setText(String.valueOf(gymcost));
            gymincome.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stincome = conn.createStatement();
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM LandryTable ;");
            int landrycost = 0;
            while (rs6.next()) {
                landrycost = landrycost + rs6.getInt("cost");
            }
            rs6.close();
            landryincome.setText(String.valueOf(landrycost));
            landryincome.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stincome = conn.createStatement();
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM PoolTable ;");
            int poolcost = 0;
            while (rs6.next()) {
                poolcost = poolcost + rs6.getInt("cost");
            }
            rs6.close();
            poolincome.setText(String.valueOf(poolcost));
            poolincome.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stincome = conn.createStatement();
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM RestaurantTable ;");
            int restaurantcost = 0;
            while (rs6.next()) {
                restaurantcost = restaurantcost + rs6.getInt("cost");
            }
            rs6.close();
            restaurantincome.setText(String.valueOf(restaurantcost));
            restaurantincome.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stincome = conn.createStatement();
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM CleansStaffTable ;");
            int staffcost = 0;
            while (rs6.next()) {
                staffcost = staffcost + rs6.getInt("cost");
            }
            rs6.close();
            staffincome.setText(String.valueOf(staffcost));
            staffincome.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stincome = conn.createStatement();
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM DriverTable ;");
            int drivercost = 0;
            while (rs6.next()) {
                drivercost = drivercost + rs6.getInt("cost");
            }
            rs6.close();
            driverincome.setText(String.valueOf(drivercost));
            driverincome.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stincome = conn.createStatement();
            ResultSet rs6 = stincome.executeQuery("SELECT * FROM HotelAccount ;");
            int hotelcost = 0;
            while (rs6.next()) {
                hotelcost = hotelcost + rs6.getInt("fee");
            }
            rs6.close();
            hotelincome.setText(String.valueOf(hotelcost));
            hotelincome.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        panel.add(label);
        managerform.add(infobtn);
        managerform.add(bankbtnever);
        managerform.add(messagebtn);
        managerform.add(sendmessagebtn);
        managerform.add(addbtn);
        managerform.add(hotelincome);
        managerform.add(hotelincomel);
        managerform.add(search);
        managerform.add(searchbtn);
        managerform.add(jScrollPane);
        managerform.add(gymincome);
        managerform.add(gymincomel);
        managerform.add(restaurantincome);
        managerform.add(restaurantincomel);
        managerform.add(poolincome);
        managerform.add(poolincomel);
        managerform.add(landryincome);
        managerform.add(landryincomel);
        managerform.add(staffincome);
        managerform.add(staffincomel);
        managerform.add(driverincome);
        managerform.add(driverincomel);
        managerform.setLocationRelativeTo(null);
        managerform.setResizable(false);
        managerform.setLayout(null);
        managerform.setVisible(true);


    }
}
