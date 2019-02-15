package Service;

import Information.ExitPay;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;

public class FridgeService {

    public FridgeService() {

        final int[] soda1cost = {0};
        final int[] soda2cost = {0};
        final int[] soda3cost = {0};
        final int[] water1cost = {0};
        final int[] water2cost = {0};
        final int[] water3cost = {0};
        final int[] cake1cost = {0};
        final int[] cake2cost = {0};
        final int[] cake3cost = {0};
        final int[] shokolat1cost = {0};
        final int[] shokolat2cost = {0};
        final int[] shokolat3cost = {0};

        JFrame fridgeform = new JFrame("Fridge Form");
        fridgeform.setSize(320, 450);
        JCheckBox shokolat1 = new JCheckBox("Kitkat");
        JCheckBox shokolat2 = new JCheckBox("Buonty");
        JCheckBox shokolat3 = new JCheckBox("kinder");
        JCheckBox soda1 = new JCheckBox("Pepsi");
        JCheckBox soda2 = new JCheckBox("Coca");
        JCheckBox soda3 = new JCheckBox("7Up");
        JCheckBox water1 = new JCheckBox("Water");
        JCheckBox water2 = new JCheckBox("Water");
        JCheckBox water3 = new JCheckBox("Water");
        JCheckBox cake1 = new JCheckBox("Cake1");
        JCheckBox cake2 = new JCheckBox("Cake2");
        JCheckBox cake3 = new JCheckBox("Cake3");
        JButton continuebtn = new JButton("Apply");
        shokolat1.setBounds(10, 10, 80, 30);
        shokolat2.setBounds(110, 10, 80, 30);
        shokolat3.setBounds(210, 10, 80, 30);
        soda1.setBounds(10, 110, 80, 30);
        soda2.setBounds(110, 110, 80, 30);
        soda3.setBounds(210, 110, 80, 30);
        water1.setBounds(10, 210, 80, 30);
        water2.setBounds(110, 210, 80, 30);
        water3.setBounds(210, 210, 80, 30);
        cake1.setBounds(10, 310, 80, 30);
        cake2.setBounds(110, 310, 80, 30);
        cake3.setBounds(210, 310, 80, 30);
        continuebtn.setBounds(110, 370, 100, 30);


        soda1.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    soda1cost[0] = 1;
                } else {
                    soda1cost[0] = 0;
                }
            }
        });
        soda2.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    soda2cost[0] = 1;
                } else {
                    soda2cost[0] = 0;
                }
            }
        });

        soda3.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    soda3cost[0] = 1;
                } else {
                    soda3cost[0] = 0;
                }
            }
        });

        water1.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    water1cost[0] = 1;
                } else {
                    water1cost[0] = 0;
                }
            }
        });
        water2.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    water2cost[0] = 1;
                } else {
                    water2cost[0] = 0;
                }
            }
        });

        water3.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    water3cost[0] = 1;
                } else {
                    water3cost[0] = 0;
                }
            }
        });
        cake1.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cake1cost[0] = 1;
                } else {
                    cake1cost[0] = 0;
                }
            }
        });
        cake2.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cake2cost[0] = 1;
                } else {
                    cake2cost[0] = 0;
                }
            }
        });

        cake3.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cake3cost[0] = 1;
                } else {
                    cake3cost[0] = 0;
                }
            }
        });

        shokolat1.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    shokolat1cost[0] = 1;
                } else {
                    shokolat1cost[0] = 0;
                }
            }
        });
        shokolat2.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    shokolat2cost[0] = 1;
                } else {
                    shokolat2cost[0] = 0;
                }
            }
        });

        shokolat3.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    shokolat3cost[0] = 1;
                } else {
                    shokolat3cost[0] = 0;
                }
            }
        });

        ActionListener actionListener = e ->
        {
            new ExitPay(water1cost[0], water2cost[0], water3cost[0], cake1cost[0], cake2cost[0], cake3cost[0], soda1cost[0], soda2cost[0], soda3cost[0], shokolat1cost[0], shokolat2cost[0], shokolat3cost[0]);
            fridgeform.dispose();
        };
        continuebtn.addActionListener(actionListener);

        fridgeform.add(continuebtn);
        fridgeform.add(shokolat1);
        fridgeform.add(shokolat2);
        fridgeform.add(shokolat3);
        fridgeform.add(soda1);
        fridgeform.add(soda2);
        fridgeform.add(soda3);
        fridgeform.add(water1);
        fridgeform.add(water2);
        fridgeform.add(water3);
        fridgeform.add(cake1);
        fridgeform.add(cake2);
        fridgeform.add(cake3);
        fridgeform.setLocationRelativeTo(null);
        fridgeform.setResizable(false);
        fridgeform.setLayout(null);
        fridgeform.setVisible(true);


    }

}
