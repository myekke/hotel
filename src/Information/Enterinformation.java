package Information;

import Rooms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

public class Enterinformation {
    public Enterinformation(Connection conn , int a) throws Exception {
        JFrame infoform = new JFrame("INFORMATION");
        infoform.setSize(700, 700);

        JPanel roompanel = new JPanel();
        roompanel.setLocation(0, 0);
        roompanel.setBorder(BorderFactory.createTitledBorder("Rooms"));
        JCheckBox roomcheckbox1 = new JCheckBox("SingleRoom");
        JCheckBox roomcheckbox2 = new JCheckBox("Double");
        JCheckBox roomcheckbox3 = new JCheckBox("TripleRoom");
        JCheckBox roomcheckbox4 = new JCheckBox("QuadRoom");
        roompanel.add(roomcheckbox1);
        roompanel.add(roomcheckbox2);
        roompanel.add(roomcheckbox3);
        roompanel.add(roomcheckbox4);

        JPanel continuepanel = new JPanel();
        JButton continuebtn = new JButton("Continue");
        continuebtn.setSize(80, 30);
        continuepanel.add(continuebtn);

        Boolean[] roomkind = new Boolean[8];

        for (int i = 0; i < 8; i++) {
            roomkind[i] = false;
        }

        roomcheckbox1.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    roomkind[0] = true;
                } else {
                    roomkind[0] = false;
                }
            }
        });
        roomcheckbox2.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    roomkind[1] = true;
                } else {
                    roomkind[1] = false;
                }
            }
        });
        roomcheckbox3.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    roomkind[2] = true;
                } else {
                    roomkind[2] = false;
                }
            }
        });
        roomcheckbox4.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    roomkind[3] = true;
                } else {
                    roomkind[3] = false;
                }
            }
        });

        ActionListener actionListener = e -> {
            if (roomkind[0] == true) {
                try {
                    new SingleRoom(conn , a);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                infoform.dispose();
            } else if (roomkind[1] == true) {
                new Kinddoubletriple(conn , 2 , a );
                infoform.dispose();
            } else if (roomkind[2] == true) {
                new Kinddoubletriple(conn , 3 , a);
                infoform.dispose();
            } else if (roomkind[3] == true) {
                new Kindquad(conn , a);
                infoform.dispose();
            }
        };
        continuebtn.addActionListener(actionListener);

        infoform.add(roompanel, BorderLayout.LINE_START);
        infoform.add(continuepanel, BorderLayout.AFTER_LAST_LINE);
        infoform.pack();
        infoform.setLocationRelativeTo(null);
        infoform.setResizable(false);
        infoform.setLayout(null);
        infoform.setVisible(true);


    }
}
