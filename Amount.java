//To Calculate the loan interest taken in my village
package amount;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Amount extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, t4;
    JTextField t1, t2, t3, t5;
    JButton b;

    public Amount() {
        setTitle("DEVELOPER : VIKAS RAJ");
        setLayout(null);
        setResizable(false);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/vk.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(350, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 350, 300);
        add(image);
        setSize(350, 300);
        setLocation(500, 200);
        setVisible(true);
        l1 = new JLabel("ENTER DATE (YYYY-MM-DD) : ");
        l1.setBounds(10, 10, 200, 20);
        l1.setFont(new Font("Raleway", Font.BOLD, 12));
        l1.setForeground(Color.blue);
        image.add(l1);
        t1 = new JTextField();
        t1.setBounds(180, 10, 100, 20);
        image.add(t1);
        l2 = new JLabel("ENTER PRINCIPLE AMOUNT : ");
        l2.setBounds(10, 50, 200, 20);
        l2.setFont(new Font("Raleway", Font.BOLD, 12));
        l2.setForeground(Color.BLUE);
        image.add(l2);
        t2 = new JTextField();
        t2.setBounds(180, 50, 100, 20);
        image.add(t2);
        l3 = new JLabel("ENTER INTEREST AMOUNT : ");
        l3.setBounds(10, 90, 200, 20);
        l3.setFont(new Font("Serif", Font.BOLD, 12));
        l3.setForeground(Color.MAGENTA);
        image.add(l3);
        t3 = new JTextField();
        t3.setBounds(180, 90, 100, 20);
        image.add(t3);
        b = new JButton("CALCULATE");
        b.setBounds(120, 140, 130, 30);
        b.setFont(new Font("Raleway", Font.BOLD, 12));
        b.setForeground(Color.BLUE);
        image.add(b);
        try {
        if ((t1.equals(""))||(t1.equals(""))||(t1.equals(""))) {
            JOptionPane.showMessageDialog(null, "Date is Required....");
        } else {
            b.addActionListener(this);
        }    
        } catch (Exception e) {
        }

        l4 = new JLabel("TOTAL TIME  : ");
        l4.setBounds(10, 180, 200, 20);
        l4.setFont(new Font("Raleway", Font.BOLD, 12));
        l4.setForeground(Color.blue);
        image.add(l4);
        t4 = new JLabel();
        t4.setBounds(180, 180, 200, 20);
        t4.setFont(new Font("Raleway", Font.BOLD, 12));
        t4.setForeground(Color.blue);
        image.add(t4);
        l5 = new JLabel("TOTAL AMOUNT :");
        l5.setBounds(10, 210, 100, 20);
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setForeground(Color.blue);
        image.add(l5);
        t5 = new JTextField();
        t5.setBounds(180, 210, 100, 20);
        t5.setFont(new Font("Raleway", Font.BOLD, 12));
        t5.setForeground(Color.blue);
        image.add(t5);
    }

    public void actionPerformed(ActionEvent e) {
        try {

            if (e.getSource() == b) {
                String input = t1.getText();
                LocalDate dob = LocalDate.parse(input);
                if ((dob != null) && (LocalDate.now() != null)) {
                    int y = Period.between(dob, LocalDate.now()).getYears();
                    int m = Period.between(dob, LocalDate.now()).getMonths();
                    int d = Period.between(dob, LocalDate.now()).getDays();
                    String date = y + " Years " + m + " Months " + d + " Days";
                    t4.setText(date);
                    String p = t2.getText();
                    Float principle = Float.parseFloat(p);
                    String ir = t3.getText();
                    Float r = Float.parseFloat(ir);
                    int i = 1;
                    float j = 0;
                    if (y != 0) {
                        while (i <= y) {
                            float interest = (principle * 5) / 100;
                            principle = principle + interest * 12;
                            i++;
                        }
                    }
                    if (m != 0) {
                        float interest = (principle * r) / 100;
                        j = interest;
                        principle = principle + interest * m;
                    }
                    if (d != 0) {
                        j = j / 30;
                        principle = principle + d * j;
                    }
                    String pp = "" + principle + "  Rs.";
                    t5.setText(pp);
                    t5.setEditable(false);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Amount();
    }
}