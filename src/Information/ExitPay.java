package Information;

import Service.FridgeService;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.*;

public class ExitPay {

    static int fridgecost;

    public ExitPay(int w1, int w2, int w3, int c1, int c2, int c3, int s1, int s2, int s3, int sh1, int sh2, int sh3) {
        fridgecost = w1 * 1500 + w2 * 1500 + w3 * 1500 + c1 * 4000 + c2 * 4000 + c3 * 4000 + s1 * 2000 + s2 * 2000 + s3 * 2000 + sh1 * 7000 + sh2 * 7000 + sh3 * 7000;
    }

    public ExitPay(Connection conn ) throws Exception {


        final boolean[] extrabed = {false};
        final int[] fee = new int[1];
        final String[] roomname = new String[1];
        final int[] roomid = new int[1];

        JFrame exitpayform = new JFrame("Payment Form");
        exitpayform.setSize(330, 600);

        JLabel roomnumberl = new JLabel("RoomNumber");
        JTextArea roomnumber = new JTextArea();
        roomnumberl.setBounds(10, 10, 100, 30);
        roomnumber.setBounds(10, 40, 100, 25);

        JButton fridge = new JButton("Fridge");
        fridge.setBounds(130, 90, 80, 30);

        JButton applybtn = new JButton("Apply");
        applybtn.setBounds(220, 90, 80, 30);

        JButton payed = new JButton("Pay");
        payed.setBounds(130, 540, 80, 30);

        JCheckBox extrabedcheck = new JCheckBox("Extra Bed");
        extrabedcheck.setBounds(20, 90, 100, 30);

        JLabel exitdayl = new JLabel("Exit Date");
        JTextArea exitday = new JTextArea();
        exitdayl.setBounds(150, 10, 100, 30);
        exitday.setBounds(150, 40, 40, 25);

        JTextArea exitmonth = new JTextArea();
        exitmonth.setBounds(200, 40, 40, 25);

        JTextArea exityear = new JTextArea("2018");
        exityear.setBounds(250, 40, 70, 25);

        JLabel label = new JLabel("Payment List");
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setBounds(20, 130, 290, 400);

        ActionListener actionListener1 = e -> new FridgeService();
        fridge.addActionListener(actionListener1);


        extrabedcheck.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    extrabed[0] = true;
                } else {
                    extrabed[0] = false;
                }
            }
        });

        ActionListener actionListener2 = e -> {
            try {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT cost , roomnumber , roomname ,roomid FROM Pay where roomnumber = '" + roomnumber.getText() + "';");
                rs.next();
                int roomcost = rs.getInt("cost");
                roomname[0] = rs.getString("roomname");
                roomid[0] = rs.getInt("roomid");
                rs.close();
                ResultSet rs1 = statement.executeQuery("SELECT * FROM RestaurantTable where RoomNumber = '" + roomnumber.getText() + "';");
                int restaurantcost = 0;
                while (rs1.next()) {
                    restaurantcost = restaurantcost + rs1.getInt("cost");
                }
                rs1.close();
                ResultSet rs2 = statement.executeQuery("SELECT * FROM GymTable where RoomNumber = '" + roomnumber.getText() + "';");
                int gymcost = 0;
                while (rs2.next()) {
                    gymcost = gymcost + rs2.getInt("cost");
                }
                rs2.close();
                ResultSet rs3 = statement.executeQuery("SELECT * FROM PoolTable where RoomNumber = '" + roomnumber.getText() + "';");
                int poolcost = 0;
                while (rs3.next()) {
                    poolcost = poolcost + rs3.getInt("cost");
                }
                rs3.close();
                ResultSet rs4 = statement.executeQuery("SELECT * FROM LandryTable where RoomNumber = '" + roomnumber.getText() + "';");
                int landrycost = 0;
                while (rs4.next()) {
                    landrycost = landrycost + rs4.getInt("cost");
                }
                rs4.close();
                ResultSet rs5 = statement.executeQuery("SELECT * FROM DriverTable where RoomNumber = '" + roomnumber.getText() + "';");
                int drivercost = 0;
                while (rs5.next()) {
                    drivercost = drivercost + rs5.getInt("cost");
                }
                rs5.close();
                ResultSet rs6 = statement.executeQuery("SELECT * FROM CleansStaffTable where RoomNumber = '" + roomnumber.getText() + "';");
                int staffcost = 0;
                while (rs6.next()) {
                    staffcost = staffcost + rs6.getInt("cost");
                }
                rs6.close();

                ResultSet rs7 = statement.executeQuery("SELECT * FROM " + roomname[0] + " where RoomNumber = '" + roomnumber.getText() + "' ;");
                rs7.next();
                int daysentery = rs7.getInt("enterday");
                int monthentery = rs7.getInt("entermonth");
                int yearentery = rs7.getInt("enteryear");
                int daysstay = (((Integer.valueOf(exityear.getText()) * 365) + ((Integer.valueOf(exitmonth.getText()) * 30) + (Integer.valueOf(exitday.getText())))) - (yearentery * 365 + monthentery * 30 + daysentery));
                rs7.close();
                //

                String total = "<html>" + "Roomcost: " + daysstay + "*" + roomcost + "=" + roomcost * daysstay + " <br/> " + "--------------------" + " <br/> " + "driver cost: " + drivercost + " <br/> " + "--------------------" + " <br/> " + "Gym cost: " + gymcost + " <br/> " + "--------------------" + " <br/> " + "Restaurant cost: " + restaurantcost + " <br/> " + "--------------------" + " <br/> " + "Landry cost: " + landrycost + " <br/> " + "--------------------" + " <br/> " + "Extra Cleans cost: " + staffcost + " <br/> " + "--------------------" + " <br/> " + "Pool cost: " + poolcost;
                if (extrabed[0] == false) {
                    fee[0] = daysstay * roomcost + restaurantcost + gymcost + poolcost + landrycost + staffcost + drivercost + fridgecost;
                    label.setText(total + " <br/> " + "--------------------" + " <br/> " + "Fridge cost: " + fridgecost + " <br/> " + "--------------------" + " <br/> " + "Totaly: " + fee[0] + " <br/> " + "--------------------" + " <br/> " + "Thank You & Have Nice Day");
                } else {
                    fee[0] = daysstay * roomcost + restaurantcost + gymcost + poolcost + landrycost + staffcost + drivercost + fridgecost + 110000;
                    label.setText(total + " <br/> " + "--------------------" + " <br/> " + "Fridge cost: " + fridgecost + " <br/> " + "--------------------" + " <br/> " + "Extra bed: 100000" + " <br/> " + "--------------------" + " <br/> " + "Totaly: " + fee[0] + " <br/> " + "--------------------" + " <br/> " + "Thank You & Have Nice Day");
                }

                //
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        };
        applybtn.addActionListener(actionListener2);

        ActionListener actionListener3 = e -> {
            exitpayform.dispose();
            JFrame payformtobank = new JFrame("Bank");
            payformtobank.setSize(300, 300);

            JLabel namel = new JLabel("Name");
            JTextArea name = new JTextArea();
            namel.setBounds(10, 10, 100, 30);
            name.setBounds(10, 40, 130, 25);

            JLabel lastnamel = new JLabel("Lastname");
            JTextArea lastname = new JTextArea();
            lastnamel.setBounds(160, 10, 100, 30);
            lastname.setBounds(160, 40, 130, 25);

            JLabel feefinall = new JLabel("Fee");
            JTextArea feefinal = new JTextArea(String.valueOf(fee[0]));
            feefinall.setBounds(10, 80, 100, 30);
            feefinal.setBounds(10, 110, 130, 25);
            feefinal.setEnabled(false);

            JButton pay = new JButton("Pay");
            pay.setBounds(160, 110, 80, 30);


            ActionListener actionListener5 = e1 -> {
                try {
                    String insertSQL = "INSERT INTO HotelAccount (RoomNumber  , name ,lastname ,daypayed ,monthpayed ,yearpayed ,fee ) VALUES (?,  ? , ? ,? ,? ,?, ? );";
                    PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
                    preparedStatement.setInt(1, Integer.parseInt(roomnumber.getText()));
                    preparedStatement.setString(2, name.getText());
                    preparedStatement.setString(3, lastname.getText());
                    preparedStatement.setInt(4, Integer.parseInt(exitday.getText()));
                    preparedStatement.setInt(5, Integer.parseInt(exitmonth.getText()));
                    preparedStatement.setInt(6, Integer.parseInt(exityear.getText()));
                    preparedStatement.setInt(7, fee[0]);
                    preparedStatement.executeUpdate();

                    PreparedStatement st = conn.prepareStatement("DELETE FROM " + roomname[0] + " WHERE RoomNumber = '" + roomnumber.getText() + "' ;");
                    st.executeUpdate();

                    String insertSQL2 = "INSERT INTO " + roomname[0] + " (RoomNumber  , ID ) VALUES (?,  ?);";
                    PreparedStatement preparedStatement2 = conn.prepareStatement(insertSQL2);
                    preparedStatement2.setInt(1, Integer.parseInt(roomnumber.getText()));
                    preparedStatement2.setInt(2, roomid[0]);
                    preparedStatement2.executeUpdate();
                    Socket socket = new Socket("192.168.43.186", 3400);
                    System.out.println("connected to server ...");
                    OutputStream outputStream = socket.getOutputStream();
                    String text = 12 + "&%&" + fee[0];
                    outputStream.write(text.getBytes());
                    outputStream.close();
                    System.out.println("Client: Message sent:)");
                    //
                } catch (Exception r2) {
                    r2.getMessage();
                }
                JOptionPane.showMessageDialog(null, "Bank Received");
                payformtobank.dispose();
            };
            pay.addActionListener(actionListener5);

            payformtobank.add(name);
            payformtobank.add(namel);
            payformtobank.add(lastname);
            payformtobank.add(lastnamel);
            payformtobank.add(feefinal);
            payformtobank.add(feefinall);
            payformtobank.add(pay);
            payformtobank.setLocationRelativeTo(null);
            payformtobank.setResizable(false);
            payformtobank.setLayout(null);
            payformtobank.setVisible(true);

        };
        payed.addActionListener(actionListener3);

        panel.add(label);
        exitpayform.add(payed);
        exitpayform.add(extrabedcheck);
        exitpayform.add(exitdayl);
        exitpayform.add(exitday);
        exitpayform.add(exitmonth);
        exitpayform.add(exityear);
        exitpayform.add(fridge);
        exitpayform.add(jScrollPane);
        exitpayform.add(applybtn);
        exitpayform.add(roomnumber);
        exitpayform.add(roomnumberl);
        exitpayform.setLocationRelativeTo(null);
        exitpayform.setResizable(false);
        exitpayform.setLayout(null);
        exitpayform.setVisible(true);

    }
}
