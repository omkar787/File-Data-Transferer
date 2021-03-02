import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args){
        JFrame fr = new JFrame("File Data Transfer");
        final String[] one = new String[2];


        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField t1 = new JTextField(50);
        JTextField t2 = new JTextField(50);
        t1.setBounds(100,50,300,40);
        t2.setBounds(100,150,300,40);

        JButton btn1 = new JButton("Select input file");
        JButton btn2 = new JButton("Select output file");
        JButton btn3 = new JButton("Next");
        btn1.setBounds(350,50,200,40);
        btn2.setBounds(350,150,200,40);
        btn3.setBounds(130,200,200,40);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fch = new JFileChooser();
                fch.setCurrentDirectory(new File(System.getProperty("user.home")));
                int res = fch.showOpenDialog(fr);
                if(res == JFileChooser.APPROVE_OPTION){
                    File sel = fch.getSelectedFile();
                    one[0] = sel.getAbsolutePath();
                    t1.setText(sel.getAbsolutePath());
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fch = new JFileChooser();
                fch.setCurrentDirectory(new File(System.getProperty("user.home")));
                int res = fch.showOpenDialog(fr);
                if(res == JFileChooser.APPROVE_OPTION){
                    File sel = fch.getSelectedFile();
                    one[1] = sel.getAbsolutePath();
                    t2.setText(sel.getAbsolutePath());
                }
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataTransfer o = new DataTransfer();
                try {
                    o.doit(one[0], one[1]);
                    t1.setText("Success");
                    t2.setText("Success");

                }catch (IOException i){
                    t1.setText("Error");
                    t2.setText("Error");
                }
            }
        });


        fr.add(t1);
        fr.add(btn1);
        fr.add(t2);
        fr.add(btn2);
        fr.add(btn3);
        fr.setSize(900,600);
        fr.setLayout(null);
        fr.setVisible(true);

    }
}
