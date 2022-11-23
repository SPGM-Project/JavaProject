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
    JButton deQueueBtn = new JButton("DeQueue");
    JButton queueInitBtn = new JButton("Queue Init");

    JTextField textField = new JTextField(10);

    JPanel upperPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel lowerPanel = new JPanel();

    JLabel queueLabel = new JLabel();
    JLabel explainLabel = new JLabel();

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

        lowerPanel.add(explainLabel);
        add(lowerPanel, BorderLayout.SOUTH);

        enQueueBtn.addActionListener(this);
        deQueueBtn.addActionListener(this);
        queueInitBtn.addActionListener(this);

        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == enQueueBtn) {
            if ((queue.rear + 1) % queue.Queue_Size == queue.front) {
                explainLabel.setText("큐가 꽉 참.");
                return;
            }
            queue.enQueue(Integer.parseInt(textField.getText()));
            printAll();
        } else if (e.getSource() == deQueueBtn) {
            queue.deQueue();
            if (queue.front == queue.rear) {
                queueLabel.setText("큐가 비어있음.");
                return;
            }
            printAll();
        } else if (e.getSource() == queueInitBtn) {
            queue.init();
            queueLabel.setText("큐가 비어있음.");
        }
    }

    void printAll() {
        queueLabel.setText("");

        queueLabel.setText("[Front]   ");

        for(int i = queue.front; (i % queue.Queue_Size) != queue.rear; i++ ){
            if ((i+1) % queue.Queue_Size == queue.rear) {
                queueLabel.setText( queueLabel.getText() + "   [" + queue.Queue[(i+1)%queue.Queue_Size] + " (Rear)]   ");
            }
            else {
                queueLabel.setText( queueLabel.getText() + "   [" + queue.Queue[(i+1)%queue.Queue_Size] + "]   ");
            }
        }

        queueLabel.setText(queueLabel.getText() + "   =>      [Front]");
    }
}