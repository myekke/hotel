package Information;

import Rooms.DoubleRoom;
import Rooms.QuadRoom;
import Rooms.TripleRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

public class Kindquad {
    public Kindquad(Connection conn , int a) {
        JFrame kindform2 = new JFrame("Kind");
        kindform2.setSize(700, 700);

        JPanel kindpanel = new JPanel();
        kindpanel.setLocation(0, 0);
        kindpanel.setBorder(BorderFactory.createTitledBorder("Kind of Room"));
        JCheckBox kindcheckbox1 = new JCheckBox("Master");
        JCheckBox kindcheckbox2 = new JCheckBox("Vip");

        kindpanel.add(kindcheckbox1);
        kindpanel.add(kindcheckbox2);

        JPanel continuepanel = new JPanel();
        JButton continuebtn = new JButton("Continue");
        continuebtn.setSize(80, 30);
        continuepanel.add(continuebtn);

        Boolean[] roomkind = new Boolean[4];

        for (int i = 0; i < 4; i++) {
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

        ActionListener actionListener = e -> {
            if (roomkind[0] == true) {
                try {
                    new QuadRoom(conn , 1 , a);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                kindform2.dispose();
            } else if (roomkind[1] == true) {
                try {
                    new QuadRoom(conn , 2 , a);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                kindform2.dispose();
            }
        };
        continuebtn.addActionListener(actionListener);

        kindform2.add(kindpanel, BorderLayout.LINE_START);
        kindform2.add(continuepanel, BorderLayout.AFTER_LAST_LINE);
        kindform2.pack();
        kindform2.setLocationRelativeTo(null);
        kindform2.setResizable(false);
        kindform2.setLayout(null);
        kindform2.setVisible(true);
    }
}
