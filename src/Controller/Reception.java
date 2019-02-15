package Controller;

import Information.Enterinformation;
import Information.ExitPay;
import Information.RoomInfo;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reception {
    public Reception(Connection conn  ) {

        JFrame receptionform = new JFrame("Reception");
        receptionform.setSize(440, 440);

        JTextArea search = new JTextArea();
        search.setBounds(10, 10, 330, 25);

        JButton searchbtn = new JButton("Search");
        searchbtn.setBounds(350, 10, 80, 25);

        JButton signup = new JButton("Sign up");
        signup.setBounds(20, 50, 80, 35);

        JButton exitpay = new JButton("Exitpay");
        exitpay.setBounds(20, 100, 80, 35);

        JButton information = new JButton("Info");
        information.setBounds(20, 150, 80, 35);

        ImageIcon water1 = new ImageIcon("send.png");
        JButton sendmessagebtn = new JButton(water1);
        sendmessagebtn.setBounds(20, 360, 35, 35);

        ImageIcon water2 = new ImageIcon("recieve.png");
        JButton messagebtn = new JButton(water2);
        messagebtn.setBounds(65, 360, 35, 35);

        JLabel label = new JLabel("Rooms & Situation");
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setBounds(120, 50, 300, 340);

        String text = "<html>";
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM SingleRoomTable WHERE phone IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " Single" + " <br/> " + "-----------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM DoubleRoomEconomyTable WHERE phone1 IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " Double" + " <br/> " + "----------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM TripleRoomEconomyTable WHERE phone1 IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " Triple" + " <br/> " + "---------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM QuadRoomVipTable WHERE phone1 IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " Quad" + " <br/> " + "---------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        text = text.concat("</html>");
        label.setText(text);


        ActionListener signupaction = e -> {
            try {
                new Enterinformation(conn, 1);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        };
        ActionListener exitpayaction = e -> {
            try {
                new ExitPay(conn);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        };
        ActionListener informationbtn = e -> new RoomInfo(conn);
        ActionListener sendmassegebtn = e -> new RequestForStaff(conn, "Reception");
        ActionListener messagebtnaction = e -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Message where Getteruser = 'receptionofhotel' ;");
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
        ActionListener actionsearchbtn = e -> {
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

        information.addActionListener(informationbtn);
        searchbtn.addActionListener(actionsearchbtn);
        signup.addActionListener(signupaction);
        exitpay.addActionListener(exitpayaction);
        sendmessagebtn.addActionListener(sendmassegebtn);
        messagebtn.addActionListener(messagebtnaction);

        panel.add(label);
        receptionform.add(information);
        receptionform.add(sendmessagebtn);
        receptionform.add(messagebtn);
        receptionform.add(jScrollPane);
        receptionform.add(search);
        receptionform.add(searchbtn);
        receptionform.add(signup);
        receptionform.add(exitpay);
        receptionform.setLocationRelativeTo(null);
        receptionform.setResizable(false);
        receptionform.setLayout(null);
        receptionform.setVisible(true);
    }
}
