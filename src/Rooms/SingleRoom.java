package Rooms;

import Controller.Reception;
import Information.Documents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingleRoom {

    public SingleRoom(Connection conn , int ron) throws Exception {
        Statement st = conn.createStatement();
        JFrame singleform = new JFrame("Room & Personal (SingleRoom)");
        singleform.setSize(500, 600);


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

        JLabel idl = new JLabel("National Id");
        JTextArea id = new JTextArea();
        idl.setBounds(360, 30, 120, 30);
        id.setBounds(360, 60, 120, 25);

        JLabel phonenumberl = new JLabel("Phone");
        JTextArea phonenumber = new JTextArea();
        phonenumberl.setBounds(360, 100, 120, 30);
        phonenumber.setBounds(360, 130, 120, 25);

        JLabel entrydatel = new JLabel("Entry Date");
        JTextArea entryday = new JTextArea();
        entrydatel.setBounds(20, 100, 100, 30);
        entryday.setBounds(20, 130, 40, 25);

        JTextArea entrymonth = new JTextArea();
        entrymonth.setBounds(70, 130, 40, 25);

        JTextArea entryyear = new JTextArea("2018");
        entryyear.setBounds(120, 130, 70, 25);

        JCheckBox man = new JCheckBox("Man");
        JCheckBox woman = new JCheckBox("Woman");
        man.setBounds(240, 120, 100, 20);
        woman.setBounds(240, 140, 100, 20);

        JLabel label = new JLabel("Rooms & Situation");
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setBounds(20, 200, 460, 300);

        JButton continuebtn = new JButton("Continue");
        continuebtn.setBounds(200, 530, 100, 30);

        String text = "<html>";
        try {
            Statement st1 = conn.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT * FROM SingleRoomTable WHERE phone IS NULL;");
            for (int j = 0; j < 30; j++) {
                resultSet.next();
                text = text.concat(resultSet.getString("RoomNumber") + " <br/> " + "--------------------------------------" + " <br/> ");
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        text = text.concat("</html>");
        label.setText(text);

        man.addItemListener(e12 -> {
            if (e12.getStateChange() == ItemEvent.SELECTED) {
                try {
                    st.executeUpdate("update SingleRoomTable set sex = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        });
        woman.addItemListener(e13 -> {
            if (e13.getStateChange() == ItemEvent.SELECTED) {
                try {
                    st.executeUpdate("update SingleRoomTable set sex = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        });



        ActionListener actionListener = e -> {
            try {
                st.executeUpdate("update SingleRoomTable set name = '" + name.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                st.executeUpdate("update SingleRoomTable set Lastname = '" + lastname.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                st.executeUpdate("update SingleRoomTable set phone = '" + BigInteger.valueOf(Long.parseLong(phonenumber.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                st.executeUpdate("update SingleRoomTable set nationalid = '" +  BigInteger.valueOf(Long.parseLong(id.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                st.executeUpdate("update SingleRoomTable set enterday = '" + Integer.valueOf(entryday.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                st.executeUpdate("update SingleRoomTable set entermonth = '" + Integer.valueOf(entrymonth.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                st.executeUpdate("update SingleRoomTable set enteryear = '" + Integer.valueOf(entryyear.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
            } catch (Exception e1) {
                e1.getMessage();
            }
            JOptionPane.showMessageDialog(null , "Complete");
            singleform.dispose();
            new Documents(conn);
        };
        continuebtn.addActionListener(actionListener);


        panel.add(label);
        singleform.add(entrydatel);
        singleform.add(entryday);
        singleform.add(entrymonth);
        singleform.add(entryyear);
        singleform.add(jScrollPane);
        singleform.add(continuebtn);
        singleform.add(man);
        singleform.add(woman);
        singleform.add(phonenumber);
        singleform.add(phonenumberl);
        singleform.add(id);
        singleform.add(idl);
        singleform.add(name);
        singleform.add(namel);
        singleform.add(lastname);
        singleform.add(lastnamel);
        singleform.add(roomnumber);
        singleform.add(roomnumberl);
        singleform.setLocationRelativeTo(null);
        singleform.setResizable(false);
        singleform.setLayout(null);
        singleform.setVisible(true);
    }
}
