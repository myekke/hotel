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

public class QuadRoom {
    public QuadRoom(Connection conn, int o , int ron) throws Exception {
        Statement st = conn.createStatement();

        JFrame quadform = new JFrame("Room & Personal (QuadRoom)");
        quadform.setSize(830, 700);
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

        JLabel namel3 = new JLabel("Name");
        JTextArea name3 = new JTextArea();
        namel3.setBounds(120, 350, 100, 30);
        name3.setBounds(120, 380, 100, 25);

        JLabel lastnamel3 = new JLabel("Last Name");
        JTextArea lastname3 = new JTextArea();
        lastnamel3.setBounds(240, 350, 100, 30);
        lastname3.setBounds(240, 380, 100, 25);

        JLabel idl3 = new JLabel("National Id");
        JTextArea id3 = new JTextArea();
        idl3.setBounds(360, 350, 120, 30);
        id3.setBounds(360, 380, 120, 25);

        JLabel phonenumberl3 = new JLabel("Phone");
        JTextArea phonenumber3 = new JTextArea();
        phonenumberl3.setBounds(360, 420, 120, 30);
        phonenumber3.setBounds(360, 450, 120, 25);

        JCheckBox man3 = new JCheckBox("Man");
        JCheckBox woman3 = new JCheckBox("Woman");
        man3.setBounds(240, 440, 100, 20);
        woman3.setBounds(240, 460, 100, 20);

        JLabel namel4 = new JLabel("Name");
        JTextArea name4 = new JTextArea();
        namel4.setBounds(120, 510, 100, 30);
        name4.setBounds(120, 540, 100, 25);

        JLabel lastnamel4 = new JLabel("Last Name");
        JTextArea lastname4 = new JTextArea();
        lastnamel4.setBounds(240, 510, 100, 30);
        lastname4.setBounds(240, 540, 100, 25);

        JLabel idl4 = new JLabel("National Id");
        JTextArea id4 = new JTextArea();
        idl4.setBounds(360, 510, 120, 30);
        id4.setBounds(360, 540, 120, 25);

        JLabel phonenumberl4 = new JLabel("Phone");
        JTextArea phonenumber4 = new JTextArea();
        phonenumberl4.setBounds(360, 580, 120, 30);
        phonenumber4.setBounds(360, 610, 120, 25);

        JCheckBox man4 = new JCheckBox("Man");
        JCheckBox woman4 = new JCheckBox("Woman");
        man4.setBounds(240, 600, 100, 20);
        woman4.setBounds(240, 620, 100, 20);

        JLabel label = new JLabel("Rooms & Situation");
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setBounds(500, 30, 300, 580);

        JButton continuebtn = new JButton("Continue");
        continuebtn.setBounds(600, 630, 100, 30);


        if (o == 1) {
            String text = "<html>";
            try {
                Statement st1 = conn.createStatement();
                ResultSet resultSet = st1.executeQuery("SELECT * FROM QuadRoomMasterTable WHERE phone1 IS NULL;");
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
                ResultSet resultSet = st1.executeQuery("SELECT * FROM QuadRoomVipTable WHERE phone1 IS NULL;");
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


        if (o == 1) {
            man.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomMasterTable set sex1 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        woman.setEnabled(false);
                    }
                }
            });
            woman.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomMasterTable set sex1 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        man.setEnabled(false);
                    }
                }
            });
            man2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomMasterTable set sex2 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        woman2.setEnabled(false);
                    }
                }
            });
            woman2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomMasterTable set sex2 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        man2.setEnabled(false);
                    }
                }
            });
            man3.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomMasterTable set sex3 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        woman3.setEnabled(false);
                    }
                }
            });
            woman3.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomMasterTable set sex3 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        man3.setEnabled(false);
                    }
                }
            });
            man4.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomMasterTable set sex4 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        woman4.setEnabled(false);
                    }
                }
            });
            woman4.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomMasterTable set sex4 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        man4.setEnabled(false);
                    }
                }
            });
        } else {
            man.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomVipTable set sex1 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        woman.setEnabled(false);
                    }
                }
            });
            woman.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomVipTable set sex1 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        man.setEnabled(false);
                    }
                }
            });
            man2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomVipTable set sex2 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        woman2.setEnabled(false);
                    }
                }
            });
            woman2.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomVipTable set sex2 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        man2.setEnabled(false);
                    }
                }
            });
            man3.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomVipTable set sex3 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        woman3.setEnabled(false);
                    }
                }
            });
            woman3.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomVipTable set sex3 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        man3.setEnabled(false);
                    }
                }
            });
            man4.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomVipTable set sex4 = 1 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        woman4.setEnabled(false);
                    }
                }
            });
            woman4.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            st.executeUpdate("update QuadRoomVipTable set sex4 = 0 where RoomNumber ='" + roomnumber.getText() + "';");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        man4.setEnabled(false);
                    }
                }
            });
        }

        ActionListener actionListener = e -> {
            if (o == 1) {
                try {
                    st.executeUpdate("update QuadRoomMasterTable set name1 = '" + name.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set lastname1 = '" + lastname.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set phone1 = '" + BigInteger.valueOf(Long.parseLong(phonenumber.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set nationalid1 = '" + BigInteger.valueOf(Long.parseLong(id.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set name2 = '" + name2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set Lastname2 = '" + lastname2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set phone2 = '" + BigInteger.valueOf(Long.parseLong(phonenumber2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set nationalid2 = '" + BigInteger.valueOf(Long.parseLong(id2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set name3 = '" + name3.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set Lastname3 = '" + lastname3.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set phone3 = '" + BigInteger.valueOf(Long.parseLong(phonenumber3.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set nationalid3 = '" + BigInteger.valueOf(Long.parseLong(id3.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set name4 = '" + name4.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set Lastname4 = '" + lastname4.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set phone4 = '" + BigInteger.valueOf(Long.parseLong(phonenumber4.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set nationalid4 = '" + BigInteger.valueOf(Long.parseLong(id4.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set enterday = '" + Integer.valueOf(entryday.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set entermonth = '" + Integer.valueOf(entrymonth.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomMasterTable set enteryear = '" + Integer.valueOf(entryyear.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");

                } catch (Exception e1) {
                    e1.getMessage();
                }
            } else {
                try {
                    st.executeUpdate("update QuadRoomVipTable set name1 = '" + name.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set lastname1 = '" + lastname.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set phone1 = '" + BigInteger.valueOf(Long.parseLong(phonenumber.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set nationalid1 = '" + BigInteger.valueOf(Long.parseLong(id.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set name2 = '" + name2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set Lastname2 = '" + lastname2.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set phone2 = '" + BigInteger.valueOf(Long.parseLong(phonenumber2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set nationalid2 = '" + BigInteger.valueOf(Long.parseLong(id2.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set name3 = '" + name3.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set Lastname3 = '" + lastname3.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set phone3 = '" + BigInteger.valueOf(Long.parseLong(phonenumber3.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set nationalid3 = '" + BigInteger.valueOf(Long.parseLong(id3.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set name4 = '" + name4.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set Lastname4 = '" + lastname4.getText() + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set phone4 = '" + BigInteger.valueOf(Long.parseLong(phonenumber4.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set nationalid4 = '" + BigInteger.valueOf(Long.parseLong(id4.getText())) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set enterday = '" + Integer.valueOf(entryday.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set entermonth = '" + Integer.valueOf(entrymonth.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");
                    st.executeUpdate("update QuadRoomVipTable set enteryear = '" + Integer.valueOf(entryyear.getText()) + "' where RoomNumber ='" + roomnumber.getText() + "';");


                } catch (Exception e1) {
                    e1.getMessage();
                }
            }
            JOptionPane.showMessageDialog(null , "Complete");
            quadform.dispose();
            new Documents(conn);
        };
        continuebtn.addActionListener(actionListener);


        panel.add(label);
        quadform.add(entrydatel);
        quadform.add(entryday);
        quadform.add(entrymonth);
        quadform.add(entryyear);
        quadform.add(jScrollPane);
        quadform.add(continuebtn);
        quadform.add(man);
        quadform.add(woman);
        quadform.add(phonenumber);
        quadform.add(phonenumberl);
        quadform.add(id);
        quadform.add(idl);
        quadform.add(name);
        quadform.add(namel);
        quadform.add(lastname);
        quadform.add(lastnamel);
        quadform.add(man2);
        quadform.add(woman2);
        quadform.add(phonenumber2);
        quadform.add(phonenumberl2);
        quadform.add(id2);
        quadform.add(idl2);
        quadform.add(name2);
        quadform.add(namel2);
        quadform.add(lastname2);
        quadform.add(lastnamel2);
        quadform.add(man3);
        quadform.add(woman3);
        quadform.add(phonenumber3);
        quadform.add(phonenumberl3);
        quadform.add(id3);
        quadform.add(idl3);
        quadform.add(name3);
        quadform.add(namel3);
        quadform.add(lastname3);
        quadform.add(lastnamel3);
        quadform.add(man4);
        quadform.add(woman4);
        quadform.add(phonenumber4);
        quadform.add(phonenumberl4);
        quadform.add(id4);
        quadform.add(idl4);
        quadform.add(name4);
        quadform.add(namel4);
        quadform.add(lastname4);
        quadform.add(lastnamel4);
        quadform.add(roomnumber);
        quadform.add(roomnumberl);
        quadform.setLocationRelativeTo(null);
        quadform.setResizable(false);
        quadform.setLayout(null);
        quadform.setVisible(true);
    }
}
