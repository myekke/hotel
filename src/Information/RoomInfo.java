package Information;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoomInfo {
    public RoomInfo(Connection conn) {

        final String[] roomname = new String[1];

        JFrame infoform = new JFrame("Information");
        infoform.setSize(350, 400);

        JLabel room_numberl = new JLabel("Room number");
        JTextArea room_number = new JTextArea();
        room_numberl.setBounds(75, 30, 100, 30);
        room_number.setBounds(75, 60, 80, 30);

        JButton find = new JButton("Find");
        find.setBounds(195, 60, 80, 30);

        JLabel label2 = new JLabel("Not yet");
        JPanel panel2 = new JPanel();
        JScrollPane jScrollPane2 = new JScrollPane(panel2);
        jScrollPane2.setBounds(10, 110, 330, 300);

        ActionListener actionListener = e -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet rs1 = statement.executeQuery("SELECT * FROM Pay where roomnumber = '" + room_number.getText() + "';");
                rs1.next();
                roomname[0] = rs1.getString("roomname");
                rs1.close();

                ResultSet rs2 = statement.executeQuery("SELECT * FROM " + roomname[0] + " where RoomNumber = '" + room_number.getText() + "' ;");
                rs2.next();

                String info;
                if (roomname[0].equals("SingleRoomTable")) {

                    info = "<html>" + rs2.getString("name") + "   " + rs2.getString("lastname") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getBigDecimal("phone") + "    National ID: " + rs2.getBigDecimal("nationalid") + " <br/> " + "--------------------" + " <br/> " + " </html> ";
                    label2.setText(info);

                } else if (roomname[0].equals("DoubleRoomEconomyTable") || roomname[0].equals("DoubleRoomQueenTable") || roomname[0].equals("DoubleRoomKingTable")) {

                    info = "<html>" + rs2.getString("name1") + "   " + rs2.getString("lastname1") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone1") + "    National ID: " + rs2.getInt("nationalid1") + " <br/> " + "--------------------" + " <br/> " + rs2.getString("name2") + "   " + rs2.getString("lastname2") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone2") + "    National ID: " + rs2.getInt("nationalid2") + " <br/> " + "--------------------" + " <br/> " + " </html> ";
                    label2.setText(info);

                } else if (roomname[0].equals("TripleRoomEconomyTable") || roomname[0].equals("TripleRoomQueenTable") || roomname[0].equals("TripleRoomKingTable")) {

                    info = "<html>" + rs2.getString("name1") + "   " + rs2.getString("lastname1") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone1") + "    National ID: " + rs2.getInt("nationalid1") + " <br/> " + "--------------------" + " <br/> " + rs2.getString("name2") + "   " + rs2.getString("lastname2") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone2") + "    National ID: " + rs2.getInt("nationalid2") + " <br/> " + "--------------------" + " <br/> " + rs2.getString("name3") + "   " + rs2.getString("lastname3") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone3") + "    National ID: " + rs2.getInt("nationalid3") + " <br/> " + "--------------------" + " <br/> " + " </html> ";
                    label2.setText(info);

                } else {

                    info = "<html>" + rs2.getString("name1") + "   " + rs2.getString("lastname1") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone1") + "    National ID: " + rs2.getBigDecimal("nationalid1") + " <br/> " + "--------------------" + " <br/> " + rs2.getString("name2") + "   " + rs2.getString("lastname2") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone2") + "    National ID: " + rs2.getInt("nationalid2") + " <br/> " + "--------------------" + " <br/> " + rs2.getString("name3") + "   " + rs2.getString("lastname3") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone3") + "    National ID: " + rs2.getInt("nationalid3") + " <br/> " + "--------------------" + " <br/> " + rs2.getString("name4") + "   " + rs2.getString("lastname4") + " <br/> " + "--------------------" + " <br/> " + "Phone: " + rs2.getInt("phone4") + "    National ID: " + rs2.getInt("nationalid4") + " <br/> " + "--------------------" + " <br/> " + " </html> ";
                    label2.setText(info);
                }


            } catch (Exception e1) {
                e1.getMessage();
            }
        };
        find.addActionListener(actionListener);

        panel2.add(label2);
        infoform.add(jScrollPane2);
        infoform.add(room_number);
        infoform.add(room_numberl);
        infoform.add(find);
        infoform.setLocationRelativeTo(null);
        infoform.setResizable(false);
        infoform.setLayout(null);
        infoform.setVisible(true);

    }
}
