package Information;

import Rooms.DoubleRoom;
import Rooms.QuadRoom;
import Rooms.SingleRoom;
import Rooms.TripleRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

public class Kinddoubletriple {
    public Kinddoubletriple(Connection conn, int s , int a) {
        JFrame kindform1 = new JFrame("Kind");
        kindform1.setSize(700, 700);

        JPanel kindpanel = new JPanel();
        kindpanel.setLocation(0, 0);
        kindpanel.setBorder(BorderFactory.createTitledBorder("Kind of Room"));
        JCheckBox kindcheckbox1 = new JCheckBox("Economy");
        JCheckBox kindcheckbox2 = new JCheckBox("Queen");
        JCheckBox kindcheckbox3 = new JCheckBox("King");
        kindpanel.add(kindcheckbox1);
        kindpanel.add(kindcheckbox2);
        kindpanel.add(kindcheckbox3);

        JPanel continuepanel = new JPanel();
        JButton continuebtn = new JButton("Continue");
        continuebtn.setSize(80, 30);
        continuepanel.add(continuebtn);

        Boolean[] roomkind = new Boolean[6];

        for (int i = 0; i < 6; i++) {
            roomkind[i] = false;
        }

        kindcheckbox1.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    roomkind[0] = true;
                } else {
                    roomkind[0] = false;
                }
            }
        });
        kindcheckbox2.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    roomkind[1] = true;
                } else {
                    roomkind[1] = false;
                }
            }
        });
        kindcheckbox3.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    roomkind[2] = true;
                } else {
                    roomkind[2] = false;
                }
            }
        });

        ActionListener actionListener = e -> {
            if (roomkind[0] == true) {
                if (s == 2) {
                    try {
                        new DoubleRoom(conn, 1 , a);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    kindform1.dispose();
                } else {
                    try {
                        new TripleRoom(conn, 1 , a);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    kindform1.dispose();
                }
            } else if (roomkind[1] == true) {
                if (s == 2) {
                    try {
                        new DoubleRoom(conn, 2 , a);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    kindform1.dispose();
                } else {
                    try {
                        new TripleRoom(conn, 2 ,a);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    kindform1.dispose();
                }
            } else if (roomkind[2] == true) {
                if (s == 2) {
                    try {
                        new DoubleRoom(conn, 3 , a);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    kindform1.dispose();
                } else {
                    try {
                        new TripleRoom(conn, 3 , a);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    kindform1.dispose();
                }
            }
        };
        continuebtn.addActionListener(actionListener);

        kindform1.add(kindpanel, BorderLayout.LINE_START);
        kindform1.add(continuepanel, BorderLayout.AFTER_LAST_LINE);
        kindform1.pack();
        kindform1.setLocationRelativeTo(null);
        kindform1.setResizable(false);
        kindform1.setLayout(null);
        kindform1.setVisible(true);
    }
}
