import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel3 extends JPanel {
    Panel3() {
        JPanel upperPanel = new JPanel();
        JPanel middlePanel = new JPanel();

        upperPanel.add(new JLabel("Stack"));
        upperPanel.add(new JTextField(10));
        upperPanel.add(new JLabel("정수값 입력"));
        add(new JButton("등록"));
        add(upperPanel, BorderLayout.NORTH);        
        
        setVisible(false);
    }
}