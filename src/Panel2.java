import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Panel2 extends JPanel {
    int cnt = 0;
    Panel2() {
        setLayout(new BorderLayout());

        LinkedList linkedList = new LinkedList();

        JPanel upperPanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        JPanel middlePanel = new JPanel();

        JTextField jf = new JTextField(10);
        upperPanel.add(new JLabel("LinkedList"));
        upperPanel.add(jf);
        upperPanel.add(new JLabel("<-정수값 입력"));
        JButton formBTN = new JButton("추가");
        upperPanel.add(formBTN);
        JButton delBTN = new JButton("삭제");
        upperPanel.add(delBTN);
        JTextField jfU = new JTextField(10);
        upperPanel.add(jfU);
        upperPanel.add(new JLabel("<-update"));
        JButton updateBTN = new JButton("Node Update");
        upperPanel.add(updateBTN);
        JLabel alert = new JLabel("알림");
        lowerPanel.add(alert);
        JButton initBTN = new JButton("초기화");
        lowerPanel.add(initBTN);
        
        add(upperPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(lowerPanel, BorderLayout.SOUTH);
        setVisible(false);
        ActionListener listener = new ActionListener() {
        
        ArrayList<JButton> jbtns = new ArrayList<JButton>();
        ArrayList<JLabel> jlbs = new ArrayList<JLabel>();

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(e.getSource() == formBTN){
                    try {
                        String jft = jf.getText();
                        int intj = Integer.valueOf(jft);

                        linkedList.insert(intj);

                        jbtns.add(new JButton(jft));
                        middlePanel.add(jbtns.get(cnt));
                        jlbs.add(new JLabel("=>"));
                        middlePanel.add(jlbs.get(cnt++));
                        alert.setText(String.valueOf(cnt));
                    } catch (Exception events) {
                        // TODO: handle exception
                        alert.setText("넣을 값이 없음");
                        return;
                    }
                } else if(e.getSource() == updateBTN){

                } else if(e.getSource() == delBTN){

                }
            }
        };
        formBTN.addActionListener(listener);
    }

}