import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel2 extends JPanel {
    Panel2() {
        JPanel upperPanel = new JPanel();
        upperPanel.add(new JLabel("LinkedList"));
        upperPanel.add(new JTextField(10));
        upperPanel.add(new JLabel("정수값 입력"));
        add(upperPanel, BorderLayout.NORTH);
        add(new JButton("Node추가"));
        add(new JButton("Node추가"));
        
        setVisible(false);
    }
}