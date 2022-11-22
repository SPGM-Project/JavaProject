import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel4 extends JPanel implements ActionListener {
    JButton enQueueBtn = new JButton("EnQueue");
    JButton queueInitBtn = new JButton("Queue Init");
    JButton deQueueBtn = new JButton("DeQueue");

    JTextField textField = new JTextField(10);

    JPanel upperPanel = new JPanel();
    JPanel middlePanel = new JPanel();

    JLabel queueLabel = new JLabel();

    JOptionPane aa = new JOptionPane();
	String number = aa.showInputDialog("Queue의 Size 입력");
    int num = Integer.valueOf(number);
    Queue queue = new Queue(num);
    
    Panel4() {
        setLayout(new BorderLayout());

        upperPanel.add(new JLabel("Queue"));
        upperPanel.add(textField);
        upperPanel.add(new JLabel("정수값 입력"));
        upperPanel.add(enQueueBtn);
        upperPanel.add(deQueueBtn);
        upperPanel.add(queueInitBtn);
        add(upperPanel, BorderLayout.NORTH);
        
        middlePanel.add(queueLabel);
        add(middlePanel, BorderLayout.CENTER);

        enQueueBtn.addActionListener(this);
        deQueueBtn.addActionListener(this);
        queueInitBtn.addActionListener(this);
        
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == enQueueBtn) {
            queue.enQueue(Integer.parseInt(textField.getText()));
            queueLabel.setText("");
        }
        else if (e.getSource() == deQueueBtn) {

        }
        else if (e.getSource() == queueInitBtn) {

        }
    }
}