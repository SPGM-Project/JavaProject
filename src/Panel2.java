import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel2 extends JPanel {
    Panel2() {
        setLayout(new BorderLayout());
        JPanel upperPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        
        upperPanel.add(new JTextField(10));
        upperPanel.add(new JLabel("월"));
        upperPanel.add(new JTextField(10));
        upperPanel.add(new JLabel("일"));
        
        add(upperPanel, BorderLayout.NORTH);        
        
        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        middlePanel.add(scrollPane);
        
        add(middlePanel, BorderLayout.CENTER);
        
        lowerPanel.add(new JButton("저장"));
        add(lowerPanel, BorderLayout.SOUTH);
        
        setVisible(false);
    }
}