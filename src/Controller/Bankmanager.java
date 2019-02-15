package Controller;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bankmanager {
    public Bankmanager(Connection conn) throws Exception {

        Statement bankstatement3 = conn.createStatement();

        JFrame resultbank = new JFrame("Account");
        resultbank.setSize(500, 500);

        JLabel label2 = new JLabel("Not yet");
        JPanel panel2 = new JPanel();
        JScrollPane jScrollPane2 = new JScrollPane(panel2);
        jScrollPane2.setBounds(10, 10, 480, 460);

        ResultSet rs3 = bankstatement3.executeQuery("SELECT * FROM HotelAccount ;");

        String chat = "<html>";
        while (rs3.next()) {
            chat = chat.concat(rs3.getString("name") + " " + rs3.getString("lastname") +"  | Date: "+ rs3.getInt("daypayed") + "/" + rs3.getInt("monthpayed") + "/" + rs3.getInt("yearpayed") + "  |  Fee: " + rs3.getInt("fee") + "  IRR <br/> " + "-----------------------------------------------" + " <br/> ");
        }
        chat = chat.concat("</html>");
        label2.setText(chat);

        panel2.add(label2);
        resultbank.add(jScrollPane2);
        resultbank.setLocationRelativeTo(null);
        resultbank.setResizable(false);
        resultbank.setLayout(null);
        resultbank.setVisible(true);
    }
}
