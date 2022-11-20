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

public class Panel3 extends JPanel {
    int cnt = 5;
    Panel3() {
        JOptionPane aa = new JOptionPane();
		String number = aa.showInputDialog("stack의 size 입력");
        int num = Integer.valueOf(number);
        System.out.println(num);
        cnt = num;
        JPanel upperPanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        setLayout(new BorderLayout());
        
        
        upperPanel.add(new JLabel("Stack"));
        JTextField jf = new JTextField(10);
        upperPanel.add(jf);
        upperPanel.add(new JLabel("정수값 입력"));
        JButton formBTN = new JButton("등록");
        JButton delBTN = new JButton("삭제");
        JButton initBTN = new JButton("초기화");
        upperPanel.add(formBTN);
        upperPanel.add(delBTN);
        JLabel alert = new JLabel("알림");
        lowerPanel.add(alert);
        lowerPanel.add(initBTN);
        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);

        middlePanel.setLayout(new GridLayout(num,1));
        JButton btns[] = new JButton[num];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton("비어있음");
			middlePanel.add(btns[i]);
		}

        
        add(middlePanel, BorderLayout.CENTER);
        
        setVisible(false);
        Stack stack = new Stack(num);
        ActionListener listener = new ActionListener() {
    
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                if(e.getSource() == formBTN){
                    try {
                        String jft = jf.getText();
                        int intj = Integer.valueOf(jft);
                        if(cnt==0){
                            alert.setText("스택이 꽉찼음");
                            return;
                        }
                        alert.setText("");
                        if(cnt<num)
                            btns[cnt].setText("");
                        btns[--cnt].setText(jft);
                        stack.push(intj);
                        System.out.println(intj);
                        stack.peek();
                    } catch (Exception events) {
                        // TODO: handle exception
                        if(cnt == num-1){
                            return;
                        }
                        alert.setText("넣을 값이 없음");
                        return;
                    }
                }
                else if (e.getSource() == delBTN){
                    if(cnt==num){
                        alert.setText("지울 데이터가 없음");
                        return;
                    }
                    alert.setText("");
                    try {
                        btns[cnt].setText("비어있음");
                        btns[++cnt].setText(String.valueOf(stack.peek()));
                        stack.pop();
                    } catch (Exception event) {
                        // TODO: handle exception
                    }
                }
                else if (e.getSource() == initBTN){
                    alert.setText("");
                    for(int i = 0; i<num; i++){
                    btns[i].setText("비어있음");
                    }
                    cnt = num;
                    stack.init();
                }
                }
            
        }; 
        formBTN.addActionListener(listener);
        delBTN.addActionListener(listener);
        initBTN.addActionListener(listener);
    }
}