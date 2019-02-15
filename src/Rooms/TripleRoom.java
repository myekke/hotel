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

public class TripleRoom {
    public TripleRoom(Connection conn , int o , int ron) throws Exception {
        Statement st = conn.createStatement();

        JFrame tripleform = new JFrame("Room & Personal (TripleRoom)");
        tripleform.setSize(830, 540);
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

        JLabel label = new JLabel("Rooms & Situation");
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setBounds(500, 30, 300, 420);

        JButton continuebtn = new JButton("Continue");
        continuebtn.setBounds(600, 470, 100, 30);


        if (o == 1){
            String text = "<html>" ;
            try {
                Statement st1 = conn.createStatement();
                ResultSet resultSet = st1.executeQuery("SELECT * FROM TripleRoomEconomyTable WHERE phone1 IS NULL;");
                for (int j = 0; j < 30; j++) {
                    resultSet.next();
                    text = text.concat(resultSet.getString("RoomNumber") + " <br/> "+ "--------------------------------------" +" <br/> ");
                }
            } catch (Exception e3) {
                e3.getMessage();
            }
            text = text.concat("</html>");
            label.setText(text);
        }else if( o ==2){
            String text = "<html>" ;
            try {
                Statement st1 = conn.createStatement();
                ResultSet resultSet = st1.executeQuery("SELECT * FROM TripleRoomQueenTable WHERE phone1 IS NULL;");
                for (int j = 0; j < 30; j++) {
                    resultSet.next();
                    text = text.concat(resultSet.getString("RoomNumber") + " <br/> "+ "--------------------------------------" +" <br/> ");
                }
            } catch (Exception e3) {
                e3.getMessage();
            }
            text = text.concat("</html>");
            label.setText(text);

        }else{
            String text = "<html>" ;
            try {
                Statement st1 = conn.createStatement();
                ResultSet resultSet = st1.executeQuery("SELECT * FROM TripleRoomKingTable WHERE phone1 IS NULL;");
                for (int j = 0; j < 30; j++) {
                    resultSet.next();
                    text = text.concat(resultSet.getString("RoomNumber") + " <br/> "+ "--------------------------------------" +" <br/> ");
                }
            } catch (Exception e3) {
                e3.getMessage();
            }
            text = text.concat("</html>");
            label.setText(text);


        }


        if(o==1){

                man.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            try {
                                st.executeUpdate("update TripleRoomEconomyTable set sex1 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomEconomyTable set sex1 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomEconomyTable set sex2 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomEconomyTable set sex2 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomEconomyTable set sex3 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomEconomyTable set sex3 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
                            } catch (SQLException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            man3.setEnabled(false);
                        }
                    }
                });

        }else if(o ==2){

                man.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            try {
                                st.executeUpdate("update TripleRoomQueenTable set sex1 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomQueenTable set sex1 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomQueenTable set sex2 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomQueenTable set sex2 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomQueenTable set sex3 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomQueenTable set sex3 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
                            } catch (SQLException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            man3.setEnabled(false);
                        }
                    }
                });
        }else{
                man.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            try {
                                st.executeUpdate("update TripleRoomKingTable set sex1 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomKingTable set sex1 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomKingTable set sex2 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomKingTable set sex2 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomKingTable set sex3 = 1 where RoomNumber ='" + roomnumber.getText() +"';");
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
                                st.executeUpdate("update TripleRoomKingTable set sex3 = 0 where RoomNumber ='" + roomnumber.getText() +"';");
                            } catch (SQLException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            man3.setEnabled(false);
                        }
                    }
                });

        }

        ActionListener actionListener = e -> {

            if(o==1){
                try {
                    st.executeUpdate("update TripleRoomEconomyTable set name1 = '"+ name.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set lastname1 = '"+ lastname.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set phone1 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set nationalid1 = '"+ BigInteger.valueOf(Long.parseLong(id.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set name2 = '"+ name2.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set Lastname2 = '"+ lastname2.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set phone2 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber2.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set nationalid2 = '"+ BigInteger.valueOf(Long.parseLong(id2.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set name3 = '"+ name3.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set Lastname3 = '"+ lastname3.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set phone3 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber3.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set nationalid3 = '"+ BigInteger.valueOf(Long.parseLong(id3.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set enterday = '"+ Integer.valueOf(entryday.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set entermonth = '"+ Integer.valueOf(entrymonth.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomEconomyTable set enteryear = '"+ Integer.valueOf(entryyear.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");

                }catch (Exception e1){
                    e1.getMessage();
                }
            }else if(o ==2){
                try {
                    st.executeUpdate("update TripleRoomQueenTable set name1 = '"+ name.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set lastname1 = '"+ lastname.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set phone1 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set nationalid1 = '"+ BigInteger.valueOf(Long.parseLong(id.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set name2 = '"+ name2.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set Lastname2 = '"+ lastname2.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set phone2 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber2.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set nationalid2 = '"+ BigInteger.valueOf(Long.parseLong(id2.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set name3 = '"+ name3.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set Lastname3 = '"+ lastname3.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set phone3 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber3.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set nationalid3 = '"+ BigInteger.valueOf(Long.parseLong(id3.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set enterday = '"+ Integer.valueOf(entryday.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set entermonth = '"+ Integer.valueOf(entrymonth.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomQueenTable set enteryear = '"+ Integer.valueOf(entryyear.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");


                }catch (Exception e1){
                    e1.getMessage();
                }
            }else{
                try {
                    st.executeUpdate("update TripleRoomKingTable set name1 = '"+ name.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set lastname1 = '"+ lastname.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set phone1 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set nationalid1 = '"+ BigInteger.valueOf(Long.parseLong(id.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set name2 = '"+ name2.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set Lastname2 = '"+ lastname2.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set phone2 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber2.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set nationalid2 = '"+ BigInteger.valueOf(Long.parseLong(id2.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set name3 = '"+ name3.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set Lastname3 = '"+ lastname3.getText() +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set phone3 = '"+ BigInteger.valueOf(Long.parseLong(phonenumber3.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set nationalid3 = '"+ BigInteger.valueOf(Long.parseLong(id3.getText())) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set enterday = '"+ Integer.valueOf(entryday.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set entermonth = '"+ Integer.valueOf(entrymonth.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");
                    st.executeUpdate("update TripleRoomKingTable set enteryear = '"+ Integer.valueOf(entryyear.getText()) +"' where RoomNumber ='" + roomnumber.getText() +"';");

                }catch (Exception e1){
                    e1.getMessage();
                }
            }
            JOptionPane.showMessageDialog(null , "Complete");
            tripleform.dispose();
            new Documents(conn);
        };
        continuebtn.addActionListener(actionListener);


        panel.add(label);
        tripleform.add(entrydatel);
        tripleform.add(entryday);
        tripleform.add(entrymonth);
        tripleform.add(entryyear);
        tripleform.add(jScrollPane);
        tripleform.add(continuebtn);
        tripleform.add(man);
        tripleform.add(woman);
        tripleform.add(phonenumber);
        tripleform.add(phonenumberl);
        tripleform.add(id);
        tripleform.add(idl);
        tripleform.add(name);
        tripleform.add(namel);
        tripleform.add(lastname);
        tripleform.add(lastnamel);
        tripleform.add(man2);
        tripleform.add(woman2);
        tripleform.add(phonenumber2);
        tripleform.add(phonenumberl2);
        tripleform.add(id2);
        tripleform.add(idl2);
        tripleform.add(name2);
        tripleform.add(namel2);
        tripleform.add(lastname2);
        tripleform.add(lastnamel2);
        tripleform.add(man3);
        tripleform.add(woman3);
        tripleform.add(phonenumber3);
        tripleform.add(phonenumberl3);
        tripleform.add(id3);
        tripleform.add(idl3);
        tripleform.add(name3);
        tripleform.add(namel3);
        tripleform.add(lastname3);
        tripleform.add(lastnamel3);
        tripleform.add(roomnumber);
        tripleform.add(roomnumberl);
        tripleform.setLocationRelativeTo(null);
        tripleform.setResizable(false);
        tripleform.setLayout(null);
        tripleform.setVisible(true);
    }
}
