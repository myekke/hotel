package Rooms;

import Controller.Reception;
import Information.Documents;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoubleRoom {
    public DoubleRoom(Connection conn, int o , int ron) throws Exception {
        Statement st = conn.createStatement();
        JFrame doubleform = new JFrame("Room & Personal (Double)");
        doubleform.setSize(500, 750);

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
////
        JLabel namel2 = new JLabel("Name");
        JTextArea name2 = new JTextArea();
        namel2.setBounds(120, 190, 100, 30);
        name2.setBounds(120, 220, 100, 25);

        JLabel lastnamel2 = new JLabel("Last Name");
        JTextArea lastname2 = new JTextArea();
        lastnamel2.setBounds(240, 190, 100, 30);
        lastname2.setBounds(240, 220, 100, 25);

        JLabel idl2 = new JLabel("National Id");
        JTextArea id2 = new JTextArea();
        idl2.setBounds(360, 190, 120, 30);
        id2.setBounds(360, 220, 120, 25);

        JLabel phonenumberl2 = new JLabel("Phone");
        JTextArea phonenumber2 = new JTextArea();
        phonenumberl2.setBounds(360, 260, 120, 30);
        phonenumber2.setBounds(360, 290, 120, 25);

        JCheckBox man2 = new JCheckBox("Man");
        JCheckBox woman2 = new JCheckBox("Woman");
        man2.setBounds(240, 280, 100, 20);
        woman2.setBounds(240, 300, 100, 20);

        JLabel label = new JLabel("Rooms & Situation");
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setBounds(20, 370, 460, 300);

        JButton continuebtn = new JButton("Continue");
        continuebtn.setBounds(200, 670, 100, 30);


        if (o == 1) {
            String text = "<html>";
            try {
                Statement st1 = conn.createStatement();
                ResultSet resultSet = st1.executeQuery("SELECT * FROM DoubleRoomEconomyTable WHERE phone1 IS NULL;");
                for (int j = 0; j < 30; j++) {
                    resultSet.next();
                    text = text.concat(resultSet.getString("RoomNumber") + " <br/> " + "--------------------------------------" + " <br/> ");
                }
            } catch (Exception e3) {
                e3.getMessage();
            }
            text = text.concat("</html>");
            label.setText(text);


        } else if (o == 2) {
            String text = "<html>";
            try {
                Statement st1 = conn.createStatement();
                ResultSet resultSet = st1.executeQuery("SELECT * FROM DoubleRoomQueenTable WHERE phone1 IS NULL;");
                for (int j = 0; j < 30; j++) {
                    resultSet.next();
                    text = text.concat(resultSet.getString("RoomNumber") + " <br/> " + "--------------------------------------" + " <br/> ");
                }
            } catch (Exception e3) {
                e3.getMessage();
            }
            text = text.concat("</html>");
            label.setText(text);


        } else {
            String text = "<html>";
            try {
                Statement st1 = conn.createStatement();
                ResultSet resultSet = st1.executeQuery("SELECT * FROM DoubleRoomKingTable WHERE phone1 IS NULL;");
                for (int j = 0; j < 30; j++) {
                    resultSet.next();
                    text = text.concat(resultSet.getString("RoomNumber") + " <br/> " + "--------------------------------------" + " <br/> ");
                }
            } catch (Exception e3) {
                e3.getMessage();
            }
            text = text.concat("</html>");
            label.setText(text);


        }
        man.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        st.executeUpdate("update DoubleRoomEconomyTable set sex1 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        woman.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        st.executeUpdate("update DoubleRoomEconomyTable set sex1 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        man2.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        st.executeUpdate("update DoubleRoomEconomyTable set sex2 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        if(o == 1) {
            woman2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomEconomyTable set sex2 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }else if (o == 2){
            man.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomQueenTable set sex1 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            woman.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomQueenTable set sex1 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            man2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomQueenTable set sex2 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            woman2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomQueenTable set sex2 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });

        }else {
            man.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomKingTable set sex1 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            woman.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomKingTable set sex1 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            man2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomKingTable set sex2 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            woman2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update DoubleRoomKingTable set sex2 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });

        }


        ActionListener actionListener = e -> {
           if(o == 1){
               try {
                   st.executeUpdate("update DoubleRoomEconomyTable set name1 = '" + name.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set lastname1 = '" + lastname.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set phone1 = '" + BigInteger.valueOf(Long.parseLong(phonenumber.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set nationalid1 = '" + BigInteger.valueOf(Long.parseLong(id.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set name2 = '" + name2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set Lastname2 = '" + lastname2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set phone2 = '" + BigInteger.valueOf(Long.parseLong(phonenumber2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set nationalid2 = '" + BigInteger.valueOf(Long.parseLong(id2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set enterday = '" + Integer.valueOf(entryday.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set entermonth = '" + Integer.valueOf(entrymonth.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomEconomyTable set enteryear = '" + Integer.valueOf(entryyear.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");

               } catch (Exception e1) {
                   e1.getMessage();
               }
           }else if(o ==2){
               try {
                   st.executeUpdate("update DoubleRoomQueenTable set name1 = '" + name.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set lastname1 = '" + lastname.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set phone1 = '" + BigInteger.valueOf(Long.parseLong(phonenumber.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set nationalid1 = '" + BigInteger.valueOf(Long.parseLong(id.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set name2 = '" + name2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set Lastname2 = '" + lastname2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set phone2 = '" + BigInteger.valueOf(Long.parseLong(phonenumber2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set nationalid2 = '" + BigInteger.valueOf(Long.parseLong(id2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set enterday = '" + Integer.valueOf(entryday.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set entermonth = '" + Integer.valueOf(entrymonth.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomQueenTable set enteryear = '" + Integer.valueOf(entryyear.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");

               } catch (Exception e1) {
                   e1.getMessage();
               }
           }else {
               try {
                   st.executeUpdate("update DoubleRoomKingTable set name1 = '" + name.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set lastname1 = '" + lastname.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set phone1 = '" + BigInteger.valueOf(Long.parseLong(phonenumber.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set nationalid1 = '" + BigInteger.valueOf(Long.parseLong(id.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set name2 = '" + name2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set Lastname2 = '" + lastname2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set phone2 = '" + BigInteger.valueOf(Long.parseLong(phonenumber2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set nationalid2 = '" + BigInteger.valueOf(Long.parseLong(id2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set enterday = '" + Integer.valueOf(entryday.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set entermonth = '" + Integer.valueOf(entrymonth.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                   st.executeUpdate("update DoubleRoomKingTable set enteryear = '" + Integer.valueOf(entryyear.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");

               } catch (Exception e1) {
                   e1.getMessage();
               }
           }
           JOptionPane.showMessageDialog(null , "Complete");
           doubleform.dispose();
            new Documents(conn);

        };
        continuebtn.addActionListener(actionListener);


        panel.add(label);
        doubleform.add(entrydatel);
        doubleform.add(entryday);
        doubleform.add(entrymonth);
        doubleform.add(entryyear);
        doubleform.add(jScrollPane);
        doubleform.add(continuebtn);
        doubleform.add(man);
        doubleform.add(woman);
        doubleform.add(phonenumber);
        doubleform.add(phonenumberl);
        doubleform.add(id);
        doubleform.add(idl);
        doubleform.add(name);
        doubleform.add(namel);
        doubleform.add(lastname);
        doubleform.add(lastnamel);
        doubleform.add(man2);
        doubleform.add(woman2);
        doubleform.add(phonenumber2);
        doubleform.add(phonenumberl2);
        doubleform.add(id2);
        doubleform.add(idl2);
        doubleform.add(name2);
        doubleform.add(namel2);
        doubleform.add(lastname2);
        doubleform.add(lastnamel2);
        doubleform.add(roomnumber);
        doubleform.add(roomnumberl);
        doubleform.setLocationRelativeTo(null);
        doubleform.setResizable(false);
        doubleform.setLayout(null);
        doubleform.setVisible(true);
    }
}
